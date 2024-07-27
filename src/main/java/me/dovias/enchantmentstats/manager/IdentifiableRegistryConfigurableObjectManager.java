package me.dovias.enchantmentstats.manager;

import me.dovias.enchantmentstats.identity.Identifiable;
import me.dovias.enchantmentstats.identity.IdentifiableContainer;
import me.dovias.enchantmentstats.registry.IdentifiableMutableRegistry;
import me.dovias.enchantmentstats.utilities.ConfigurableFactory;

import java.util.Iterator;
import java.util.stream.Stream;

public class IdentifiableRegistryConfigurableObjectManager<T, V, I> implements IdentifiableConfigurableObjectManager<T, V, I> {
    private final IdentifiableMutableRegistry<I, IdentifiableContainer<I, V>> registry;
    private final ConfigurableFactory<IdentifiableContainer.Customizer<I, T>, IdentifiableContainer<I, V>> factory;

    public IdentifiableRegistryConfigurableObjectManager(IdentifiableMutableRegistry<I, IdentifiableContainer<I, V>> registry,
                                                         ConfigurableFactory<IdentifiableContainer.Customizer<I, T>, IdentifiableContainer<I, V>> factory) {
        this.registry = registry;
        this.factory = factory;
    }

    @Override
    public IdentifiableContainer<I, V> register(Identifiable.Customizer.Configurer<I, T> configurer) {
        return this.factory.create(configurer);
    }

    @Override
    public V get(I identifier) {
        return this.registry.get(identifier).getValue();
    }

    @Override
    public boolean contains(V type) {
        return this.registry.stream().anyMatch(candidate -> candidate.getValue().equals(type));
    }

    @Override
    public boolean containsIdentifier(I identifier) {
        return this.registry.containsIdentifier(identifier);
    }

    @Override
    public int getSize() {
        return this.registry.getSize();
    }

    @Override
    public void clear() {
        this.registry.clear();
    }

    @Override
    public Stream<V> stream() {
        return this.registry.stream().map(IdentifiableContainer::getValue);
    }

    @Override
    public Iterator<V> iterator() {
        return this.stream().iterator();
    }
}
