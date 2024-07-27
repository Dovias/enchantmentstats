package me.dovias.enchantmentstats.item.factory;

import me.dovias.enchantmentstats.item.builder.ItemTypeBuilder;
import me.dovias.enchantmentstats.item.builder.SimpleItemTypeBuilder;
import me.dovias.enchantmentstats.utilities.Factory;

public class SimpleItemTypeBuilderFactory implements Factory<ItemTypeBuilder> {
    @Override
    public SimpleItemTypeBuilder create() {
        return new SimpleItemTypeBuilder();
    }
}
