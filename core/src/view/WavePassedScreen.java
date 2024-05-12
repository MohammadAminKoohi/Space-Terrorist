package view;

import Model.Player;
import Model.WaveManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

public class WavePassedScreen implements Screen {
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Label title = new Label("Wave " + WaveManager.waveManager.wave + " passed!", skin);
    TextButton continueButton = new TextButton("Continue", skin);
    Label killCount = new Label("Kill Count: " + Player.player.killCount, skin);
    Label accuracy = new Label("Accuracy: " + Player.player.getAccuracy() + "%", skin);
    Table root = new Table();

    public WavePassedScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists = spaceTerrorists;
        batch = spaceTerrorists.batch;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.addActor(title);
        stage.addActor(root);
        title.setFontScale(6);
        title.setColor(1, 1, 1, 1);
        title.setWidth(Gdx.graphics.getWidth());
        title.setPosition(670, Gdx.graphics.getHeight() - title.getHeight() - 200);
        root.setFillParent(true);
        root.add(killCount).height(50).width(300).align(Align.center).row();
        root.add(accuracy).height(50).width(300).row();
        root.add(continueButton).height(50).width(300).row();
        continueButton.getLabel().setFontScale(2);
        continueButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                WaveManager.waveManager.wave++;
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new GameScreen(spaceTerrorists));
            }
        });

    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 144f));
        stage.draw();
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
    }
}
