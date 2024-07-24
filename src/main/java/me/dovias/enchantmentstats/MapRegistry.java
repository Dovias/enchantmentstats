package me.dovias.enchantmentstats;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapRegistry<T, V extends Identifiable<T>> implements Registry<T, V> {
    private final Map<T, V> map = new HashMap<>();

    @Override
    public void register(V object) {
        System.out.println("Registering object: " + object);
        if (this.map.putIfAbsent(object.identifier(), object) != null) {
            throw new IllegalArgumentException("Object " + object + " already exists in registry!");
        }
    }

    @Override
    public V register(Builder<V> builder) {
        V object = builder.build();
        this.register(object);
        return object;
    }

    @Override
    public V unregister(V object) {
        return this.map.remove(object.identifier());
    }

    @Override
    public V get(T identifier) {
        return this.map.get(identifier);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public int getSize() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public Iterator<V> iterator() {
        return this.map.values().iterator();
    }
}
