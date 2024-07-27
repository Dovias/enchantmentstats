package me.dovias.enchantmentstats;

public class EnchantmentStatsModFactory implements EnchantmentStatsFactory {
    @Override
    public EnchantmentStats create() {
        return new EnchantmentStatsMod();
    }
}
