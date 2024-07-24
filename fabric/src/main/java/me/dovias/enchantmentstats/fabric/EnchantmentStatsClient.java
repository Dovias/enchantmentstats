package me.dovias.enchantmentstats.fabric;

import me.dovias.enchantmentstats.EnchantmentStats;
import me.dovias.enchantmentstats.VersionAdapter;
import me.dovias.enchantmentstats.VersionAdapterFactory;
import net.fabricmc.api.ClientModInitializer;

import java.util.Optional;
import java.util.ServiceLoader;

public class EnchantmentStatsClient implements EnchantmentStats, ClientModInitializer {
    private VersionAdapter adapter;

    @Override
    public String getBrand() {
        return "fabric";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public void onInitializeClient() {
        Optional<VersionAdapterFactory> loader = ServiceLoader.load(VersionAdapterFactory.class).findFirst();
        if (loader.isEmpty()) {
            System.out.println("no version adapter found!");
            return;
        }

        VersionAdapterFactory factory = loader.get();
        this.adapter = factory.getVersionAdapter();

        System.out.println("Loaded adapter version: " + this.adapter.getVersion());
    }
}
