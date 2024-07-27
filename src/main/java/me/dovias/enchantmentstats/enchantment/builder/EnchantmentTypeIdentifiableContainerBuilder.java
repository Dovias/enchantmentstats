package me.dovias.enchantmentstats.enchantment.builder;

import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.identity.Identifiable;
import me.dovias.enchantmentstats.identity.IdentifiableContainer;
import me.dovias.enchantmentstats.identity.SimpleIdentifiableContainer;
import me.dovias.enchantmentstats.utilities.Builder;
import me.dovias.enchantmentstats.utilities.Factory;

public class EnchantmentTypeIdentifiableContainerBuilder implements Identifiable.Customizer<String, Enchantment.Type.Customizer>, Builder<IdentifiableContainer<String, Enchantment.Type>> {
    private final Factory<EnchantmentTypeBuilder> factory;
    private EnchantmentTypeBuilder builder;
    private String identifier;

    public EnchantmentTypeIdentifiableContainerBuilder(Factory<EnchantmentTypeBuilder> factory) {
        this.factory = factory;
    }

    @Override
    public Enchantment.Type.Customizer setIdentifier(String identifier) {
        this.identifier = identifier;

        this.builder = this.factory.create();
        return this.builder;
    }

    @Override
    public IdentifiableContainer<String, Enchantment.Type> build() {
        return new SimpleIdentifiableContainer<>(this.identifier, this.builder.build());
    }
}
