package com.cricketcraft.chisel.util;

public class BlockVariant implements Comparable<BlockVariant> {
    private int meta;
    private boolean connects;
    private String name;

    public BlockVariant(int meta, String name, boolean canConnect) {
        this.meta = meta;
        this.name = name;
        this.connects = canConnect;
    }

    public BlockVariant(int meta, String name) {
        this(meta, name, false);
    }

    public int getMeta() {
        return this.meta;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(BlockVariant variant) {
        return this.meta;
    }

    public boolean hasConnectedTextures() {
        return this.connects;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
