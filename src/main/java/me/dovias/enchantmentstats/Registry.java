package me.dovias.enchantmentstats;

public interface Registry<T, V extends Identifiable<T>> extends Iterable<V> {
    void register(V object);
    V register(Builder<V> object);
    V unregister(V object);
    V get(T identifier);

    void clear();
    int getSize();
    boolean isEmpty();
}
