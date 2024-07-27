package me.dovias.enchantmentstats.item;

import me.dovias.enchantmentstats.enchantment.Enchantment;

import java.util.function.Consumer;

public interface Item {
    Type getType();
    boolean isEnchantedWith(Enchantment enchantment);

    interface Type {
        int getEnchantability();

        interface Customizer {
            interface Configurer extends Consumer<Customizer> {}

            Customizer setEnchantability(int enchantability);
        }
    }

    interface Customizer {
        Customizer setType(Type.Customizer.Configurer configurer);
        Customizer setEnchantments(Enchantment.Customizer.Configurer... configurers);
    }
}