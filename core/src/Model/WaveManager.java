package Model;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.SpaceTerrorists;
import view.WavePassedScreen;

public class WaveManager {
    public static WaveManager waveManager;
    public int wave;
    public float accuracy;

    public WaveManager() {
        waveManager = this;
        wave = 1;
        accuracy = 0;
    }

    public void waveChanger(SpaceTerrorists spaceTerrorists) {
        if (wave == 1) {
            if (Player.player.killCount >= 40) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new WavePassedScreen(spaceTerrorists));
            }
        }
        else if(wave==2){
            if(Player.player.killCount>= 80){
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new WavePassedScreen(spaceTerrorists));
            }
        }
        else{
            if(Player.player.killCount>=160){
                Gdx.app.exit();
            }
        }
    }

    public void reset() {
        Player player = Player.player;
        player.shotCount = 0;
        player.killCount = 0;
        player.successfullShotCount = 0;
    }

}
