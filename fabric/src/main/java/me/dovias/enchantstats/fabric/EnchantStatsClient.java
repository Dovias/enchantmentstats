package me.dovias.enchantstats.fabric;

import me.dovias.enchantstats.EnchantStats;
import me.dovias.enchantstats.VersionAdapter;
import me.dovias.enchantstats.VersionAdapterFactory;
import net.fabricmc.api.ClientModInitializer;

import java.util.Optional;
import java.util.ServiceLoader;

public class EnchantStatsClient implements EnchantStats, ClientModInitializer {
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
