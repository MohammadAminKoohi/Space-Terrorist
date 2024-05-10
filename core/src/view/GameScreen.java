package view;

import Collectibles.Collectible;
import Controller.GameController;
import Model.Bomb.Bomb;
import Model.Bomb.NormalBomb;
import Model.Fire;
import Model.Player;
import Model.Spawner;
import Model.WaveManager;
import Obstacles.Obstacle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

import java.util.ArrayList;

public class GameScreen implements Screen {
    WaveManager waveManager;
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Spawner spawner = Spawner.spawner;
    Label killCount = new Label("Kill Count: " + Player.player.killCount, skin);
    Label health = new Label("Health: " + Player.player.Hitpoint, skin);
    Label atomicBombs = new Label("Atomic Bombs: " + Player.player.atomicBombs, skin);
    Label clusterBombs = new Label("Cluster Bombs: " + Player.player.clusterBombs, skin);
    Label wave = new Label("Wave: ", skin);
    Label accuracy = new Label("Accuracy: ", skin);
    Window window = new Window("Paused", skin);
    TextButton saveAndExit = new TextButton("Save and Exit", skin);
    TextButton exit = new TextButton("Exit", skin);
    
    public GameScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists = spaceTerrorists;
        batch = spaceTerrorists.batch;
        if (WaveManager.waveManager == null) {
            waveManager = new WaveManager();
        }
        else{
            waveManager = WaveManager.waveManager;
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        //atomic and cluster bombs
        atomicBombs.setPosition(0, Gdx.graphics.getHeight() - 20);
        clusterBombs.setPosition(0, Gdx.graphics.getHeight() - 50);
        atomicBombs.setFontScale(2);
        clusterBombs.setFontScale(2);
        atomicBombs.setColor(1, 1, 1, 1);
        clusterBombs.setColor(1, 1, 1, 1);
        stage.addActor(atomicBombs);
        stage.addActor(clusterBombs);
        //health and killcount
        health.setPosition(300, Gdx.graphics.getHeight() - 20);
        killCount.setPosition(300, Gdx.graphics.getHeight() - 50);
        health.setFontScale(2);
        killCount.setFontScale(2);
        health.setColor(1, 1, 1, 1);
        killCount.setColor(1, 1, 1, 1);
        stage.addActor(health);
        stage.addActor(killCount);
        //wave
        wave.setPosition(600, Gdx.graphics.getHeight() - 20);
        wave.setFontScale(2);
        wave.setColor(1, 1, 1, 1);
        stage.addActor(wave);
        //Accuracy
        accuracy.setPosition(600, Gdx.graphics.getHeight() - 50);
        accuracy.setFontScale(2);
        accuracy.setColor(1, 1, 1, 1);
        stage.addActor(accuracy);
        //pause window
        window.setSize(900, 600);
        window.setPosition(Gdx.graphics.getWidth()/2-450,Gdx.graphics.getHeight()/2-300);
        window.getTitleLabel().setAlignment(1);
        window.setColor(1,1,1,0.75f);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        waveManager.waveChanger(spaceTerrorists,false);
        batch.begin();
        objectRender();
        collectibleRender();
        fireRender();
        batch.end();
        GameController.update(spaceTerrorists);
        if(!spaceTerrorists.isPaused){
            window.setVisible(false);
            objectUpdate();
            collectibleUpdate();
            fireUpdate();
            gameUiUpdate();
            removeDestroyed();
        }
        else{
            stage.addActor(window);
            window.setVisible(true);
        }
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 144f));
        stage.draw();
    }

    public void gameUiUpdate() {
        killCount.setText("Kill Count: " + Player.player.killCount);
        health.setText("Health: " + Player.player.Hitpoint);
        atomicBombs.setText("Atomic Bombs: " + Player.player.atomicBombs);
        clusterBombs.setText("Cluster Bombs: " + Player.player.clusterBombs);
        wave.setText("Wave: " + WaveManager.waveManager.wave);
        accuracy.setText("Accuracy: " + Player.player.getAccuracy());
    }
    public void fireRender(){
        for(Fire fire:Fire.fires){
            fire.fireSprite.draw(batch);
        }
    }
    public void fireUpdate(){
        for(Fire fire:Fire.fires){
            fire.update(Gdx.graphics.getDeltaTime());
        }
    }
    public void objectRender() {
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Player.player.planeSprite.draw(batch);
        for (Bomb bomb : Player.player.bombs) {
            bomb.bombSprite.draw(batch);
        }
        spawner.spawn(batch);
    }

    public void objectUpdate() {
        if(!spaceTerrorists.isPaused){
            for (Bomb bomb : Player.player.bombs) {
                bomb.update(Gdx.graphics.getDeltaTime());
            }
            spawner.update(Gdx.graphics.getDeltaTime());
        }
    }

    public void collectibleRender() {
        for (Collectible collectible : Collectible.collectibles) {
            collectible.sprite.draw(batch);
        }
    }

    public void collectibleUpdate() {
        System.out.println(Collectible.collectibles.size());
        for (Collectible collectible : Collectible.collectibles) {
            collectible.update(Gdx.graphics.getDeltaTime());
        }
    }

    public void removeDestroyed() {
        ArrayList<Bomb> removeList = new ArrayList<Bomb>();
        for (Bomb bomb : Player.player.bombs) {
            if (bomb.isDestroyed) {
                removeList.add(bomb);
            }
        }
        for (Bomb bomb : removeList) {
            Player.player.bombs.remove(bomb);
        }
        ArrayList<Obstacle> removeList2 = new ArrayList<Obstacle>();
        for (Obstacle obstacle : Obstacle.obstacles) {
            if (obstacle.isDestroyed) {
                Fire.fires.remove(obstacle.fire);
                removeList2.add(obstacle);
            }
        }
        for (Obstacle obstacle : removeList2) {
            Obstacle.obstacles.remove(obstacle);
        }
        ArrayList<Collectible> removeList3 = new ArrayList<Collectible>();
        for (Collectible collectible : Collectible.collectibles) {
            if (collectible.isDestroyed) {
                removeList3.add(collectible);
            }
        }
        for (Collectible collectible : removeList3) {
            Collectible.collectibles.remove(collectible);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.stage.dispose();
        Obstacle.obstacles = new ArrayList<Obstacle>();
        Collectible.collectibles = new ArrayList<Collectible>();
        Player.player.bombs = new ArrayList<Bomb>();
        Spawner.spawner = new Spawner();
        Fire.fires = new ArrayList<Fire>();
    }
}
