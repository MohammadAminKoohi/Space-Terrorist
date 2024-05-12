package view;

import Model.GameSettings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;
import sun.tools.jconsole.Tab;

public class SettingsScreen implements Screen {
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Label title = new Label("Settings", skin);
    Label difficulty = new Label("Difficulty", skin);
    TextButton easy = new TextButton("Easy", skin);
    TextButton medium = new TextButton("Medium", skin);
    TextButton hard = new TextButton("Hard", skin);
    Label result = new Label("", skin);
    Label controls = new Label("Controls", skin);
    TextButton WASD = new TextButton("WASD", skin);
    TextButton arrow = new TextButton("Arrow", skin);
    Label result2 = new Label("", skin);
    Button.ButtonStyle buttonStyle = skin.get("music", Button.ButtonStyle.class);
    Button musicButton = new Button(buttonStyle);
    Table root = new Table();
    Table controlsTable = new Table();

    public SettingsScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists = spaceTerrorists;
        batch = spaceTerrorists.batch;
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        title.setFontScale(6);
        title.setSize(6*title.getWidth(), 6*title.getHeight());
        title.setColor(1, 1, 1, 1);
        title.setPosition(Gdx.graphics.getWidth()/2 - title.getWidth()/2, 850);
        stage.addActor(title);
        stage.addActor(root);
        stage.addActor(controlsTable);
        root.setFillParent(true);
        controlsTable.setFillParent(true);
        difficulty.setFontScale(4);
        difficulty.setColor(1, 1, 1, 1);
        difficulty.setSize(50,300);
        difficulty.setAlignment(Align.center);
        controls.setFontScale(4);
        controls.setColor(1, 1, 1, 1);
        controls.setSize(50,300);
        controls.setAlignment(Align.center);
        root.add(difficulty).height(50).width(300).row();
        root.add(easy).height(50).width(300).padTop(10).row();
        root.add(medium).height(50).width(300).padTop(10).row();
        root.add(hard).height(50).width(300).padTop(10).row();
        root.add(result).height(50).width(300).padTop(10).padBottom(100);
        result.setFontScale(2);
        controlsTable.add(controls).height(50).width(300).padTop(500).row();
        controlsTable.add(WASD).height(50).width(300).padTop(10).row();
        controlsTable.add(arrow).height(50).width(300).padTop(10).row();
        controlsTable.add(musicButton).height(50).width(50).padTop(10).row();
        controlsTable.add(result2).height(50).width(300).padTop(10).row();
        result2.setFontScale(2);
        easy.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                GameSettings.setDifficulty(1);
                result.setText("Difficulty set to Easy");
            }
        });
        medium.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                GameSettings.setDifficulty(2);
                result.setText("Difficulty set to Medium");
            }
        });
        hard.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                GameSettings.setDifficulty(3);
                result.setText("Difficulty set to Hard");
            }
        });
        WASD.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                GameSettings.setInputs(1);
                result2.setText("Controls set to WASD");
            }
        });
        arrow.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                GameSettings.setInputs(2);
                result2.setText("Controls set to Arrow");
            }
        });
        if(SpaceTerrorists.music.isPlaying()){
            musicButton.setChecked(true);
        }
        else{
            musicButton.setChecked(false);
        }
        musicButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                if (SpaceTerrorists.music.isPlaying()) {
                    SpaceTerrorists.music.pause();
                } else {
                    SpaceTerrorists.music.play();
                }
            }
        });

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.act();
        stage.draw();
        if(Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ESCAPE)){
            spaceTerrorists.setScreen(new MainScreen(spaceTerrorists));
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
