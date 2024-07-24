package me.dovias.enchantmentstats.fabric.adapter;

import me.dovias.enchantmentstats.VersionAdapter;
import net.minecraft.client.MinecraftClient;

public class FabricVersionAdapter implements VersionAdapter {
    @Override
    public String getVersion() {
        return MinecraftClient.getInstance().getGameVersion();
    }
}
