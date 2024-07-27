package me.dovias.enchantmentstats.identity;

public interface IdentifiableContainer<T, V> extends Identifiable<T> {
    V getValue();

}
