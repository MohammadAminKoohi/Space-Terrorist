package view;

import Collectibles.Collectible;
import Controller.GameController;
import Model.Bomb.Bomb;
import Model.Bomb.NormalBomb;
import Model.Player;
import Model.Spawner;
import Obstacles.Obstacle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

import java.util.ArrayList;

public class GameScreen implements Screen {
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Spawner spawner = Spawner.spawner;
    Label killCount = new Label("Kill Count: "+Player.player.killCount,skin);
    Label health = new Label("Health: "+Player.player.Hitpoint,skin);
    Label atomicBombs = new Label("Atomic Bombs: "+Player.player.atomicBombs,skin);
    Label clusterBombs = new Label("Cluster Bombs: "+Player.player.clusterBombs,skin);
    Label debug = new Label("Debug",skin);

    public GameScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists = spaceTerrorists;
        batch = spaceTerrorists.batch;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        killCount.setPosition(0,Gdx.graphics.getHeight()-killCount.getHeight()-20);
        killCount.setFontScale(2);
        killCount.setColor(1,1,1,1);
        stage.addActor(killCount);
        health.setPosition(0,Gdx.graphics.getHeight()-killCount.getHeight()-health.getHeight()-60);
        health.setFontScale(2);
        health.setColor(1,1,1,1);
        stage.addActor(health);
        atomicBombs.setPosition(0,Gdx.graphics.getHeight()-killCount.getHeight()-health.getHeight()-atomicBombs.getHeight()-100);
        atomicBombs.setFontScale(2);
        atomicBombs.setColor(1,1,1,1);
        stage.addActor(atomicBombs);
        clusterBombs.setPosition(0,Gdx.graphics.getHeight()-killCount.getHeight()-health.getHeight()-atomicBombs.getHeight()-clusterBombs.getHeight()-140);
        clusterBombs.setFontScale(2);
        clusterBombs.setColor(1,1,1,1);
        stage.addActor(clusterBombs);
        debug.setPosition(0,Gdx.graphics.getHeight()-killCount.getHeight()-health.getHeight()-atomicBombs.getHeight()-clusterBombs.getHeight()-debug.getHeight()-180);
        debug.setFontScale(2);
        debug.setColor(1,1,1,1);
        stage.addActor(debug);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        objectRender();
        collectibleRender();
        batch.end();
        collectibleUpdate();
        objectUpdate();
        gameUiUpdate();
        removeDestroyed();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 144f));
        stage.draw();
    }
    public void gameUiUpdate(){
        killCount.setText("Kill Count: "+Player.player.killCount);
        health.setText("Health: "+Player.player.Hitpoint);
        atomicBombs.setText("Atomic Bombs: "+Player.player.atomicBombs);
        clusterBombs.setText("Cluster Bombs: "+Player.player.clusterBombs);
        debug.setText("Debug: "+ Collectible.collectibles.size());
    }
    public void objectRender(){
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Player.player.planeSprite.draw(batch);
        for(Bomb bomb: Player.player.bombs){
            bomb.bombSprite.draw(batch);
        }
        spawner.spawn(batch);
    }
    public void objectUpdate(){
        GameController.update(spaceTerrorists);
        for(Bomb bomb: Player.player.bombs){
            bomb.update(Gdx.graphics.getDeltaTime());
        }
        spawner.update(Gdx.graphics.getDeltaTime());
    }
    public void collectibleRender(){
        for(Collectible collectible: Collectible.collectibles){
            collectible.sprite.draw(batch);
        }
    }
    public void collectibleUpdate(){
        System.out.println(Collectible.collectibles.size());
        for(Collectible collectible: Collectible.collectibles){
            collectible.update(Gdx.graphics.getDeltaTime());
        }
    }
    public void removeDestroyed(){
        ArrayList<Bomb> removeList = new ArrayList<Bomb>();
        for(Bomb bomb: Player.player.bombs){
            if(bomb.isDestroyed){
                removeList.add(bomb);
            }
        }
        for(Bomb bomb: removeList){
            Player.player.bombs.remove(bomb);
        }
        ArrayList<Obstacle> removeList2 = new ArrayList<Obstacle>();
        for(Obstacle obstacle: Obstacle.obstacles){
            if(obstacle.isDestroyed){
                removeList2.add(obstacle);
            }
        }
        for(Obstacle obstacle: removeList2){
            Obstacle.obstacles.remove(obstacle);
        }
        ArrayList<Collectible> removeList3 = new ArrayList<Collectible>();
        for(Collectible collectible: Collectible.collectibles){
            if(collectible.isDestroyed){
                removeList3.add(collectible);
            }
        }
        for(Collectible collectible: removeList3){
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

    }
}
