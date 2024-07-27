package me.dovias.enchantmentstats.enchantment;

public class SimpleEnchantmentCost implements Enchantment.Cost {
   private final int baseCost;
   private final int perLevelCost;

    public SimpleEnchantmentCost(int baseCost, int perLevelCost) {
        this.baseCost = baseCost;
        this.perLevelCost = perLevelCost;
    }

    @Override
    public int getLevelCost(int level) {
        return this.baseCost + this.perLevelCost * (level - 1);
    }
}
