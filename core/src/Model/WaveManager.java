package Model;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.SpaceTerrorists;
import view.GameOverScreen;
import view.WavePassedScreen;

public class WaveManager {
    public static WaveManager waveManager;
    public int wave;
    public float accuracy;
    public int difficulty;
    public WaveManager() {
        waveManager = this;
        wave = 1;
        accuracy = 0;
        difficulty= GameSettings.difficulty;
    }

    public void waveChanger(SpaceTerrorists spaceTerrorists, boolean force) {
        if (wave == 1) {
            if (Player.player.killCount >= 40 || force) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new WavePassedScreen(spaceTerrorists));
            }
        } else if (wave == 2) {
            if (Player.player.killCount >= 100 || force) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new WavePassedScreen(spaceTerrorists));
            }
        } else if (wave == 3) {
            if (Player.player.killCount >= 200 || force) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new GameOverScreen(spaceTerrorists));
            }
        }
    }

}
