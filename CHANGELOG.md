# Changelog

All notable changes to this project will be documented in this file.

## [26.1.2.18]

### Added

- **Measuring Tape**: Added a tool for measuring distances between blocks, with an in-world overlay.
- **Block Families**: Added Blackstone, Gilded Blackstone, Mossy Blackstone, Sea Lantern, Tuff, Calcite, Dripstone block
  sets.
- **Concrete**: Added colored concrete variants.
- **Variants**: Expanded Quartz, Ancient Stone, Antiblock, and numerous other block families.
- **Compatibility**: Expanded modded block families, including Applied Energistics 2
  and Occultism.
- **Pillars**: Added support for placing pillar variants along different axes.

### Changed

- **Chisel Menu**: Updated the layout, search and scrolling controls, and block preview with smoother rotation.
- **Ball o' Moss**: Reworked moss into persistent overlays with randomized textures and a tag for blocks that cannot
  be mossed.
- **Antiblock**: Updated connected textures and shadeless rendering.
- **Dependencies**: Updated NeoForge to `26.1.2.106`, JEI to `29.6.2.31`, and CTM to `26.1.2.8`.

### Fixed

- **Auto Chisel**: Fixed compatibility with FastWorkbench and corrected stack limits in input slots and item-pipe
  automation.
- **Builder's Guide**: Fixed block placement and preview handling so filled positions are skipped.
- **Glass and Ice**: Fixed connected-texture rendering and inventory models.
- **Bookshelves**: Chisel bookshelves now contribute to enchanting power.
- **Block Tags**: Corrected mining tools and harvest requirements, and added missing Marble and Limestone item tags.
- **Creative Tabs**: Added missing block families.
- **Textures and Models**: Fixed Futura screen jitter and various missing or incorrect textures and generated models.

## [26.1.2.17]

### Fixed

- **Dedicated Servers**: Fixed crashes caused by client-only key mappings, event handlers, and model code loading
  on the server.
- **Quartz**: Added the missing pillar bottom texture.

## [26.1.2.16]

### Added

- **Block Families**: Added Deepslate, Warped, Pale Oak, Cherry, and Mangrove block sets.
- **Copper**: Added Copper Weathering in a data driven system other mods can implement!
- **Futura**: Added Matrix variants.
- **Jade Compatibility**: Jade now shows descriptions!.
- **Auto Chisel**: Added item-pipe automation capabilities and an updated interface.
- **Chisel Selection**: Added an in-world selection overlay that outlines all blocks affected by the selected mode.

### Changed

- **Chisel Menu**: Improved interactions, shift-click behavior, mode selection, and search so descriptions are included.
- **Quartz and Futura**: Updated textures, models, and variant names for consistency.
- **Dependencies**: Updated CTM to `26.1.2.4`.
- **Localization**: Unified several variant names and improved Builder's Guide tooltip readability.
- **Chisel Durability**: Completely disable it by changing it to 0 in the configs!

### Fixed

- **Auto Chisel**: Prevented non-chiselable blocks from entering input slots and corrected exponential speed-upgrade
  stacking.
- **Automation**: Fixed quick-moving upgrade and chisel items and improved item-pipe handling.

## [26.1.2.15]

### Fixed
- **Sound**: Fixed fallback sound.

## [26.1.2.14]

### Fixed
- **Fluid Interaction**: Removed logging.

## [26.1.2.13]

### Added
- **Bamboo**: Added more Bamboo variants (credit: Cebularz).
- **Worldgen**: Marble and Limestone now have their own cobble-gen type generation.
- **Builder's Guide**: Cubes, Cylinders, Domes, and more are now super easy to build!

### Changed
- Updated project to Minecraft `26.1.2` and NeoForge `26.1.2.76`.
- Bumped dependency versions:
  - JEI `29.5.0.26`
  - CTM `26.1.2.2`
- Updated **CTMLib** version.
- Community: Added Cebularz and Buddy610 to VIPs.

### Fixed
- Resolved issue `#29`.
- Added compat for Mystical Agriculture in `#27`
- Implemented a temporary workaround for `#28`.

## [3.0.12]

### Added
- **Bamboo**: Added the Bamboo block family with a set of variants.
- **Neovitae**: Added the Neovitae block family with a full set of variants (Arranged, Bricks, Carved, Classic, etc.).

### Changed
- **CTM is now a Library**: CTM is now its own library mod

## [3.0.11]

### Added
- **Chisel Modes**: Reintroduced selectable Chisel modes for more flexible chiseling behavior.
- **Stat Tracking**: Track how many blocks you've chiseled — just for fun!
- **Eldritch Rendering**: New eldritch rendering pass for Temple Blocks.
- **Optional Tags**: Support for optional tags to improve cross-mod compatibility.

### Changed
- **CTM System Refactor**: Moved the connected-textures system from `client.ctm` to `lib.ctm`, with geometry and utility layers extracted into their own packages for cleaner separation.
- **Variant Model Handling**: Refactored `VariantModelType` into individual `VariantModelHandler` classes, simplifying the variant model hierarchy and registration.
- **Mod Compatibility**: Adjusted compatibility with other mods and polished the Chisel UI.

### Fixed
- **FramedBlocks**: Fixed an issue with FramedBlocks gates.
- **Torches**: Fixed torch placement and torch icons in creative tabs.
- **Chisel UI**: Various UI fixes and polish.

## [3.0.10]

### Added
- **Compatibility**: Built in compatibility with FTB Materials and AllTheOres!
- **16 new block families**: Ancient Stone, Arcane, Certus, Charcoal, Coal, Coal Coke, Diabase, End Stone, Magma, Prismarine, Purpur, Red Sandstone, Redstone Lamp, Tallow, Terracotta, and Thaumium — each with their own full set of chiseled variants.
- **Offset Tool**: a new item that lets you shift the connecting texture pattern of vertical-variant blocks on a per-chunk basis.
  - Right-click a supported block to cycle its texture offset for that chunk — the change is instant and persists across saves.
  - While holding the tool, an in-world overlay draws an "X" and a translucent arrow on the face you're aiming at, showing exactly which direction the offset will move.
- **New connecting-texture styles**:
  - **R4 / R9 / R16** — each block randomly picks one of 4, 9, or 16 sub-textures and uses it on all six faces, giving natural variation without manual placement.
  - **V9 / V16** — larger vertical pattern atlases (3×3 and 4×4), joining the existing V4 for taller, more detailed vertical motifs.

### Changed
- **Technical** textures cleaned up: every file in the new technical texture folder now follows the project's `technical_*` naming, and the `scaffoldlarge` set was renamed to `scaffold_large` for consistency.
- Lots of polish across existing families (Bookshelf, Glass, Laboratory, Redstone, Sandstone, Stained Glass, Stained Glass Pane, Technical, Wool) — new variants, better connecting-texture coverage, and tag-based inclusion fixes.

### Removed
- The standalone **Carpet** family has been retired; carpet variants are now handled through the wool/vanilla path.

### Fixed
- Various rendering fixes across the connecting-texture system surfaced while building out the new R/V variants and the Offset Tool overlay.

## [3.0.9]

### Hotfix
- Forgot to add crafting recipes for some blocks.

## [3.0.8]

### Added
- Added **Auto Chisel**.
- Added more **Block Tags** for better mod compatibility.
- Added **JEI Compatibility** for Chisel recipes.
- Added support for adding blocks to a **Variant Family** via tags.

### Changed
- Updated **Codecs** for better data handling.
- Refactored various internal components for better performance.

### Fixed
- Fixed **localization** issues for several blocks.
- Fixed textures for **Zag** and **HexPlating**.
- Added missing particles for **Grimstone** and **Holystone**.

## [3.0.7]

### Fixed
- Blocks are now mined with tools!

## [3.0.6]

### Added
- Added back **Carpet** blocks for all colored wool variants.
- Added back **Lavastone** variants: Array, Chaotic Bricks, Cuts, Jellybean, and Slanted.
- Added **Durability** to Chisels:
  - Iron Chisel: 512 uses.
  - Diamond Chisel: 5096 uses.
  - Obsidian Chisel: 10048 uses.
- Added an **Item Overlay** to the Chisel's inventory icon, showing the block currently stored inside.
- Added new **Connected Texture (CTM)** and **Multiblock** model types:
  - Multiblock 2x2, 3x3, and 4x4 support.
  - Connected Top-Bottom-Side (CTM TBS) support.
  - Horizontal (CTMH) and Vertical (CTMV) connection support.
  - V4 model support (4-variant random textures).
  - Added CTM support to **Bookshelves**.
- Added a `clientAuth` run configuration for development.

### Changed
- Refactored `CTM_MULTI_PASS_MULTIBLOCK` templates to support multiple texture layers.
- Improved CTM logic and variant registration for better performance and flexibility.
- Promoted version from **Beta** to **Release!**.
- Updated and localized descriptions for numerous blocks.

### Fixed
- Fixed **Lavastone** multiblock models incorrectly using water textures instead of lava.
- Updated Lavastone models to use the correct parent model and layers.
- Fixed numerous texture issues across multiple block families:
  - **Factory**: Fixed various technical and metal textures.
  - **Electrum**: Fixed inconsistent texture patterns.
  - **Stone/Dirt/Cobblestone**: Fixed various alignment and missing texture issues.
  - **Diorite/Andesite/Granite**: Improved CTM transitions.
  - **Wood Planks**: Fixed several orientation issues (Dark Oak, Acacia, etc.) and added missing **Braced** variant textures.
  - **Military/Shingles**: Added missing textures for Imperial/Rebel Camo and various Shingles.
- Fixed a duplication bug in the Chisel menu.
- Fixed several server-side crashes related to menu operations and block events.
- Fixed many cases of missing or incorrect blockstate definitions.

## [3.0.5]

### Added
- New Items:
  - Implemented **Cloud in a Bottle**, **Bottle of Moss**, and **Smashing Rock**.
- Chisel GUI Enhancements:
  - Added a **Search Bar** to the Chisel GUI to easily find specific block variants.
  - Added **Scrolling** support to the Chisel GUI for block families with more than 60 variants.

### Changed
- Redesigned the **Chisel GUI**:
    - Increased the number of visible variants.

### Fixed
- Fixed **Stained Glass and Panes**.
- Fixed several **Spruce textures**.
- Fixed a **server crash** during menu operations.
- Fixed numerous **missing texture issues**.
- Fixed **Lavastone** particle textures.
- The item placed in the Chisel's input slot is now saved to the Chisel itself (stored in NBT).

Note: 3.0.4 was a quick hotfix for that server crash

## [3.0.3]

### Added
- Added back Pumpkins and Jack o' Lanterns.

### Changed
- Massive texture update and fix across a wide range of blocks:
  - Technical, Road lines, Sandstone, Stone Bricks.
  - Valentines, Voidstone, and Woolen Clay.
  - Torches (Not 100% working yet!).
- Significant datagen improvements and refactoring.

### Fixed
- Fixed many texture and rendering issues.

## [3.0.2]

### Added
- World gen! Both Marble and Limestone will be found around the world.
- Bookshelves: Added wood-specific bookshelves for all 12 wood types (Oak, Spruce, Birch, Jungle, Acacia, Dark Oak, Mangrove, Cherry, Pale Oak, Bamboo, Crimson, Warped).

### Changed
- Massive texture update/rename/fix across almost all blocks (over 3000 files affected).

### Fixed
- Removed redundant/obsolete blocks: Packed Ice, Packed Ice Pillar, and Paperwall (consolidated).

## [3.0.1]

### Added
- Extensive CTM (Connected Texture Model) support for various block families:
    - Wood planks: Acacia, Birch, Dark Oak, Jungle, Oak, Spruce.
    - Stone: Andesite, Diorite, Granite, Limestone, Marble.
    - Metals and modded metals: Aluminum, Bronze, Cobalt, Copper, Electrum, Gold, Invar, Iron, Lead, Nickel, Platinum, Silver, Steel, Tin, Uranium.
    - Other blocks: Antiblock, Cloud, Concrete, Laboratory, Tyrian, Voidstone, and more.
- New blockstates and models for factory blocks (Grinder, Gold Plate, Gold Plating, Ice, etc.).

### Changed
- Refactored CTM logic and model implementation:
    - Updated `UnbakedConnectedTextureBlockStateModel` and `ConnectedTextureBlockStateModel`.
    - Improved `CTMData` and `CTMLogic`.
    - Optimized `ConnectedTextureBlockModelPart`.
- Updated `gradle.properties` with newer NeoForge versions.

### Fixed
- Fixed various CTM rendering and logic issues.
