package io.github.chiselteam.chisel.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.palette.PaletteDefinition;
import io.github.chiselteam.chisel.palette.PlayerPaletteManager;
import io.github.chiselteam.chisel.palette.PlayerPalettes;
import io.github.chiselteam.chisel.palette.WeightedBlock;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.IdentifierArgument;
import net.minecraft.commands.arguments.UuidArgument;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.UnaryOperator;

@EventBusSubscriber(modid = Chisel.MODID)
public final class PaletteCommands {
    private PaletteCommands() {
    }

    @SubscribeEvent
    public static void register(RegisterCommandsEvent event) {
        var palette = Commands.literal("palette")
                .executes(c -> list(c.getSource()))
                .then(Commands.literal("list").executes(c -> list(c.getSource())))
                .then(Commands.literal("create").then(Commands.argument("name", StringArgumentType.greedyString())
                        .executes(c -> run(c, player -> {
                            var id = PlayerPaletteManager.save(player, Optional.empty(), new PaletteDefinition(
                                    StringArgumentType.getString(c, "name"), "", Identifier.withDefaultNamespace("bricks"), List.of()));
                            return "Created palette " + id;
                        }))))
                .then(Commands.literal("clear").executes(c -> run(c, player -> {
                    PlayerPaletteManager.select(player, Optional.empty());
                    return "Active palette cleared";
                })))
                .then(Commands.literal("select").then(paletteId().executes(c -> run(c, player -> {
                    PlayerPaletteManager.select(player, Optional.of(id(c)));
                    return "Selected " + id(c);
                }))))
                .then(Commands.literal("delete").then(paletteId().executes(c -> run(c, player -> {
                    PlayerPaletteManager.delete(player, id(c));
                    return "Deleted " + id(c);
                }))))
                .then(Commands.literal("show").then(paletteId().executes(c -> run(c, player -> {
                    var value = PlayerPaletteManager.get(player).require(id(c)).definition();
                    player.sendSystemMessage(Component.literal(value.name() + " | " + value.icon() + " | " + value.description()));
                    for (var entry : value.entries())
                        player.sendSystemMessage(Component.literal(
                                entry.block() + " weight=" + entry.weight() + " enabled=" + entry.enabled()));
                    return "Enabled total weight: " + value.enabledWeight();
                }))));
        var edit = paletteId()
                .then(Commands.literal("name").then(Commands.argument("value", StringArgumentType.greedyString()).executes(c -> edit(c,
                        old -> new PaletteDefinition(StringArgumentType.getString(c, "value"), old.description(), old.icon(), old.entries())))))
                .then(Commands.literal("description").executes(c -> edit(c,
                                old -> new PaletteDefinition(old.name(), "", old.icon(), old.entries())))
                        .then(Commands.argument("value", StringArgumentType.greedyString()).executes(c -> edit(c,
                                old -> new PaletteDefinition(old.name(), StringArgumentType.getString(c, "value"), old.icon(), old.entries())))))
                .then(Commands.literal("icon").then(Commands.argument("item", IdentifierArgument.id())
                        .suggests((c, builder) -> SharedSuggestionProvider.suggestResource(BuiltInRegistries.ITEM.keySet(), builder))
                        .executes(c -> edit(c, old -> new PaletteDefinition(old.name(), old.description(), IdentifierArgument.getId(c, "item"), old.entries())))))
                .then(Commands.literal("block").then(Commands.argument("block", IdentifierArgument.id())
                        .suggests((c, builder) -> SharedSuggestionProvider.suggestResource(BuiltInRegistries.BLOCK.keySet(), builder))
                        .then(Commands.argument("weight", IntegerArgumentType.integer(1, 100))
                                .executes(c -> setBlock(c, true))
                                .then(Commands.argument("enabled", BoolArgumentType.bool()).executes(c -> setBlock(c, BoolArgumentType.getBool(c, "enabled")))))))
                .then(Commands.literal("remove").then(Commands.argument("block", IdentifierArgument.id()).executes(c -> edit(c, old -> {
                    var block = IdentifierArgument.getId(c, "block");
                    if (old.entries().stream().noneMatch(e -> e.block().equals(block)))
                        throw new IllegalArgumentException("Block is not in this palette");
                    return old.withEntries(old.entries().stream().filter(e -> !e.block().equals(block)).toList());
                }))));
        palette.then(Commands.literal("edit").then(edit));
        event.getDispatcher().register(Commands.literal("chisel").then(palette));
    }

    private static int setBlock(CommandContext<CommandSourceStack> context, boolean enabled) throws CommandSyntaxException {
        return edit(context, old -> {
            var entry = new WeightedBlock(IdentifierArgument.getId(context, "block"), IntegerArgumentType.getInteger(context, "weight"), enabled);
            var entries = new ArrayList<>(old.entries());
            int index = -1;
            for (int i = 0; i < entries.size(); i++)
                if (entries.get(i).block().equals(entry.block())) {
                    index = i;
                    break;
                }
            if (index < 0) entries.add(entry);
            else entries.set(index, entry);
            return old.withEntries(entries);
        });
    }

    private static RequiredArgumentBuilder<CommandSourceStack, UUID> paletteId() {
        return Commands.argument("id", UuidArgument.uuid()).suggests((c, builder) -> {
            if (c.getSource().getEntity() instanceof ServerPlayer player)
                return SharedSuggestionProvider.suggest(PlayerPaletteManager.get(player).palettes().stream().map(p -> p.id().toString()), builder);
            return builder.buildFuture();
        });
    }

    private static UUID id(CommandContext<CommandSourceStack> context) {
        return UuidArgument.getUuid(context, "id");
    }

    private static int edit(CommandContext<CommandSourceStack> context, UnaryOperator<PaletteDefinition> update) throws CommandSyntaxException {
        return run(context, player -> {
            var id = id(context);
            var old = PlayerPaletteManager.get(player).require(id).definition();
            PlayerPaletteManager.save(player, Optional.of(id), update.apply(old));
            return "Updated " + id;
        });
    }

    private static int list(CommandSourceStack source) throws CommandSyntaxException {
        var value = PlayerPaletteManager.get(source.getPlayerOrException());
        source.sendSuccess(() -> Component.literal("Palettes: " + value.palettes().size() + "/" + PlayerPalettes.MAX_PALETTES), false);
        for (var palette : value.palettes())
            source.sendSuccess(() -> Component.literal(
                    (value.activeId().filter(palette.id()::equals).isPresent() ? "* " : "") + palette.definition().name() + " | " + palette.id()), false);
        return value.palettes().size();
    }

    private static int run(CommandContext<CommandSourceStack> context, java.util.function.Function<ServerPlayer, String> action) throws CommandSyntaxException {
        var player = context.getSource().getPlayerOrException();
        try {
            var message = action.apply(player);
            context.getSource().sendSuccess(() -> Component.literal(message), false);
            return 1;
        } catch (IllegalArgumentException error) {
            context.getSource().sendFailure(Component.literal(error.getMessage()));
            return 0;
        }
    }
}
