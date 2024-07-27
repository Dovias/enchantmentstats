package me.dovias.enchantmentstats.enchantment.factory.configurable;

import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.enchantment.builder.EnchantmentTypeBuilder;
import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.utilities.Factory;

import java.util.function.Consumer;

public class EnchantmentTypeConfigurableFactory implements ConfigurableFactory<Enchantment.Type.Customizer, Enchantment.Type> {
    private final Factory<EnchantmentTypeBuilder> factory;

    public EnchantmentTypeConfigurableFactory(Factory<EnchantmentTypeBuilder> factory) {
        this.factory = factory;
    }

    @Override
    public Enchantment.Type create(Consumer<Enchantment.Type.Customizer> configurer) {
        EnchantmentTypeBuilder builder = this.factory.create();
        configurer.accept(builder);
        return builder.build();
    }
}
