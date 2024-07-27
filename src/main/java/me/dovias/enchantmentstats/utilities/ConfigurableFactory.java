package me.dovias.enchantmentstats.utilities;

import java.util.function.Consumer;

public interface ConfigurableFactory<T, V> {
    V create(Consumer<T> configurer);
}
