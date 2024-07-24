package me.dovias.enchantstats.fabric.adapter;

import me.dovias.enchantstats.VersionAdapter;
import me.dovias.enchantstats.VersionAdapterFactory;

public class FabricVersionAdapterFactory implements VersionAdapterFactory {
    @Override
    public VersionAdapter getVersionAdapter() {
        return new FabricVersionAdapter();
    }
}
