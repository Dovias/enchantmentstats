package me.dovias.enchantmentstats.fabric.hook;

import me.dovias.enchantmentstats.EnchantmentStats;
import me.dovias.enchantmentstats.VersionHook;
import me.dovias.enchantmentstats.VersionHookFactory;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class FabricVersionHookFactory implements VersionHookFactory {
    @Override
    public VersionHook create(EnchantmentStats mod) {
        ClientPlayConnectionEvents.JOIN.register(new RegistrySyncListener(mod.getEnchantmentTypeManager(), mod.getItemTypeManager()));
        return new FabricVersionHook();
    }
}
