package me.dovias.enchantmentstats.item;

public class SimpleItemType implements Item.Type {
    private final int enchantability;

    public SimpleItemType(int enchantability) {
        this.enchantability = enchantability;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }
}
