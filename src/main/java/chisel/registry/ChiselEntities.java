package chisel.registry;

import chisel.Chisel;
import chisel.entity.BallOMoss;
import chisel.entity.CloudInABottle;
import chisel.entity.SmashingRock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Chisel.MODID);

    public static final ResourceKey<EntityType<?>> BALL_O_MOSS_KEY = createKey("ball_o_moss");
    public static final ResourceKey<EntityType<?>> CLOUD_IN_A_BOTTLE_KEY = createKey("cloud_in_a_bottle");
    public static final ResourceKey<EntityType<?>> SMASHING_ROCK_KEY = createKey("smashing_rock");

    public static final DeferredHolder<EntityType<?>, EntityType<BallOMoss>> BALL_O_MOSS = register("ball_o_moss", EntityType.Builder.<BallOMoss>of(BallOMoss::new, MobCategory.MISC).fireImmune().sized(0.5F, 0.5F), BALL_O_MOSS_KEY);
    public static final DeferredHolder<EntityType<?>, EntityType<CloudInABottle>> CLOUD_IN_A_BOTTLE = register("cloud_in_a_bottle", EntityType.Builder.<CloudInABottle>of(CloudInABottle::new, MobCategory.MISC).fireImmune().sized(0.5F, 0.5F), CLOUD_IN_A_BOTTLE_KEY);
    public static final DeferredHolder<EntityType<?>, EntityType<SmashingRock>> SMASHING_ROCK = register("smashing_rock", EntityType.Builder.<SmashingRock>of(SmashingRock::new, MobCategory.MISC).fireImmune().sized(0.5F, 0.5F), SMASHING_ROCK_KEY);

    private static ResourceKey<EntityType<?>> createKey(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Chisel.prefix(name));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String name, EntityType.Builder<T> builder, ResourceKey<EntityType<?>> key) {
        return ENTITY_TYPES.register(name, () -> builder.build(key));
    }
}
