package me.dovias.enchantmentstats.fabric.hook;

import me.dovias.enchantmentstats.EnchantmentStatsMod;
import me.dovias.enchantmentstats.VersionHook;
import me.dovias.enchantmentstats.VersionHookFactory;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class FabricVersionHookFactory implements VersionHookFactory {
    @Override
    public VersionHook getVersionAdapter(EnchantmentStatsMod mod) {
        ClientPlayConnectionEvents.JOIN.register(new RegistrySyncListener(mod.getEnchantments(), mod.getItemTypes()));
        return new FabricVersionHook();
    }
}
