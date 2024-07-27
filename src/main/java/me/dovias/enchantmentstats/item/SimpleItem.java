package me.dovias.enchantmentstats.item;

import me.dovias.enchantmentstats.enchantment.Enchantment;

import java.util.Set;

public class SimpleItem implements Item {
    private final Item.Type type;
    private final Set<Enchantment> enchantments;

    public SimpleItem(Type type, Set<Enchantment> enchantments) {
        this.type = type;
        this.enchantments = enchantments;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public boolean isEnchantedWith(Enchantment enchantment) {
        return this.enchantments.contains(enchantment);
    }
}
