package me.dovias.enchantmentstats.fabric;

import me.dovias.enchantmentstats.EnchantmentStatsMod;
import me.dovias.enchantmentstats.VersionHook;
import me.dovias.enchantmentstats.VersionHookFactory;
import net.fabricmc.api.ClientModInitializer;

import java.util.Optional;
import java.util.ServiceLoader;

public class EnchantmentStatsClient implements ClientModInitializer {
    private final EnchantmentStatsMod mod = new EnchantmentStatsMod();

    private VersionHook adapter;

    @Override
    public void onInitializeClient() {
        Optional<VersionHookFactory> loader = ServiceLoader.load(VersionHookFactory.class).findFirst();
        if (loader.isEmpty()) {
            System.out.println("no version adapter found!");
            return;
        }

        VersionHookFactory factory = loader.get();
        this.adapter = factory.getVersionAdapter(this.mod);

        System.out.println("Loaded adapter version: " + this.adapter.getVersion());
    }

    public EnchantmentStatsMod getMod() {
        return this.mod;
    }
}
