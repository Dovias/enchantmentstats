package me.dovias.enchantstats.fabric.adapter;

import me.dovias.enchantstats.VersionAdapter;
import net.minecraft.client.MinecraftClient;

public class FabricVersionAdapter implements VersionAdapter {
    @Override
    public String getVersion() {
        return MinecraftClient.getInstance().getGameVersion();
    }
}
