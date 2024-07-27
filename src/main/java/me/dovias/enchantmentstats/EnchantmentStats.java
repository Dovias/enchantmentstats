package me.dovias.enchantmentstats;

import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.item.Item;
import me.dovias.enchantmentstats.manager.IdentifiableConfigurableObjectManager;

public interface EnchantmentStats {
    IdentifiableConfigurableObjectManager<Enchantment.Type.Customizer, Enchantment.Type, String> getEnchantmentTypeManager();
    IdentifiableConfigurableObjectManager<Item.Type.Customizer, Item.Type, String> getItemTypeManager();
}
