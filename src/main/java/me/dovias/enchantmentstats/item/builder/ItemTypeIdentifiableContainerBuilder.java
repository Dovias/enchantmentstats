package me.dovias.enchantmentstats.item.builder;

import me.dovias.enchantmentstats.identity.Identifiable;
import me.dovias.enchantmentstats.identity.IdentifiableContainer;
import me.dovias.enchantmentstats.identity.SimpleIdentifiableContainer;
import me.dovias.enchantmentstats.item.Item;
import me.dovias.enchantmentstats.utilities.Builder;
import me.dovias.enchantmentstats.utilities.Factory;

public class ItemTypeIdentifiableContainerBuilder implements Identifiable.Customizer<String, Item.Type.Customizer>, Builder<IdentifiableContainer<String, Item.Type>> {
    private final Factory<ItemTypeBuilder> factory;
    private ItemTypeBuilder builder;
    private String identifier;

    public ItemTypeIdentifiableContainerBuilder(Factory<ItemTypeBuilder> factory) {
        this.factory = factory;
    }

    @Override
    public Item.Type.Customizer setIdentifier(String identifier) {
        this.identifier = identifier;

        this.builder = this.factory.create();
        return this.builder;
    }

    @Override
    public SimpleIdentifiableContainer<String, Item.Type> build() {
        return new SimpleIdentifiableContainer<>(this.identifier, this.builder.build());
    }
}