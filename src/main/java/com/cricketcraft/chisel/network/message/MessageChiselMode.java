package com.cricketcraft.chisel.network.message;

import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.api.IChiselMode;
import com.cricketcraft.chisel.item.chisel.ChiselController;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageChiselMode implements IMessage {

    private String mode;

    public MessageChiselMode() {}

    public MessageChiselMode(IChiselMode mode) {
        this.mode = mode.name();
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        mode = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, mode);
    }

    public static class Handler implements IMessageHandler<MessageChiselMode, IMessage> {

        @Override
        public IMessage onMessage(MessageChiselMode message, MessageContext ctx) {
            ItemStack stack = ctx.getServerHandler().playerEntity.getActiveItemStack();
            if(stack != null && stack.getItem() instanceof IChiselItem) {
                ChiselController.setMode(Minecraft.getMinecraft().thePlayer, message.mode);
            }

            return null;
        }
    }
}
