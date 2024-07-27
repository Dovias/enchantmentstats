package me.dovias.enchantmentstats.identity.factory;

import me.dovias.enchantmentstats.identity.Identifiable;
import me.dovias.enchantmentstats.identity.IdentifiableContainer;
import me.dovias.enchantmentstats.utilities.Builder;
import me.dovias.enchantmentstats.utilities.ConfigurableFactory;

import java.util.function.Consumer;

public class IdentifiableContainerConfigurableFactory<T, V, I, B extends Identifiable.Customizer<I, T> & Builder<IdentifiableContainer<I, V>>> implements ConfigurableFactory<IdentifiableContainer.Customizer<I, T>, IdentifiableContainer<I, V>> {
    private final B builder;

    public IdentifiableContainerConfigurableFactory(B builder) {
        this.builder = builder;
    }


    @Override
    public IdentifiableContainer<I, V> create(Consumer<Identifiable.Customizer<I, T>> configurer) {
        configurer.accept(builder);
        return builder.build();
    }
}
