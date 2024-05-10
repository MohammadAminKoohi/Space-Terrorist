package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(144);
        config.setWindowedMode(1920, 1080);
        config.setWindowIcon("icon.png");
        config.setTitle("Space Terrorists");
        new Lwjgl3Application(new SpaceTerrorists(), config);
    }
}
