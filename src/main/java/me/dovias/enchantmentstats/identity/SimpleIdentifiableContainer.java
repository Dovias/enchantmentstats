package me.dovias.enchantmentstats.identity;

public class SimpleIdentifiableContainer<T, V> implements IdentifiableContainer<T, V> {
    private final T identifier;
    private final V value;

    public SimpleIdentifiableContainer(T identifier, V value) {
        this.identifier = identifier;
        this.value = value;
    }

    @Override
    public T getIdentifier() {
        return this.identifier;
    }

    @Override
    public V getValue() {
        return this.value;
    }
}
