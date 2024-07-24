package me.dovias.enchantmentstats;

import java.util.List;
import java.util.Set;

public record Item(ItemType type, Set<Enchantment> enchantments) {

    public record EnchantmentProbability(float probability, Enchantment enchantment) {}

    public List<EnchantmentProbability> calculateProbableEnchantments() {

        return List.of();
    }
}
