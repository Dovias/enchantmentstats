package me.dovias.enchantmentstats.enchantment.factory;

import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.enchantment.builder.EnchantmentBuilder;
import me.dovias.enchantmentstats.enchantment.builder.SimpleEnchantmentBuilder;
import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.utilities.Factory;

public class SimpleEnchantmentBuilderFactory implements Factory<EnchantmentBuilder> {
    private final ConfigurableFactory<Enchantment.Type.Customizer, Enchantment.Type> factory;

    public SimpleEnchantmentBuilderFactory(ConfigurableFactory<Enchantment.Type.Customizer, Enchantment.Type> factory) {
        this.factory = factory;
    }

    @Override
    public EnchantmentBuilder create() {
        return new SimpleEnchantmentBuilder(factory);
    }
}
