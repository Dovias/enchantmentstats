package me.dovias.enchantmentstats.fabric.hook;

import me.dovias.enchantmentstats.Enchantment;
import me.dovias.enchantmentstats.ItemType;
import me.dovias.enchantmentstats.Registry;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.registry.RegistryKeys;

public class RegistrySyncListener implements ClientPlayConnectionEvents.Join {
    private final Registry<String, Enchantment> enchantments;
    private final Registry<String, ItemType> itemTypes;

    public RegistrySyncListener(Registry<String, Enchantment> enchantments, Registry<String, ItemType> itemTypes) {
        this.enchantments = enchantments;
        this.itemTypes = itemTypes;
    }

    @Override
    public void onPlayReady(ClientPlayNetworkHandler handler, PacketSender sender, MinecraftClient client) {
        this.enchantments.clear();
        handler.getRegistryManager().get(RegistryKeys.ENCHANTMENT).getEntrySet().forEach((entry) -> {
            net.minecraft.enchantment.Enchantment enchantment = entry.getValue();
            net.minecraft.enchantment.Enchantment.Definition definition = enchantment.definition();

            this.enchantments.register(Enchantment.builder()
                .identifier(entry.getKey().getValue().toString())
                .minLevel(enchantment.getMinLevel())
                .maxLevel(enchantment.getMaxLevel())
                .minCost(Enchantment.Cost.builder()
                    .base(definition.minCost().base())
                    .level(definition.maxCost().perLevelAboveFirst())
                )
                .maxCost(Enchantment.Cost.builder()
                    .base(definition.minCost().base())
                    .level(definition.maxCost().perLevelAboveFirst())
                )
                .weight(entry.getValue().getWeight())
            );
        });

        this.itemTypes.clear();
        handler.getRegistryManager().get(RegistryKeys.ITEM).getEntrySet().forEach((entry) -> this.itemTypes.register(ItemType.builder()
            .identifier(entry.getKey().getValue().toString())
            .enchantability(entry.getValue().getEnchantability())
        ));

    }
}
