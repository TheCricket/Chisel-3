package com.cricketcraft.chisel.item.chisel;

import com.cricketcraft.chisel.api.CarvingRegistry;
import com.cricketcraft.chisel.api.ICarvingRecipe;
import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.api.IChiselMode;
import com.cricketcraft.chisel.init.ChiselSound;
import com.google.common.base.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class ChiselController {
    public static final ChiselController INSTANCE = new ChiselController();

    private static final String MODE_KEY = "chiselMode";

    private long lastTickClick = 0;

    private ChiselController() {

    }

    public void preInit() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onInteract(PlayerInteractEvent.LeftClickBlock event) {
        EntityPlayer player = event.getEntityPlayer();
        ItemStack held = player.getItemStackFromSlot(event.getHand() == EnumHand.OFF_HAND ? EntityEquipmentSlot.MAINHAND : EntityEquipmentSlot.OFFHAND);

        if (held == null || !(held.getItem() instanceof IChiselItem)) {
            return;
        }
        if(player.capabilities.isCreativeMode) {
            event.setCanceled(true);
        }

        IBlockState state = event.getWorld().getBlockState(event.getPos());
        Block block = state.getBlock();
        int meta = block.getMetaFromState(state);

        ItemStack stack = new ItemStack(block, 1, meta);
        getMode(player).chisel(player, event.getWorld(), event.getPos(), event.getFace(), CarvingRegistry.getRecipeFromItemStack(stack));
        held.damageItem(1, player);
    }

    /**
     * @param recipe
     * @param stack The block that is being chiseled in the world.
     */
    public static boolean chiselBlockInWorld(ICarvingRecipe recipe, ItemStack stack, BlockPos pos, World world, boolean isShifting) {
        int var = 0;
        for(int c = 0; c < recipe.getChiselResults().length; c++) {
            if(recipe.getChiselResults()[c].isItemEqual(stack)) {
                var = c;
            }
        }
        ItemStack out;
        if(isShifting) {
            if(var - 1 < 0)
                var = recipe.getChiselResults().length;
            out = recipe.getChiselResults()[var - 1];
        } else {
            out = recipe.getChiselResults()[var + 1 > recipe.getChiselResults().length - 1 ? 0 : var + 1];
        }

        Block block = Block.getBlockFromItem(out.getItem());
        IBlockState state = block.getStateFromMeta(out.getItemDamage());

        if(block.getMaterial(state) == Material.WOOD) {
            //world.playSound((EntityPlayer) null, pos.getX(), pos.getY(), pos.getZ(), ChiselSound.chiselWood, SoundCategory.NEUTRAL, 1, 1);
        } else {
            //world.playSound((EntityPlayer) null, pos.getX(), pos.getY(), pos.getZ(), ChiselSound.chiselFallback, SoundCategory.NEUTRAL, 1, 1);
        }

        return world.setBlockState(pos, state);
    }

    public static IChiselMode getMode(EntityPlayer player) {
        if(player != null) {
            if(Strings.isNullOrEmpty(player.getEntityData().getString(MODE_KEY))) {
                player.getEntityData().setString(MODE_KEY, ChiselMode.SINGLE.name());
            }

            return Enum.valueOf(ChiselMode.class, player.getEntityData().getString(MODE_KEY));

        } else
            return ChiselMode.SINGLE;
    }

    public static void setMode(EntityPlayer player, String name) {
        player.getEntityData().setString(MODE_KEY, name);
    }

    public enum ChiselMode implements IChiselMode {
        SINGLE {
            @Override
            public void chisel(EntityPlayer player, World world, BlockPos pos, EnumFacing facing, ICarvingRecipe recipe) {
                ItemStack stack = new ItemStack(world.getBlockState(pos).getBlock(), 1, world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos)));
                chiselBlockInWorld(recipe, stack, pos, world, player.isSneaking());
            }

            @Override
            public IChiselMode next() {
                return PANEL;
            }
        },
        PANEL {
            @Override
            public void chisel(EntityPlayer player, World world, BlockPos pos, EnumFacing facing, ICarvingRecipe recipe) {
                IBlockState state = world.getBlockState(pos);
                ItemStack stack = new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state));
                int xPos = pos.getX();
                int yPos = pos.getY();
                int zPos = pos.getZ();

                for(int x = -1; x <= 1; x++) {
                    for(int y = -1; y <= 1; y++) {
                        if(facing == EnumFacing.UP || facing == EnumFacing.DOWN) {
                            chiselBlockInWorld(recipe, stack, new BlockPos(xPos + x, yPos, zPos + y), world, player.isSneaking());
                        } else if(facing == EnumFacing.EAST || facing == EnumFacing.WEST) {
                            chiselBlockInWorld(recipe, stack, new BlockPos(xPos, yPos + y, zPos + x), world, player.isSneaking());
                        } else {
                            chiselBlockInWorld(recipe, stack, new BlockPos(xPos + x, yPos + y, zPos), world, player.isSneaking());
                        }
                    }
                }
            }

            @Override
            public IChiselMode next() {
                return COLUMN;
            }
        },
        COLUMN {
            @Override
            public void chisel(EntityPlayer player, World world, BlockPos pos, EnumFacing facing, ICarvingRecipe recipe) {
                IBlockState state = world.getBlockState(pos);
                ItemStack stack = new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state));
                int xPos = pos.getX();
                int yPos = pos.getY();
                int zPos = pos.getZ();

                for(int c = -1; c <= 1; c++) {
                    if(facing != EnumFacing.DOWN && facing != EnumFacing.UP) {
                        chiselBlockInWorld(recipe, stack, new BlockPos(xPos, yPos + c, zPos), world, player.isSneaking());
                    } else {
                        if(facing.getIndex() == 0 || facing.getIndex() == 2) {
                            chiselBlockInWorld(recipe, stack, new BlockPos(xPos, yPos, zPos + c), world, player.isSneaking());
                        } else {
                            chiselBlockInWorld(recipe, stack, new BlockPos(xPos + c, yPos, zPos), world, player.isSneaking());
                        }
                    }
                }
            }

            @Override
            public IChiselMode next() {
                return ROW;
            }
        },
        ROW {
            @Override
            public void chisel(EntityPlayer player, World world, BlockPos pos, EnumFacing facing, ICarvingRecipe recipe) {
                IBlockState state = world.getBlockState(pos);
                ItemStack stack = new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state));
                int xPos = pos.getX();
                int yPos = pos.getY();
                int zPos = pos.getZ();

                for(int c = -1; c <= 1; c++) {
                    if(facing != EnumFacing.DOWN && facing != EnumFacing.UP) {
                        if(facing == EnumFacing.EAST || facing == EnumFacing.WEST) {
                            chiselBlockInWorld(recipe, stack, new BlockPos(xPos, yPos, zPos + c), world, player.isSneaking());
                        } else {
                            chiselBlockInWorld(recipe, stack, new BlockPos(xPos + c, yPos, zPos), world, player.isSneaking());
                        }
                    } else {
                        if(facing.getIndex() == 0 || facing.getIndex() == 2) {
                            chiselBlockInWorld(recipe, stack, new BlockPos(xPos + c, yPos, zPos), world, player.isSneaking());
                        } else {
                            chiselBlockInWorld(recipe, stack, new BlockPos(xPos, yPos, zPos + c), world, player.isSneaking());
                        }
                    }
                }
            }

            @Override
            public IChiselMode next() {
                return SINGLE;
            }
        }
    }
}
