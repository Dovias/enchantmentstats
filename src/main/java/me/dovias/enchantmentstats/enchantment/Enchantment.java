package me.dovias.enchantmentstats.enchantment;

import me.dovias.enchantmentstats.item.Item;

import java.util.function.Consumer;

public interface Enchantment {
    Type getType();
    int getLevel();

    interface Customizer {
        interface Configurer extends Consumer<Customizer> {}

        Customizer setType(Type.Customizer.Configurer configurer);
        Customizer setLevel(int level);
    }

    interface Cost {
        int getLevelCost(int level);

        interface Customizer {
            interface Configurer extends Consumer<Customizer> {}

            Customizer setBaseCost(int cost);
            Customizer setPerLevelCost(int cost);
        }
    }

    interface Type {
        int getWeight();
        int getMinLevel();
        int getMaxLevel();
        Cost getMinCost();
        Cost getMaxCost();
        boolean isEnchantable();
        boolean isCompatibleWith(Type type);
        boolean isCompatibleWith(Item.Type type);

        interface Customizer {
            interface Configurer extends Consumer<Customizer> {}

            Customizer setWeight(int level);
            Customizer setMinLevel(int level);
            Customizer setMaxLevel(int level);
            Customizer setMinCost(Cost.Customizer.Configurer cost);
            Customizer setMaxCost(Cost.Customizer.Configurer cost);
            Customizer setEnchantability(boolean enchantability);
            Customizer setCompatibleEnchantmentTypes(Configurer... configurers);
            Customizer setCompatibleItemTypes(Item.Type.Customizer.Configurer... configurers);
        }
    }
}

