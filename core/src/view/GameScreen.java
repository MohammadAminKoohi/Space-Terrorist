package view;

import Model.Collectibles.Collectible;
import Controller.GameController;
import Model.*;
import Model.Bomb.Bomb;
import Model.Obstacles.Obstacle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceTerrorists;

import java.util.ArrayList;

public class GameScreen implements Screen {
    WaveManager waveManager;
    SpaceTerrorists spaceTerrorists;
    SpriteBatch batch;
    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    Stage stage = new Stage(new ScreenViewport());
    Texture background;
    Texture freezeEffect;
    Spawner spawner = Spawner.spawner;
    Label killCount = new Label("Kill Count: " + Player.player.killCount, skin);
    Label health = new Label("Health: " + Player.player.Hitpoint, skin);
    Label atomicBombs = new Label("Atomic Bombs: " + Player.player.atomicBombs, skin);
    Label clusterBombs = new Label("Cluster Bombs: " + Player.player.clusterBombs, skin);
    Label wave = new Label("Wave: ", skin);
    Label accuracy = new Label("Accuracy: ", skin);
    Window window = new Window("Paused", skin);
    Label guide = new Label("use WASD or Arrow keys to move, Space to shoot, R for atomic bomb, C for cluster bomb", skin);
    TextButton resume = new TextButton("Resume", skin);
    TextButton saveAndExit = new TextButton("Save and Exit", skin);
    TextButton exit = new TextButton("Exit", skin);
    Button.ButtonStyle buttonStyle = skin.get("music", Button.ButtonStyle.class);
    Button musicButton = new Button(buttonStyle);
    TextButton music1Button = new TextButton("1", skin);
    TextButton music2Button = new TextButton("2", skin);
    TextButton music3Button = new TextButton("3", skin);
    freezBar freezBar = Player.player.freezBar;

    public GameScreen(SpaceTerrorists spaceTerrorists) {
        this.spaceTerrorists = spaceTerrorists;
        background= new Texture("background.png");
        freezeEffect= new Texture("freezScreen.png");
        batch = spaceTerrorists.batch;
        if (WaveManager.waveManager == null) {
            waveManager = new WaveManager();
        } else {
            waveManager = WaveManager.waveManager;
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        //atomic and cluster bombs
        atomicBombs.setPosition(0, Gdx.graphics.getHeight() - 20);
        clusterBombs.setPosition(0, Gdx.graphics.getHeight() - 50);
        atomicBombs.setFontScale(2);
        clusterBombs.setFontScale(2);
        atomicBombs.setColor(1, 1, 1, 1);
        clusterBombs.setColor(1, 1, 1, 1);
        stage.addActor(atomicBombs);
        stage.addActor(clusterBombs);
        //health and killcount
        health.setPosition(300, Gdx.graphics.getHeight() - 20);
        killCount.setPosition(300, Gdx.graphics.getHeight() - 50);
        health.setFontScale(2);
        killCount.setFontScale(2);
        health.setColor(1, 1, 1, 1);
        killCount.setColor(1, 1, 1, 1);
        stage.addActor(health);
        stage.addActor(killCount);
        //wave
        wave.setPosition(600, Gdx.graphics.getHeight() - 20);
        wave.setFontScale(2);
        wave.setColor(1, 1, 1, 1);
        stage.addActor(wave);
        //Accuracy
        accuracy.setPosition(600, Gdx.graphics.getHeight() - 50);
        accuracy.setFontScale(2);
        accuracy.setColor(1, 1, 1, 1);
        stage.addActor(accuracy);

        pauseWindowSetup();
    }

    public void pauseWindowSetup() {
        pauseButtonSetup();
        Table root = new Table();
        root.setFillParent(true);
        window.setColor(1f, 1f, 1f, 0.75f);
        window.setSize(750, 750);
        window.setPosition(Gdx.graphics.getWidth() / 2 - window.getWidth() / 2, Gdx.graphics.getHeight() / 2 - window.getHeight() / 2);
        window.add(root);
        window.row().pad(150, 0, 10, 0);
        guide.setFontScale(1);
        guide.setColor(1, 1, 1, 1);
        window.add(guide).height(50).width(750).fillX();
        guide.setAlignment(1);
        window.row().pad(10, 0, 10, 0);
        window.add(resume).height(50).width(300).fillX();
        window.row().pad(10, 0, 10, 0);
        if (User.loggedInUser != null) {
            window.add(saveAndExit).height(50).width(300).fillX();
            window.row().pad(10, 0, 10, 0);
        }
        window.add(exit).height(50).width(300).fillX();
        window.row().pad(10, 0, 10, 0);

        Table musicTable = new Table();
        musicTable.add(music1Button).height(50).width(80);
        musicTable.add(music2Button).height(50).width(80);
        musicTable.add(music3Button).height(50).width(80);

        window.add(musicTable);
        window.row().pad(10, 0, 10, 0);
        window.add(musicButton);
        stage.addActor(window);
    }

    public void pauseButtonSetup() {
        resume.getLabel().setFontScale(2);
        resume.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                spaceTerrorists.isPaused = false;
                window.setVisible(false);
            }
        });
        saveAndExit.getLabel().setFontScale(2);
        saveAndExit.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                spaceTerrorists.isPaused = false;
                spaceTerrorists.setScreen(new MainScreen(spaceTerrorists));
            }
        });
        exit.getLabel().setFontScale(2);
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                spaceTerrorists.getScreen().dispose();
                spaceTerrorists.isPaused = false;
                spaceTerrorists.setScreen(new MainScreen(spaceTerrorists));
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
        //load musics 1.mp3, 2.mp3, 3.mp3 based on music number button
        music1Button.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                SpaceTerrorists.music.stop();
                SpaceTerrorists.music = Gdx.audio.newMusic(Gdx.files.internal("Songs/1.mp3"));
                SpaceTerrorists.music.setLooping(true);
                SpaceTerrorists.music.play();
            }
        });
        music2Button.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                SpaceTerrorists.music.stop();
                SpaceTerrorists.music = Gdx.audio.newMusic(Gdx.files.internal("Songs/2.mp3"));
                SpaceTerrorists.music.setLooping(true);
                SpaceTerrorists.music.play();
            }
        });
        music3Button.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                SpaceTerrorists.music.stop();
                SpaceTerrorists.music = Gdx.audio.newMusic(Gdx.files.internal("Songs/3.mp3"));
                SpaceTerrorists.music.setLooping(true);
                SpaceTerrorists.music.play();
            }
        });

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        waveManager.waveChanger(spaceTerrorists, false);
        batch.begin();
        objectRender();
        collectibleRender();
        fireRender();
        freezBar.render(batch);
        batch.end();
        GameController.update(spaceTerrorists);
        freezBar.update(Gdx.graphics.getDeltaTime());
        if (!spaceTerrorists.isPaused) {
            window.setVisible(false);
            objectUpdate();
            collectibleUpdate();
            fireUpdate();
            gameUiUpdate();
            removeDestroyed();
        } else {
            stage.addActor(window);
            window.setVisible(true);
        }
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 144f));
        stage.draw();
    }

    public void gameUiUpdate() {
        killCount.setText("Kill Count: " + Player.player.killCount);
        health.setText("Health: " + Player.player.Hitpoint);
        atomicBombs.setText("Atomic Bombs: " + Player.player.atomicBombs);
        clusterBombs.setText("Cluster Bombs: " + Player.player.clusterBombs);
        wave.setText("Wave: " + WaveManager.waveManager.wave);
        accuracy.setText("Accuracy: " + Player.player.getAccuracy());
    }

    public void fireRender() {
        for (Fire fire : Fire.fires) {
            fire.fireSprite.draw(batch);
        }
    }

    public void fireUpdate() {
        for (Fire fire : Fire.fires) {
            fire.update(Gdx.graphics.getDeltaTime());
        }
    }

    public void objectRender() {
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        if(freezBar.isFreez){
            batch.setColor(1,1,1,0.2f);
            batch.draw(freezeEffect, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.setColor(1,1,1,1);
        }
        Player.player.planeSprite.draw(batch);
        for (Bomb bomb : Player.player.bombs) {
            bomb.bombSprite.draw(batch);
        }
        spawner.spawn(batch);

    }

    public void objectUpdate() {
        if (!spaceTerrorists.isPaused) {
            for (Bomb bomb : Player.player.bombs) {
                bomb.update(Gdx.graphics.getDeltaTime());
            }
            if (!freezBar.isFreez) {
                spawner.update(Gdx.graphics.getDeltaTime());
            }
        }
    }

    public void collectibleRender() {
        for (Collectible collectible : Collectible.collectibles) {
            collectible.sprite.draw(batch);
        }
    }

    public void collectibleUpdate() {
        System.out.println(Collectible.collectibles.size());
        for (Collectible collectible : Collectible.collectibles) {
            collectible.update(Gdx.graphics.getDeltaTime());
        }
    }

    public void removeDestroyed() {
        ArrayList<Bomb> removeList = new ArrayList<Bomb>();
        for (Bomb bomb : Player.player.bombs) {
            if (bomb.isDestroyed) {
                removeList.add(bomb);
            }
        }
        for (Bomb bomb : removeList) {
            Player.player.bombs.remove(bomb);
        }
        ArrayList<Obstacle> removeList2 = new ArrayList<Obstacle>();
        for (Obstacle obstacle : Obstacle.obstacles) {
            if (obstacle.isDestroyed) {
                Fire.fires.remove(obstacle.fire);
                removeList2.add(obstacle);
            }
        }
        for (Obstacle obstacle : removeList2) {
            Obstacle.obstacles.remove(obstacle);
        }
        ArrayList<Collectible> removeList3 = new ArrayList<Collectible>();
        for (Collectible collectible : Collectible.collectibles) {
            if (collectible.isDestroyed) {
                removeList3.add(collectible);
            }
        }
        for (Collectible collectible : removeList3) {
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
        this.stage.dispose();
        Obstacle.obstacles = new ArrayList<Obstacle>();
        Collectible.collectibles = new ArrayList<Collectible>();
        Player.player.bombs = new ArrayList<Bomb>();
        Player.player.fire = null;
        Spawner.spawner = new Spawner();
        Fire.fires = new ArrayList<Fire>();
    }
}
