package me.dovias.enchantmentstats;

import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.enchantment.builder.EnchantmentTypeIdentifiableContainerBuilder;
import me.dovias.enchantmentstats.enchantment.factory.SimpleEnchantmentTypeBuilderFactory;
import me.dovias.enchantmentstats.enchantment.factory.configurable.EnchantmentCostConfigurableFactory;
import me.dovias.enchantmentstats.enchantment.factory.SimpleEnchantmentCostBuilderFactory;
import me.dovias.enchantmentstats.identity.factory.IdentifiableContainerConfigurableFactory;
import me.dovias.enchantmentstats.item.Item;
import me.dovias.enchantmentstats.item.builder.ItemTypeBuilder;
import me.dovias.enchantmentstats.item.builder.ItemTypeIdentifiableContainerBuilder;
import me.dovias.enchantmentstats.item.factory.SimpleItemTypeBuilderFactory;
import me.dovias.enchantmentstats.item.factory.configurable.ItemTypeConfigurableFactory;
import me.dovias.enchantmentstats.manager.IdentifiableConfigurableObjectManager;
import me.dovias.enchantmentstats.manager.IdentifiableRegistryConfigurableObjectManager;
import me.dovias.enchantmentstats.registry.MapRegistry;
import me.dovias.enchantmentstats.utilities.Factory;

public class EnchantmentStatsMod implements EnchantmentStats {
    private final IdentifiableConfigurableObjectManager<Enchantment.Type.Customizer, Enchantment.Type, String> enchantmentTypeManager;
    private final IdentifiableConfigurableObjectManager<Item.Type.Customizer, Item.Type, String> itemTypeManager;

    public EnchantmentStatsMod() {
        Factory<ItemTypeBuilder> factory = new SimpleItemTypeBuilderFactory();

        this.enchantmentTypeManager = new IdentifiableRegistryConfigurableObjectManager<>(
            new MapRegistry<>(),
            new IdentifiableContainerConfigurableFactory<>(
                new EnchantmentTypeIdentifiableContainerBuilder(
                    new SimpleEnchantmentTypeBuilderFactory(
                        new EnchantmentCostConfigurableFactory(new SimpleEnchantmentCostBuilderFactory()),
                        new ItemTypeConfigurableFactory(factory)
                    )
                )
            )
        );

        this.itemTypeManager = new IdentifiableRegistryConfigurableObjectManager<>(
            new MapRegistry<>(),
            new IdentifiableContainerConfigurableFactory<>(
                new ItemTypeIdentifiableContainerBuilder(factory)
            )
        );
    }

    @Override
    public IdentifiableConfigurableObjectManager<Enchantment.Type.Customizer, Enchantment.Type, String> getEnchantmentTypeManager() {
        return this.enchantmentTypeManager;
    }

    @Override
    public IdentifiableConfigurableObjectManager<Item.Type.Customizer, Item.Type, String> getItemTypeManager() {
        return this.itemTypeManager;
    }
}
