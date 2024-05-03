package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import view.LoginScreen;

public class SpaceTerrorists extends Game {
	public SpriteBatch batch;

	Texture img;
	Sprite sprite;
	public static Music music;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new LoginScreen(this));
		music = Gdx.audio.newMusic(Gdx.files.internal("Songs/1.mp3"));
		music.play();
		music.setLooping(true);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
