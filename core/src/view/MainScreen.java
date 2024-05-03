package view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

public class MainScreen implements Screen {
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Label title = new Label("Space Terrorists", skin);
    TextButton newGameButton = new TextButton("new game",skin);
    Table root = new Table();
    public MainScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists=spaceTerrorists;
        batch= spaceTerrorists.batch;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        root.setFillParent(true);
        stage.addActor(title);
        stage.addActor(root);
        title.setFontScale(6);
        title.setColor(1,1,1,1);
        title.setWidth(Gdx.graphics.getWidth());
        title.setPosition(670, Gdx.graphics.getHeight() - title.getHeight()-200);
        root.add(newGameButton).height(50).width(300).row();
        newGameButton.getLabel().setFontScale(2);
        newGameButton.addListener(new ClickListener(){
           @Override
           public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y){
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
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f));
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
        stage.dispose();
    }
}
