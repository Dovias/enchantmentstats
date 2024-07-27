package me.dovias.enchantmentstats.registry;

import java.util.stream.Stream;

public interface Registry<T> extends Iterable<T> {
    boolean contains(T object);

    int getSize();
    boolean isEmpty();

    Stream<T> stream();
}
