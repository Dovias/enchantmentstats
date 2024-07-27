package me.dovias.enchantmentstats.registry;

public interface IdentifiableRegistry<T, V> extends Registry<V> {
    V get(T identifier);
    boolean containsIdentifier(T identifier);
}
