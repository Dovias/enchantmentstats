package me.dovias.enchantmentstats.fabric;

import me.dovias.enchantmentstats.*;
import net.fabricmc.api.ClientModInitializer;

import java.util.Optional;
import java.util.ServiceLoader;

public class EnchantmentStatsClient implements ClientModInitializer {
    private VersionHook hook;
    private EnchantmentStats mod;

    @Override
    public void onInitializeClient() {
        Optional<EnchantmentStatsFactory> modFactoryOptional = ServiceLoader.load(EnchantmentStatsFactory.class).findFirst();
        if (modFactoryOptional.isEmpty()) {
            System.out.println("No EnchantmentStats intermediary classes found!");
            return;
        }
        this.mod = modFactoryOptional.get().create();

        Optional<VersionHookFactory> hookFactoryOptional = ServiceLoader.load(VersionHookFactory.class).findFirst();
        if (hookFactoryOptional.isEmpty()) {
            System.out.println("No version adapter found!");
            return;
        }
        this.hook = hookFactoryOptional.get().create(this.mod);
    }
}
