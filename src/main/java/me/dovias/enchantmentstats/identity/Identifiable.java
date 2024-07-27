package me.dovias.enchantmentstats.identity;

import java.util.function.Consumer;

public interface Identifiable<T> {
    T getIdentifier();

    interface Customizer<T, V> {
        interface Configurer<T, V> extends Consumer<Customizer<T, V>> {}

        V setIdentifier(T identifier);
    }
}
