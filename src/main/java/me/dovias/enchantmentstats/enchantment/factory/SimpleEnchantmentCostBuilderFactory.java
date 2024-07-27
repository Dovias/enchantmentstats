package me.dovias.enchantmentstats.enchantment.factory;

import me.dovias.enchantmentstats.enchantment.builder.EnchantmentCostBuilder;
import me.dovias.enchantmentstats.enchantment.builder.SimpleEnchantmentCostBuilder;
import me.dovias.enchantmentstats.utilities.Factory;

public class SimpleEnchantmentCostBuilderFactory implements Factory<EnchantmentCostBuilder> {
    @Override
    public EnchantmentCostBuilder create() {
        return new SimpleEnchantmentCostBuilder();
    }
}
