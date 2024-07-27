package me.dovias.enchantmentstats.enchantment;

import me.dovias.enchantmentstats.item.Item;

import java.util.Set;

public class SimpleEnchantmentType implements Enchantment.Type {
    private final int weight;
    private final int minLevel;
    private final int maxLevel;
    private final Enchantment.Cost minCost;
    private final Enchantment.Cost maxCost;
    private final boolean enchantable;
    private final Set<Enchantment.Type> compatibleEnchantmentTypes;
    private final Set<Item.Type> compatibleItemTypes;

    public SimpleEnchantmentType(int weight, int minLevel, int maxLevel, Enchantment.Cost minCost, Enchantment.Cost maxCost, boolean enchantable, Set<Enchantment.Type> compatibleEnchantmentTypes, Set<Item.Type> compatibleItemTypes) {
        this.weight = weight;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.minCost = minCost;
        this.maxCost = maxCost;
        this.enchantable = enchantable;
        this.compatibleEnchantmentTypes = compatibleEnchantmentTypes;
        this.compatibleItemTypes = compatibleItemTypes;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public int getMinLevel() {
        return this.minLevel;
    }

    @Override
    public int getMaxLevel() {
        return this.maxLevel;
    }

    @Override
    public Enchantment.Cost getMinCost() {
        return this.minCost;
    }

    @Override
    public Enchantment.Cost getMaxCost() {
        return this.maxCost;
    }

    @Override
    public boolean isEnchantable() {
        return this.enchantable;
    }

    @Override
    public boolean isCompatibleWith(Enchantment.Type other) {
        return this.compatibleEnchantmentTypes.contains(other);
    }

    @Override
    public boolean isCompatibleWith(Item.Type other) {
        return this.compatibleItemTypes.contains(other);
    }
}
