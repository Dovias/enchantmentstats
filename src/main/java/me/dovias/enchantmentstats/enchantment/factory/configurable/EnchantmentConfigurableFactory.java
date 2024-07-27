package me.dovias.enchantmentstats.enchantment.factory.configurable;

import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.enchantment.builder.EnchantmentBuilder;
import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.utilities.Factory;

import java.util.function.Consumer;

public class EnchantmentConfigurableFactory implements ConfigurableFactory<Enchantment.Customizer, Enchantment> {
    private final Factory<EnchantmentBuilder> factory;

    public EnchantmentConfigurableFactory(Factory<EnchantmentBuilder> factory) {
        this.factory = factory;
    }

    @Override
    public Enchantment create(Consumer<Enchantment.Customizer> configurer) {
        EnchantmentBuilder builder = factory.create();
        configurer.accept(builder);
        return builder.build();
    }
}
