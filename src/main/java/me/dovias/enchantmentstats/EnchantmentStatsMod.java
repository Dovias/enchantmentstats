package me.dovias.enchantmentstats;

public class EnchantmentStatsMod {
    Registry<String, Enchantment> enchantments = new MapRegistry<>();
    Registry<String, ItemType> itemTypes = new MapRegistry<>();

    public Registry<String, Enchantment> getEnchantments() {
        return this.enchantments;
    }

    public Registry<String, ItemType> getItemTypes() {
        return this.itemTypes;
    }
}
