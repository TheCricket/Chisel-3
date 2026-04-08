# Changelog

All notable changes to this project will be documented in this file.

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
