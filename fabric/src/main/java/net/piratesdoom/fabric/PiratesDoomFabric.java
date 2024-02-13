package net.piratesdoom.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.piratesdoom.PiratesDoom;

public class PiratesDoomFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        PiratesDoom.init();
        if (detectPirate()) {
            PiratesDoom.installMochaDoom();
            PiratesDoom.installIWAD();
            PiratesDoom.doomThePirate();
        }
    }

    private boolean detectPirate() {
        return FabricLoader.getInstance().isModLoaded(PiratesDoom.TLAUNCHER_MOD_1) || PiratesDoom.pirateyLog();
    }
}
