package me.dovias.enchantmentstats.manager;

import me.dovias.enchantmentstats.identity.Identifiable;
import me.dovias.enchantmentstats.identity.IdentifiableContainer;

import java.util.stream.Stream;

public interface IdentifiableConfigurableObjectManager<T, V, I> extends Iterable<V> {
    IdentifiableContainer<I, V> register(Identifiable.Customizer.Configurer<I, T> configurer);
    V get(I identifier);

    boolean contains(V type);
    boolean containsIdentifier(I identifier);

    int getSize();

    void clear();

    Stream<V> stream();
}
