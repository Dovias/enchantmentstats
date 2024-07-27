package me.dovias.enchantmentstats.item.builder;

import me.dovias.enchantmentstats.item.SimpleItemType;

public class SimpleItemTypeBuilder implements ItemTypeBuilder {
    private int enchantability;

    @Override
    public SimpleItemTypeBuilder setEnchantability(int enchantability) {
        this.enchantability = enchantability;
        return this;
    }

    @Override
    public SimpleItemType build() {
        return new SimpleItemType(enchantability);
    }
}
