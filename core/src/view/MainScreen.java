package view;

import Model.Collectibles.Collectible;
import Model.Bomb.Bomb;
import Model.Fire;
import Model.Player;
import Model.Spawner;
import Model.User;
import Model.Obstacles.Obstacle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

import java.util.ArrayList;

public class MainScreen implements Screen {
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Label title = new Label("Space Terrorists", skin);
    TextButton continueButton = new TextButton("Continue", skin);
    TextButton newGameButton = new TextButton("New game", skin);
    TextButton profileButton = new TextButton("Profile",skin);
    TextButton scoreBoard = new TextButton("Score Board", skin);
    TextButton settings = new TextButton("Settings",skin);
    Image currentAvatar;
    Label username;
    Table root = new Table();
    public MainScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists = spaceTerrorists;
        batch = spaceTerrorists.batch;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        root.setFillParent(true);
        title.setFontScale(6);
        title.setColor(1, 1, 1, 1);
        title.setSize(6*title.getWidth(),6*title.getHeight());
        title.setWidth(Gdx.graphics.getWidth());
        title.setPosition(640, 850);
        stage.addActor(title);
        stage.addActor(root);
        continueButton.getLabel().setFontScale(2);
        newGameButton.getLabel().setFontScale(2);
        profileButton.getLabel().setFontScale(2);
        scoreBoard.getLabel().setFontScale(2);
        settings.getLabel().setFontScale(2);
        root.add(continueButton).height(50).width(300).padTop(100).row();
        root.add(newGameButton).height(50).width(300).padTop(20).row();
        if(User.loggedInUser != null){
            root.add(profileButton).height(50).width(300).padTop(20).row();
            currentAvatar = new Image(User.loggedInUser.getAvatar());
            stage.addActor(currentAvatar);
            currentAvatar.setSize(150, 150);
            currentAvatar.setPosition(10, Gdx.graphics.getHeight()-160);
            username = new Label(User.loggedInUser.getUsername(), skin);
            username.setFontScale(2);
            username.setColor(1, 1, 1, 1);
            username.setPosition(170, Gdx.graphics.getHeight()-40);
            stage.addActor(username);
        }
        root.add(scoreBoard).height(50).width(300).padTop(20).row();
        root.add(settings).height(50).width(300).padTop(20).row();
        continueButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new GameScreen(spaceTerrorists));
            }
        });

        newGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                spaceTerrorists.getScreen().dispose();
                Obstacle.obstacles = new ArrayList<Obstacle>();
                Collectible.collectibles = new ArrayList<Collectible>();
                Player.player.bombs = new ArrayList<Bomb>();
                Spawner.spawner = new Spawner();
                Fire.fires = new ArrayList<Fire>();
                spaceTerrorists.setScreen(new GameScreen(spaceTerrorists));
            }
        });
        profileButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new ProfileScreen(spaceTerrorists));
            }
        });
        scoreBoard.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new ScoreBoardScreen(spaceTerrorists));
            }
        });
        settings.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new SettingsScreen(spaceTerrorists));
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
        if(Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ESCAPE)){
            User.loggedInUser= null;
            spaceTerrorists.setScreen(new LoginScreen(spaceTerrorists));
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
        stage.dispose();
    }
}
