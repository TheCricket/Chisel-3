package io.github.chiselteam.chisel.datagen.lang;

import io.github.chiselteam.chisel.util.LangHelper;

public final class HandbookLang {

    private HandbookLang() {
    }

    public static void addTranslations(LangHelper lang) {
        addGeneralGuideTranslations(lang);
        addUnderstandingBlockPalettes(lang);
    }

    private static void addGeneralGuideTranslations(LangHelper lang) {
        lang.add("chisel.builders_handbook.title", "Builders Handbook");
        lang.add("chisel.builders_handbook.contents", "Table of Contents");
        lang.add("chisel.builders_handbook.intro", "This book is meant to serve as inspiration for your builds, as well as helpful guides to take your builds to the next level!");
        lang.add("chisel.builders_handbook.empty", "There are no handbook guides available");
    }

    private static void addUnderstandingBlockPalettes(LangHelper lang) {
        var key = "chisel.guide.understanding_block_palettes";
        lang.add("%s.title".formatted(key), "Understanding Block Palettes");
        lang.add("%s.description".formatted(key), "Block palettes turn a group of materials into a reusable building style. Each block has a role and a weight that controls how often it appears.");
        lang.add("%s.roles".formatted(key), "Primary blocks establish the main surface and should appear most often. Secondary blocks add broad variation. Accent blocks create noticeable details, while rare blocks should be used sparingly to draw attention.");
        lang.add("%s.roles_tip".formatted(key), "A block's role explains why it belongs in the palette. Its weight controls how frequently the Mason's Trowel selects it.");
        lang.add("%s.weathered_stone".formatted(key), "Weathered Stone");
        lang.add("%s.weights".formatted(key), "Weights are relative. A block with weight 20 is twice as likely to be selected as a block with weight 10. They do not need to total 100, although totals of 100 are often easier to read.");
        lang.add("%s.variation_tip".formatted(key), "Pure randomness can look noisy. Let the primary material dominate, then use accents and rare blocks to create controlled variation.");
    }
}
