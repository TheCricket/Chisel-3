# Authoring Builder's Handbook guides

The handbook reads server datapacks and synchronizes accepted guides and categories to players on login and after
`/reload`. No Java is needed to add content. This format currently targets Minecraft 26.1.2.

## Pack layout

```text
my-handbook-pack/
  pack.mcmeta
  data/example/chisel/handbook_categories/basics.json
  data/example/chisel/handbook_guides/stone_wall.json
```

The namespace in `data/example` belongs to the pack author. The `chisel/handbook_categories` and
`chisel/handbook_guides` directories are fixed. These files define `example:basics` and `example:stone_wall`;
subdirectories become part of the ID. For Chisel's namespace, `data/chisel/chisel/...` is intentional.

For 26.1.2, use:

```json
{
  "pack": {
    "description": "Example building guides",
    "min_format": [101, 1],
    "max_format": [101, 1]
  }
}
```

Place the pack folder in the world's `datapacks` directory. Enable it using `/datapack enable "file/my-handbook-pack"`
if necessary, then run `/reload`. Packs that define the same guide/category ID override the whole definition according
to normal pack priority; sections and category lists are not merged.

## Category definition

`data/example/chisel/handbook_categories/basics.json`:

```json
{
  "title": {"text": "Getting Started"},
  "description": {"text": "Simple material combinations for your first builds."},
  "icon": "minecraft:book",
  "sort_order": 10
}
```

`title`, `description`, and `icon` are required. The title must not be blank. An empty description produces a warning.
Category `sort_order` is optional, defaults to zero, and must be nonnegative. Lower values appear first, with
identifier-string ordering for ties. Only categories containing accepted guides appear in contents.

Icons are **item IDs**, including block items: `minecraft:book`, `minecraft:diamond_pickaxe`, and
`minecraft:stone_bricks` all work. Unknown icons warn and render without an icon; they do not reject the content.

## Guide definition

`data/example/chisel/handbook_guides/stone_wall.json`:

```json
{
  "title": {"text": "A Weathered Stone Wall"},
  "description": {"text": "Use a restrained mix of stone textures to suggest age."},
  "icon": "minecraft:stone_bricks",
  "categories": ["example:basics"],
  "sort_order": 10,
  "sections": [
    {"type": "chisel:text", "text": {"text": "Start with stone bricks as the main surface."}},
    {"type": "chisel:tip", "text": {"text": "Keep moss sparse so it reads as an accent."}},
    {
      "type": "chisel:palette",
      "title": {"text": "Weathered Stone"},
      "entries": [
        {"block": "minecraft:stone_bricks", "role": "primary", "weight": 60},
        {"block": "minecraft:cobblestone", "role": "secondary", "weight": 30},
        {"block": "minecraft:mossy_stone_bricks", "role": "accent", "weight": 10}
      ]
    }
  ]
}
```

All fields except `sort_order` are required. `categories` may be empty; a guide must have a nonblank title and at least
one section. Guide `sort_order` is an integer defaulting to zero; negative values are allowed. Lower values appear first
in both All Guides and category lists, with identifier-string ordering for ties.

A guide may belong to several categories. Repeated category IDs produce a warning and appear only once per category.
Unknown categories produce warnings after loading, but the guide remains accessible through All Guides. All Guides is a
built-in UI entry, not a reserved category ID.

### Sections

| Type             | Required fields                    | Behavior                                    |
|------------------|------------------------------------|---------------------------------------------|
| `chisel:text`    | `text` component                   | Wrapped body text, continued across pages   |
| `chisel:tip`     | `text` component                   | Wrapped text in a shaded box                |
| `chisel:palette` | `title` component, `entries` array | Weighted block list, continued across pages |

Palette titles must not be blank and entry lists must not be empty. Each entry requires a **block ID**, a role
(`primary`, `secondary`, `accent`, or `rare`), and an integer weight from **1 to 100**. Weights are relative: totals
need not equal 100. Displayed percentages are rounded individually and can total slightly above or below 100. Roles are
stored in the data; the current palette rows show block names and percentages rather than role labels.

Unknown palette blocks warn and display their identifier without an icon. Duplicate blocks warn. Invalid JSON, invalid
identifiers, unsupported section types, missing required fields, or out-of-range weights prevent the affected guide from
loading. Check the game/server log for decoding errors and `Chisel/Handbook` validation messages.

### Text and translation

Text fields accept Minecraft components. Use `{"text": "Literal text"}` for a standalone datapack or
`{"translate": "example.guide.stone_wall.title"}` for localization. Client translations must be supplied by a mod or
resource pack under `assets/example/lang/<locale>.json`; a server datapack alone does not distribute language assets.
The handbook preserves component styling and wraps titles and text.

Category descriptions are clipped to the physical left page. Keep them concise; Shift-hovering the category row exposes
its full title and description in a tooltip. Guide/category list titles occupy at most two lines, also with full
Shift-hover tooltips.

## Navigation and reloading

Open the cover, choose a category (or All Guides), and select a guide. Lists show five rows per page. The left arrow
moves backward, then returns to the parent list from the first guide spread, and to contents from the first
category-list page. Escape closes the handbook. Hold Shift over a list row for its full title and description.

On `/reload`, the client publishes guides and category metadata together. A selected guide is preserved by ID while it
still belongs to the selected category. Page positions are preserved where possible and clamped when content shrinks.
Removing an active category or all of its guides returns to contents; removing the active guide or its category
membership returns to its surviving parent list. Disconnecting clears the client data. Missing categories and
uncategorized guides remain accessible through All Guides.

## Development samples and release checks

The opt-in sample pack is in [`dev/handbook-samples`](../dev/handbook-samples). Copy it into a disposable world's
`datapacks` folder and enable it. It contains the stress guide, ten pagination guides, and the Testing category. It is
outside all Gradle resource source sets and is not included in the mod jar. No test module is required.

Before release, verify in a disposable world:

1. With only the mod installed, contents shows Getting Started and Palettes, with no Testing category or
   pagination/stress guides.
2. With the sample pack enabled, traverse all list pages and guide spreads; go back and confirm page positions. Repeat
   at different GUI scales/window sizes. Check that row edges agree with hover highlights and clicks.
3. Shift-hover categories, All Guides, and guides with long text; releasing Shift hides the tooltip. Check item icons
   and a missing icon ID.
4. While the book is open, use `/reload` (from another operator or a server console) after editing titles, icons,
   ordering, or sections. Confirm updated content and valid selections/page positions.
5. Remove a selected guide, its category membership, and then its category in separate reloads. Check the documented
   fallbacks. Disable all guides and verify All Guides shows the empty message.
6. Disconnect and reconnect; verify the correct server's content arrives. Check a second server or world with different
   content to detect stale data.
7. Run `./gradlew.bat compileJava jar`; inspect the jar to confirm development samples are absent.

The screen delegates selection/reload/page state to `HandbookNavigation`, shared drawing/hit-test geometry to
`HandbookLayout`, and rendering/Shift tooltips to `HandbookRenderer`. New navigation behavior belongs in the navigation
model; new visual elements belong in the renderer and existing paginator/page model.
