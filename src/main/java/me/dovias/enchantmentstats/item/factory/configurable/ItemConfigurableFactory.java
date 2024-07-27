package me.dovias.enchantmentstats.item.factory.configurable;

import me.dovias.enchantmentstats.item.Item;
import me.dovias.enchantmentstats.item.builder.ItemBuilder;
import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.utilities.Factory;

import java.util.function.Consumer;

public class ItemConfigurableFactory implements ConfigurableFactory<Item.Customizer, Item> {
    private final Factory<ItemBuilder> factory;

    public ItemConfigurableFactory(Factory<ItemBuilder> factory) {
        this.factory = factory;
    }

    @Override
    public Item create(Consumer<Item.Customizer> configurer) {
        ItemBuilder builder = this.factory.create();
        configurer.accept(builder);
        return builder.build();
    }
}
