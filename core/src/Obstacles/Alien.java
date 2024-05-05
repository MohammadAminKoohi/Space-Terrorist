package Obstacles;

import Model.AnimationManager;
import Model.Collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class Alien extends Obstacle {
    Sprite sprite;
    Random random = new Random();
    float timeState = 0;
    float deathTimeState=0;
    boolean isDead = false;
    Animation<Texture> idle = AnimationManager.animationManager.getAlienIdle();
    public Alien(float x, float y) {
        super(x, y, 1);
        idle.setPlayMode(Animation.PlayMode.LOOP);
        sprite = new Sprite(idle.getKeyFrame(timeState));
        sprite.setPosition(x, y);
        sprite.setSize(25,47);
        collision = new Collision(x,y,sprite.getWidth(),sprite.getHeight());
    }

    public void update(float delta) {
        if (Hitpoints <= 0) {
            isDead= true;
        }
        if(isDead){
            Animation<Texture> death = AnimationManager.animationManager.getAlienDead();
            sprite.setRegion(death.getKeyFrame(deathTimeState));
            if(!death.isAnimationFinished(deathTimeState)){
                deathTimeState+= Gdx.graphics.getDeltaTime();
            }
            else{
                deathTimeState =0;
                isDestroyed = true;
            }
        }
        else if(!idle.isAnimationFinished(timeState)){
            timeState+= Gdx.graphics.getDeltaTime();}
        else{
            timeState =0;
        }
    }

    public void render(SpriteBatch batch) {
        sprite.setRegion(idle.getKeyFrame(timeState));
        sprite.draw(batch);
    }
}
