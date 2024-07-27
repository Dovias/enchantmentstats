package me.dovias.enchantmentstats.registry;

public interface MutableRegistry<T> extends Registry<T> {
    void register(T object);
    void unregister(T object);

    void clear();
}
