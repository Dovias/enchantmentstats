package me.dovias.enchantmentstats.item.builder;

import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.item.Item;
import me.dovias.enchantmentstats.item.SimpleItem;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleItemBuilder implements ItemBuilder {
    private final ConfigurableFactory<Item.Type.Customizer, Item.Type> itemTypeFactory;
    private final ConfigurableFactory<Enchantment.Customizer, Enchantment> enchantmentFactory;

    private Item.Type type;
    private Set<Enchantment> enchantments;

    public SimpleItemBuilder(ConfigurableFactory<Item.Type.Customizer, Item.Type> itemTypeFactory, ConfigurableFactory<Enchantment.Customizer, Enchantment> enchantmentFactory) {
        this.itemTypeFactory = itemTypeFactory;
        this.enchantmentFactory = enchantmentFactory;
    }

    @Override
    public SimpleItemBuilder setType(Item.Type.Customizer.Configurer configurer) {
        this.type = this.itemTypeFactory.create(configurer);
        return this;
    }

    @Override
    public SimpleItemBuilder setEnchantments(Enchantment.Customizer.Configurer... enchantments) {
        this.enchantments = Arrays.stream(enchantments)
            .map(enchantmentFactory::create)
            .collect(Collectors.toSet());

        return this;
    }

    @Override
    public SimpleItem build() {
        return new SimpleItem(type, enchantments);
    }
}
