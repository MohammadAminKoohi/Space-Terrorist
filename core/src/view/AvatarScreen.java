package view;

import Model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AvatarScreen implements Screen {
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background = new Texture("background.png");
    Label title = new Label("Avatar Menu", skin);
    Texture currentAvatar = User.loggedInUser.getAvatar();
    ImageButton avatar1 = new ImageButton(skin);
    ImageButton avatar2 = new ImageButton(skin);
    ImageButton avatar3 = new ImageButton(skin);
    Label avatarPathLabel = new Label("Avatar Path", skin);
    TextField avatarPath = new TextField("Avatar Path", skin);
    TextButton changeAvatar = new TextButton("Change Avatar", skin);
    Table root = new Table();
    public AvatarScreen(SpaceTerrorists spaceTerrorists) {
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
        avatar1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("Avatar/1.png"))));
        avatar2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("Avatar/2.png"))));
        avatar3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("Avatar/3.png"))));
        avatarPathLabel.setFontScale(4);
        avatarPathLabel.setColor(1, 1, 1, 1);
        avatarPathLabel.setAlignment(Align.center);
        avatarPathLabel.setSize(4*avatarPathLabel.getWidth(),4*avatarPathLabel.getHeight());
        changeAvatar.getLabel().setFontScale(2);
        root.add(avatar1).height(150).width(150).padRight(50);
        root.add(avatar2).height(150).width(150).padRight(50);
        root.add(avatar3).height(150).width(150);
        root.row();
        root.add(avatarPathLabel).height(50).width(300).padTop(50).colspan(3).row();
        root.add(avatarPath).height(50).width(300).padTop(10).colspan(3).row();
        root.add(changeAvatar).height(50).width(300).padTop(10).colspan(3).row();
        avatar1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                User.loggedInUser.setAvatar("Avatar/1.png");
            }
        });
        avatar2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                User.loggedInUser.setAvatar("Avatar/2.png");
            }
        });
        avatar3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                User.loggedInUser.setAvatar("Avatar/3.png");
            }
        });
        changeAvatar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String avatarPathText = avatarPath.getText();
                FileHandle sourceFile = Gdx.files.absolute(avatarPathText);
                if (sourceFile.exists()) {
                    try {
                        String destinationPath = "assets/Avatar/" + sourceFile.name();
                        Files.move(Paths.get(sourceFile.file().getAbsolutePath()), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
                        User.loggedInUser.setAvatar(destinationPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("File does not exist: " + avatarPathText);
                }
            }
        });

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        currentAvatar = User.loggedInUser.getAvatar();
        batch.draw(currentAvatar,10, Gdx.graphics.getHeight()-160, 150, 150);
        batch.end();
        stage.act();
        stage.draw();
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            spaceTerrorists.setScreen(new ProfileScreen(spaceTerrorists));
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
