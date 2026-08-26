package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.block.util.NoParticleTorchBlock;
import io.github.chiselteam.chisel.block.util.NoParticleWallTorchBlock;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class TorchFamily extends ChiselFamily {

    public TorchFamily(BlockBehaviour.Properties props) {
        family = builder("torch")
                .addVariant(Blocks.TORCH)
                .addTorchVariant("torch_1", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("torch_2", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("torch_3", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("torch_4", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("torch_5", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("torch_6", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("torch_7", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("torch_8", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("torch_9", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("torch_10", NoParticleTorchBlock::new, () -> props, TORCH)
                .addTorchVariant("wall_torch_1", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_1").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .addTorchVariant("wall_torch_2", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_2").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .addTorchVariant("wall_torch_3", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_3").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .addTorchVariant("wall_torch_4", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_4").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .addTorchVariant("wall_torch_5", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_5").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .addTorchVariant("wall_torch_6", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_6").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .addTorchVariant("wall_torch_7", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_7").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .addTorchVariant("wall_torch_8", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_8").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .addTorchVariant("wall_torch_9", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_9").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .addTorchVariant("wall_torch_10", NoParticleWallTorchBlock::new, () -> wallVariant(ChiselBlocks.TORCH.getVariant("torch_10").get()).noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), WALL_TORCH)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("torch_1"), "Torch", "Wax Candle");
        lang.addBlock(getVariant("torch_2"), "Torch", "Tall Wax Candle");
        lang.addBlock(getVariant("torch_3"), "Torch", "White Lamp");
        lang.addBlock(getVariant("torch_4"), "Torch", "Embroidered White Lamp");
        lang.addBlock(getVariant("torch_5"), "Torch", "Small Black Lamp");
        lang.addBlock(getVariant("torch_6"), "Torch", "Tall Black Lamp");
        lang.addBlock(getVariant("torch_7"), "Torch", "Red Lamp");
        lang.addBlock(getVariant("torch_8"), "Torch", "Embroidered Red Lamp");
        lang.addBlock(getVariant("torch_9"), "Torch", "Light Bulb");
        lang.addBlock(getVariant("torch_10"), "Torch", "Clear Light Bulb");
    }

    private static BlockBehaviour.Properties wallVariant(Block standingBlock) {
        BlockBehaviour.Properties wallProperties = BlockBehaviour.Properties.of().overrideLootTable(standingBlock.getLootTable());
        wallProperties = wallProperties.overrideDescription(standingBlock.getDescriptionId());

        return wallProperties;
    }
}

