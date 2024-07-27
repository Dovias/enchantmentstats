package me.dovias.enchantmentstats.enchantment.builder;

import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.enchantment.SimpleEnchantment;

public class SimpleEnchantmentBuilder implements EnchantmentBuilder {
    private Enchantment.Type type;
    private int level;

    private final ConfigurableFactory<Enchantment.Type.Customizer, Enchantment.Type> factory;

    public SimpleEnchantmentBuilder(ConfigurableFactory<Enchantment.Type.Customizer, Enchantment.Type> factory) {
        this.factory = factory;
    }

    @Override
    public SimpleEnchantmentBuilder setType(Enchantment.Type.Customizer.Configurer configurer) {
        this.type = this.factory.create(configurer);
        return this;
    }

    @Override
    public SimpleEnchantmentBuilder setLevel(int level) {
        this.level = level;
        return this;
    }

    @Override
    public SimpleEnchantment build() {
        return new SimpleEnchantment(type, level);
    }
}
