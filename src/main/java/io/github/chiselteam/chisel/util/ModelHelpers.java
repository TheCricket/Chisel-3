package io.github.chiselteam.chisel.util;

import net.minecraft.client.renderer.block.dispatch.multipart.CombinedCondition;
import net.minecraft.client.renderer.block.dispatch.multipart.Condition;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.List;

import static net.minecraft.client.data.models.BlockModelGenerators.condition;
import static net.minecraft.client.renderer.block.dispatch.multipart.CombinedCondition.Operation.AND;
import static net.minecraft.client.renderer.block.dispatch.multipart.CombinedCondition.Operation.OR;

public class ModelHelpers {

    public static Condition centerCondition(Property<Boolean> direction, Property<Boolean> opposite, Property<Boolean> perpendicularA, Property<Boolean> perpendicularB) {
        return new CombinedCondition(AND, List.of(
                condition().term(direction, false).build(),
                new CombinedCondition(OR, List.of(
                        condition().term(opposite, false).build(),
                        condition().term(perpendicularA, true).build(),
                        condition().term(perpendicularB, true).build()
                ))
        ));
    }

    public static Condition endCondition(Property<Boolean> direction, Property<Boolean> opposite, Property<Boolean> perpendicularA, Property<Boolean> perpendicularB) {
        return condition()
                .term(direction, false)
                .term(opposite, true)
                .term(perpendicularA, false)
                .term(perpendicularB, false)
                .build();
    }
}
