package me.dovias.enchantmentstats.fabric.hook;

import me.dovias.enchantmentstats.VersionHook;
import net.minecraft.client.MinecraftClient;

public class FabricVersionHook implements VersionHook {
    @Override
    public String getVersion() {
        return MinecraftClient.getInstance().getGameVersion();
    }
}
