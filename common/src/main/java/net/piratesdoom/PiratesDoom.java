package net.piratesdoom;

import net.piratesdoom.util.FileHelper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PiratesDoom {
    public static final String MOD_ID = "piratesdoom";
    public static final String TLAUNCHER_MOD_1 = "tlskincape";
    private static final String MOCHA_DOOM_URL = "https://sourceforge.net/projects/mochadoom/files/latest/download";
    private static final String MOCHA_DOOM_ZIP_SAVE_PATH = "mochadoom-alpha-16.zip";
    private static final String MOCHA_DOOM_SAVE_PATH = ".";
    private static final String MOCHA_DOOM_JAR_PATH = "mochadoom-alpha-16" + File.separator + "mochadoom.jar";
    private static final String IWAD_URL = "https://www.doomworld.com/3ddownloads/ports/shareware_doom_iwad.zip";
    private static final String IWAD_ZIP_SAVE_PATH = "mochadoom-alpha-16" + File.separator + "shareware_doom_iwad.zip";
    private static final String IWAD_SAVE_PATH = "mochadoom-alpha-16";
    private static final String IWAD_FILE_PATH = "mochadoom-alpha-16" + File.separator + "DOOM1.WAD";

    public static void init() {

    }

    public static void installMochaDoom() {
        try {
            FileHelper.downloadFile(MOCHA_DOOM_URL, MOCHA_DOOM_ZIP_SAVE_PATH);
            System.out.println("Downloaded file from " + MOCHA_DOOM_URL + " successfully.");
        } catch (IOException e) {
            System.exit(0);
        }
        try {
            FileHelper.unzip(MOCHA_DOOM_ZIP_SAVE_PATH, MOCHA_DOOM_SAVE_PATH);
            System.out.println("Extracted \"" + MOCHA_DOOM_ZIP_SAVE_PATH + "\" successfully.");
        } catch (IOException e) {
            System.exit(0);
        }
    }

    public static void installIWAD() {
        try {
            FileHelper.downloadFile(IWAD_URL, IWAD_ZIP_SAVE_PATH);
            System.out.println("Downloaded file from " + IWAD_URL + " successfully.");
        } catch (IOException e) {
            System.exit(0);
        }

        try {
            FileHelper.unzip(IWAD_ZIP_SAVE_PATH, IWAD_SAVE_PATH);
            System.out.println("Extracted file \"" + IWAD_ZIP_SAVE_PATH + "\" successfully.");
        } catch (IOException e) {
            System.exit(0);
        }
    }

    public static void doomThePirate() {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", MOCHA_DOOM_JAR_PATH, "-iwad", IWAD_FILE_PATH);
        Process process;
        try {
            process = processBuilder.start();
            process.waitFor();
            System.exit(0);
        } catch (IOException e) {
            System.exit(0);
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }

    public static boolean pirateyLog() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("logs/latest.log"));
        } catch (IOException e) {
            System.out.println("ERROR");
        }
        for (String line : lines) {
            if (line.contains("TLauncher") && !line.contains("ATLauncher")) {
                return true;
            }
        }
        return false;
    }
}