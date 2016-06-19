package com.cricketcraft.chisel.network;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.network.message.MessageChiselMode;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler{

    public static final SimpleNetworkWrapper INSTANCE = new SimpleNetworkWrapper(Chisel.MOD_ID);

    public static void init() {
        int id = 0;
        INSTANCE.registerMessage(MessageChiselMode.Handler.class, MessageChiselMode.class, id++, Side.SERVER);
    }
}
