package me.dovias.enchantmentstats.enchantment.builder;

import me.dovias.enchantmentstats.enchantment.SimpleEnchantmentCost;

public class SimpleEnchantmentCostBuilder implements EnchantmentCostBuilder {
    private int baseCost;
    private int perLevelCost;

    @Override
    public SimpleEnchantmentCostBuilder setBaseCost(int cost) {
        this.baseCost = cost;
        return this;
    }

    @Override
    public SimpleEnchantmentCostBuilder setPerLevelCost(int cost) {
        this.perLevelCost = cost;
        return this;
    }

    @Override
    public SimpleEnchantmentCost build() {
        return new SimpleEnchantmentCost(baseCost, perLevelCost);
    }
}
