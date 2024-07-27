package me.dovias.enchantmentstats.enchantment.builder;

import me.dovias.enchantmentstats.utilities.ConfigurableFactory;
import me.dovias.enchantmentstats.enchantment.Enchantment;
import me.dovias.enchantmentstats.enchantment.SimpleEnchantmentType;
import me.dovias.enchantmentstats.item.Item;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleEnchantmentTypeBuilder implements EnchantmentTypeBuilder {
    private int weight;
    private int minLevel;
    private int maxLevel;
    private Enchantment.Cost minCost;
    private Enchantment.Cost maxCost;
    private boolean enchantability;
    private Set<Enchantment.Type> compatibleEnchantmentTypes;
    private Set<Item.Type> compatibleItemTypes;

    private final ConfigurableFactory<Enchantment.Type.Customizer, Enchantment.Type> enchantmentTypeFactory;
    private final ConfigurableFactory<Enchantment.Cost.Customizer, Enchantment.Cost> enchantmentCostFactory;
    private final ConfigurableFactory<Item.Type.Customizer, Item.Type> itemTypeFactory;

    public SimpleEnchantmentTypeBuilder(ConfigurableFactory<Enchantment.Cost.Customizer, Enchantment.Cost> enchantmentCostFactory, ConfigurableFactory<Item.Type.Customizer, Item.Type> itemTypeFactory) {
        this(null, enchantmentCostFactory, itemTypeFactory);
    }

    public SimpleEnchantmentTypeBuilder(ConfigurableFactory<Enchantment.Type.Customizer, Enchantment.Type> enchantmentTypeFactory, ConfigurableFactory<Enchantment.Cost.Customizer, Enchantment.Cost> enchantmentCostFactory, ConfigurableFactory<Item.Type.Customizer, Item.Type> itemTypeFactory) {
        this.enchantmentTypeFactory = enchantmentTypeFactory;
        this.enchantmentCostFactory = enchantmentCostFactory;
        this.itemTypeFactory = itemTypeFactory;
    }

    @Override
    public SimpleEnchantmentTypeBuilder setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public SimpleEnchantmentTypeBuilder setMinLevel(int minLevel) {
        this.minLevel = minLevel;
        return this;
    }

    @Override
    public SimpleEnchantmentTypeBuilder setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
        return this;
    }



    @Override
    public SimpleEnchantmentTypeBuilder setMinCost(Enchantment.Cost.Customizer.Configurer cost) {
        this.minCost = this.enchantmentCostFactory.create(cost);
        return this;
    }

    @Override
    public Enchantment.Type.Customizer setMaxCost(Enchantment.Cost.Customizer.Configurer cost) {
        this.maxCost = this.enchantmentCostFactory.create(cost);
        return this;
    }

    public SimpleEnchantmentTypeBuilder setEnchantability(boolean enchantability) {
        this.enchantability = enchantability;
        return this;
    }

    @Override
    public SimpleEnchantmentTypeBuilder setCompatibleEnchantmentTypes(Configurer... configurers) {
        Stream<Configurer> stream = Arrays.stream(configurers);
        this.compatibleEnchantmentTypes = (this.enchantmentTypeFactory != null ? stream.map(this.enchantmentTypeFactory::create) : stream.map(configurer -> {
            SimpleEnchantmentTypeBuilder builder = new SimpleEnchantmentTypeBuilder(this.enchantmentCostFactory, this.itemTypeFactory);

            configurer.accept(builder);
            return builder.build();
        })).collect(Collectors.toSet());

        return this;
    }

    @Override
    public SimpleEnchantmentTypeBuilder setCompatibleItemTypes(Item.Type.Customizer.Configurer... other) {
        this.compatibleItemTypes = Arrays.stream(other)
            .map(this.itemTypeFactory::create)
            .collect(Collectors.toSet());

        return this;
    }

    @Override
    public SimpleEnchantmentType build() {
        return new SimpleEnchantmentType(
            this.weight,
            this.minLevel,
            this.maxLevel,
            this.minCost,
            this.maxCost,
            this.enchantability,
            this.compatibleEnchantmentTypes,
            this.compatibleItemTypes
        );
    }
}
