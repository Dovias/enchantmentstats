package me.dovias.enchantmentstats.registry;

import me.dovias.enchantmentstats.identity.Identifiable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class MapRegistry<T, V extends Identifiable<T>> implements IdentifiableMutableRegistry<T, V>{
    private final Map<T, V> map = new HashMap<>();

    @Override
    public void register(V object) {
        if (this.map.putIfAbsent(object.getIdentifier(), object) != null) {
            throw new IllegalArgumentException("Object with identifier: " + object.getIdentifier() + " is already registered!");
        }
    }

    @Override
    public void unregister(V object) {
        this.map.remove(object.getIdentifier());
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public V get(T object) {
        return this.map.get(object);
    }

    @Override
    public boolean contains(V object) {
        return this.map.containsKey(object.getIdentifier());
    }

    @Override
    public boolean containsIdentifier(T identifier) {
        return this.map.containsKey(identifier);
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
    public Stream<V> stream() {
        return Collections.unmodifiableCollection(this.map.values()).stream();
    }

    @Override
    public Iterator<V> iterator() {
        return Collections.unmodifiableCollection(this.map.values()).iterator();
    }
}
