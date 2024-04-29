package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

public class LoginScreen implements Screen {
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Label title = new Label("Space Terrorists", skin);
    Label usernameLabel = new Label("Username", skin);
    Label passwordLabel = new Label("Password", skin);
    TextField username = new TextField("Username", skin);
    TextField password = new TextField("Password", skin);
    TextButton login = new TextButton("Login", skin);
    TextButton register = new TextButton("Register", skin);
    Table root = new Table();
    Animation<TextureRegion> animation;
    float elapsedTime;

    public LoginScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists = spaceTerrorists;
        batch = spaceTerrorists.batch;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        root.setFillParent(true);
        stage.addActor(title);
        stage.addActor(root);
        title.setFontScale(6);
        title.setColor(1,1,1,1);
        //put the title in the middle of the screen
        title.setWidth(Gdx.graphics.getWidth());
        title.setPosition(670, Gdx.graphics.getHeight() - title.getHeight()-200);
        //username setup
        usernameLabel.setFontScale(4);
        usernameLabel.setColor(1,1,1,1);
        usernameLabel.setAlignment(Align.center);
        root.add(usernameLabel).height(50).width(300).padTop(500).row();
        root.add(username).height(50).width(300).padTop(10).row();
        stage.setKeyboardFocus(username);
        username.selectAll();
        //password setup
        passwordLabel.setFontScale(4);
        passwordLabel.setColor(1,1,1,1);
        passwordLabel.setAlignment(Align.center);
        password.setPasswordCharacter('*');
        password.setPasswordMode(true);
        root.add(passwordLabel).height(50).width(300).padTop(20).row();
        root.add(password).height(50).width(300).padTop(10).row();
        //login and Register setup
        login.getLabel().setFontScale(2);
        login.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                System.out.println("Login pressed");
            }
        });
        root.add(login).width(300).height(50).padTop(20).row();
        register.getLabel().setFontScale(2);
        register.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                System.out.println("Register pressed");
            }
        });
        root.add(register).width(300).height(50).padTop(20).padBottom(450).row();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        elapsedTime += Gdx.graphics.getDeltaTime();
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
