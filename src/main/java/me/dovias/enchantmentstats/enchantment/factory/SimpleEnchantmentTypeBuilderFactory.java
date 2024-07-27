package me.dovias.enchantmentstats.enchantment.factory;

import me.dovias.enchantmentstats.enchantment.builder.EnchantmentTypeBuilder;
import me.dovias.enchantmentstats.enchantment.builder.SimpleEnchantmentTypeBuilder;
import me.dovias.enchantmentstats.enchantment.factory.configurable.EnchantmentCostConfigurableFactory;
import me.dovias.enchantmentstats.item.factory.configurable.ItemTypeConfigurableFactory;
import me.dovias.enchantmentstats.utilities.Factory;

public class SimpleEnchantmentTypeBuilderFactory implements Factory<EnchantmentTypeBuilder> {
    private final EnchantmentCostConfigurableFactory costFactory;
    private final ItemTypeConfigurableFactory itemFactory;

    public SimpleEnchantmentTypeBuilderFactory(EnchantmentCostConfigurableFactory costFactory, ItemTypeConfigurableFactory itemFactory) {
        this.costFactory = costFactory;
        this.itemFactory = itemFactory;
    }

    @Override
    public EnchantmentTypeBuilder create() {
        return new SimpleEnchantmentTypeBuilder(this.costFactory, this.itemFactory);
    }
}

