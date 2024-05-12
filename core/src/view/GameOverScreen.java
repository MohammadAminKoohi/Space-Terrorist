package view;

import Model.Player;
import Model.User;
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
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

public class GameOverScreen implements Screen {
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Label title = new Label("", skin);
    Table root = new Table();
    Label Accuracy = new Label("Accuracy: " + Player.player.getAccuracy() + "%", skin);
    TextButton mainMenuButton = new TextButton("Main menu", skin);
    TextButton exitButton = new TextButton("Exit", skin);

    Label killCount = new Label("Kill Count: " + Player.player.killCount, skin);
    public GameOverScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists = spaceTerrorists;
        batch = spaceTerrorists.batch;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        if(User.loggedInUser!=null){
            User.loggedInUser.saveGame();
        }
//        WaveManager.waveManager =null;
        stage.addActor(title);
        stage.addActor(root);
        if(Player.player.Hitpoint<=0){
            title.setText("Game Over");
            title.setColor(1, 0, 0, 1);
        }
        else{
            title.setText("You Won!!!");
            title.setColor(0, 1, 0, 1);
        }
        title.setFontScale(6);
        title.setColor(1, 1, 1, 1);
        title.setPosition(725, Gdx.graphics.getHeight()-title.getHeight()-200);
        root.setFillParent(true);
        root.add(killCount).height(50).width(300).fillX();
        root.pad(4,0,10,0).row();
        root.add(Accuracy).height(50).width(300).fillX();
        root.pad(20,0,10,0).row();
        root.add(mainMenuButton).height(50).width(300);
        root.pad(30,0,30,0).row();
        root.add(exitButton).height(50).width(300);
        killCount.setFontScale(2);
        Accuracy.setFontScale(2);
        mainMenuButton.getLabel().setFontScale(2);
        exitButton.getLabel().setFontScale(2);
        mainMenuButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                spaceTerrorists.getScreen().dispose();
                WaveManager.waveManager=null;
                Player.player.newGame();
                spaceTerrorists.setScreen(new MainScreen(spaceTerrorists));
            }
        });
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
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
        stage.act();
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
