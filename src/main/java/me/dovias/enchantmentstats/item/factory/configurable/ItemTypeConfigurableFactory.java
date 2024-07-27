package me.dovias.enchantmentstats.item.factory.configurable;

import me.dovias.enchantmentstats.item.Item;
import me.dovias.enchantmentstats.item.builder.ItemTypeBuilder;
import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.utilities.Factory;

import java.util.function.Consumer;

public class ItemTypeConfigurableFactory implements ConfigurableFactory<Item.Type.Customizer, Item.Type> {
    private final Factory<ItemTypeBuilder> factory;

    public ItemTypeConfigurableFactory(Factory<ItemTypeBuilder> factory) {
        this.factory = factory;
    }

    @Override
    public Item.Type create(Consumer<Item.Type.Customizer> configurer) {
        ItemTypeBuilder builder = this.factory.create();
        configurer.accept(builder);
        return builder.build();
    }
}
