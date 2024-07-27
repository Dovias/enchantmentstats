package me.dovias.enchantmentstats.enchantment.factory.configurable;

import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.enchantment.builder.EnchantmentCostBuilder;
import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.utilities.Factory;

import java.util.function.Consumer;

public class EnchantmentCostConfigurableFactory implements ConfigurableFactory<Enchantment.Cost.Customizer, Enchantment.Cost> {
    private final Factory<EnchantmentCostBuilder> factory;

    public EnchantmentCostConfigurableFactory(Factory<EnchantmentCostBuilder> factory) {
        this.factory = factory;
    }

    @Override
    public Enchantment.Cost create(Consumer<Enchantment.Cost.Customizer> configurer) {
        EnchantmentCostBuilder builder = this.factory.create();
        configurer.accept(builder);
        return builder.build();
    }
}
