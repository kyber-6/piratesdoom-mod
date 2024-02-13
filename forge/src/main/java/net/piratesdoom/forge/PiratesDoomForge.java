package net.piratesdoom.forge;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.piratesdoom.PiratesDoom;

@Mod(PiratesDoom.MOD_ID)
public class PiratesDoomForge {
    public PiratesDoomForge() {
        PiratesDoom.init();
        if (detectPirate()) {
            PiratesDoom.installMochaDoom();
            PiratesDoom.installIWAD();
            PiratesDoom.doomThePirate();
        }
    }

    private boolean detectPirate() {
        return ModList.get().isLoaded(PiratesDoom.TLAUNCHER_MOD_1) || PiratesDoom.pirateyLog();
    }
}
