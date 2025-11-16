package com.zoid.nhg;

import com.zoid.nhg.listener.DeathScreenListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoHandGhosts extends JavaPlugin {

    public static NoHandGhosts instance;

    @Override
    public void onEnable() {
        instance = this;
        registerEvents();
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new DeathScreenListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
