package me.dovias.enchantmentstats.item.factory;

import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.item.Item;
import me.dovias.enchantmentstats.item.builder.ItemBuilder;
import me.dovias.enchantmentstats.item.builder.SimpleItemBuilder;
import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.utilities.Factory;

public class SimpleItemBuilderFactory implements Factory<ItemBuilder> {
    private final ConfigurableFactory<Item.Type.Customizer, Item.Type> itemTypeFactory;
    private final ConfigurableFactory<Enchantment.Customizer, Enchantment> enchantmentFactory;

    public SimpleItemBuilderFactory(ConfigurableFactory<Item.Type.Customizer, Item.Type> itemTypeFactory, ConfigurableFactory<Enchantment.Customizer, Enchantment> enchantmentFactory) {
        this.itemTypeFactory = itemTypeFactory;
        this.enchantmentFactory = enchantmentFactory;
    }

    @Override
    public SimpleItemBuilder create() {
        return new SimpleItemBuilder(this.itemTypeFactory, this.enchantmentFactory);
    }
}
