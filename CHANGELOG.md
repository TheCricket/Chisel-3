# Changelog

All notable changes to this project will be documented in this file.

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
