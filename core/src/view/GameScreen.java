package view;

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

    public GameScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists = spaceTerrorists;
        batch = spaceTerrorists.batch;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        objectRender();
        objectUpdate();
        removeDestroyed();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 144f));
        stage.draw();
    }
    public void objectRender(){
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Player.player.planeSprite.draw(batch);
        for(Bomb bomb: Player.player.bombs){
            bomb.bombSprite.draw(batch);
        }
        spawner.spawn(batch);
        batch.end();
    }
    public void objectUpdate(){
        GameController.update(spaceTerrorists);
        for(Bomb bomb: Player.player.bombs){
            bomb.update(Gdx.graphics.getDeltaTime());
        }
        spawner.update(Gdx.graphics.getDeltaTime());
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
