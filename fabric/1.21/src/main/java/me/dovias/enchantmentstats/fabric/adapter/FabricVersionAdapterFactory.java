package me.dovias.enchantmentstats.fabric.adapter;

import me.dovias.enchantmentstats.VersionAdapter;
import me.dovias.enchantmentstats.VersionAdapterFactory;

public class FabricVersionAdapterFactory implements VersionAdapterFactory {
    @Override
    public VersionAdapter getVersionAdapter() {
        return new FabricVersionAdapter();
    }
}
