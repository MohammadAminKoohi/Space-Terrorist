package view;

import Model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

public class ProfileScreen implements Screen {
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Label title = new Label("Profile Menu", skin);
    Label newUserName = new Label("New Username", skin);
    TextField newUsername = new TextField("New Username", skin);
    TextButton changeUsername = new TextButton("Change Username", skin);
    Label errorLabel1 = new Label("", skin);
    Label newPasswordLable = new Label("New Password", skin);
    TextField newPassword = new TextField("New Password", skin);
    TextButton changePassword = new TextButton("Change Password", skin);
    Label errorLabel2 = new Label("", skin);
    TextButton avatarMenu = new TextButton("Avatar Menu", skin);
    TextButton deleteAccount = new TextButton("Delete Account", skin);
    TextButton logout = new TextButton("Logout", skin);
    Table root = new Table();
    public ProfileScreen(SpaceTerrorists spaceTerrorists) {
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
        root.setFillParent(true);
        root.add(newUserName).height(50).width(300).padTop(150).row();
        root.add(newUsername).height(50).width(300).padTop(10).row();
        root.add(changeUsername).height(50).width(300).padTop(10).row();
        root.add(errorLabel1).height(30).width(300).padTop(10).row();
        root.add(newPasswordLable).height(50).width(300).padTop(5).row();
        root.add(newPassword).height(50).width(300).padTop(10).row();
        root.add(changePassword).height(50).width(300).padTop(10).row();
        root.add(errorLabel2).height(30).width(300).padTop(10).row();
        root.add(avatarMenu).height(50).width(300).padTop(5).row();
        root.add(deleteAccount).height(50).width(300).padTop(10).row();
        root.add(logout).height(50).width(300).padTop(10);
        newPasswordLable.setFontScale(4);
        newPasswordLable.setColor(1, 1, 1, 1);
        newUserName.setFontScale(4);
        newUserName.setColor(1, 1, 1, 1);
        newUserName.setAlignment(1);
        newPasswordLable.setAlignment(1);
        changeUsername.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (User.getUserByUsername(newUsername.getText()) == null) {
                    User.loggedInUser.setUsername(newUsername.getText());
                    User.saveUsers();
                    errorLabel1.setText("Username changed successfully!");
                } else {
                    errorLabel1.setText("Username already exists!");
                }
            }
        });
        changePassword.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                User.loggedInUser.setPassword(newPassword.getText());
                User.saveUsers();
                errorLabel2.setText("Password changed successfully!");
            }
        });
        avatarMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new AvatarScreen(spaceTerrorists));
            }
        });
        deleteAccount.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                User.users.remove(User.loggedInUser);
                User.loggedInUser= null;
                User.saveUsers();
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.setScreen(new LoginScreen(spaceTerrorists));
            }
        });
        logout.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                spaceTerrorists.getScreen().dispose();
                User.loggedInUser = null;
                User.saveUsers();
                spaceTerrorists.setScreen(new LoginScreen(spaceTerrorists));
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
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
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
