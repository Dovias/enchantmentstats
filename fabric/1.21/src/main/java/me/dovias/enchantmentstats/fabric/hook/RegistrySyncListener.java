package me.dovias.enchantmentstats.fabric.hook;

import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.item.Item;
import me.dovias.enchantmentstats.manager.IdentifiableConfigurableObjectManager;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.PacketSender;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.registry.RegistryKeys;

public class RegistrySyncListener implements ClientPlayConnectionEvents.Join {
    private final IdentifiableConfigurableObjectManager<Enchantment.Type.Customizer, Enchantment.Type, String> enchantmentTypeManager;
    private final IdentifiableConfigurableObjectManager<Item.Type.Customizer, Item.Type, String> itemTypeManager;

    public RegistrySyncListener(IdentifiableConfigurableObjectManager<Enchantment.Type.Customizer, Enchantment.Type, String> enchantmentTypeManager,
                                IdentifiableConfigurableObjectManager<Item.Type.Customizer, Item.Type, String> itemTypeManager) {

        this.enchantmentTypeManager = enchantmentTypeManager;
        this.itemTypeManager = itemTypeManager;
    }

    @Override
    public void onPlayReady(ClientPlayNetworkHandler handler, PacketSender sender, MinecraftClient client) {
        this.enchantmentTypeManager.clear();
        handler.getRegistryManager().get(RegistryKeys.ENCHANTMENT).getEntrySet().forEach(entry -> {
            net.minecraft.enchantment.Enchantment enchantment = entry.getValue();
            net.minecraft.enchantment.Enchantment.Definition definition = enchantment.definition();

            this.enchantmentTypeManager.register(enchantmentType -> enchantmentType
                .setIdentifier(entry.getKey().getValue().toString())
                .setMinLevel(enchantment.getMinLevel())
                .setMaxLevel(enchantment.getMaxLevel())
                .setMinCost(cost -> cost
                    .setBaseCost(definition.minCost().base())
                    .setPerLevelCost(definition.minCost().perLevelAboveFirst())
                )
                .setMaxCost(cost -> cost
                    .setBaseCost(definition.maxCost().base())
                    .setPerLevelCost(definition.maxCost().perLevelAboveFirst())
                )
                .setWeight(enchantment.getWeight())
            );
        });

        this.enchantmentTypeManager.clear();
        handler.getRegistryManager().get(RegistryKeys.ITEM).getEntrySet()
            .forEach((entry) -> this.itemTypeManager.register(itemType -> itemType
                .setIdentifier(entry.getKey().getValue().toString())
                .setEnchantability(entry.getValue().getEnchantability())
            )
        );

    }
}
