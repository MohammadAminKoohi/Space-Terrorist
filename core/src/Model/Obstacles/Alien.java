package Model.Obstacles;

import Model.AnimationManager;
import Model.Collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Alien extends Obstacle {
    Random random = new Random();
    float timeState = 0;
    float deathTimeState=0;
    boolean isDead = false;
    Animation<Texture> idle = AnimationManager.animationManager.getAlienIdle();
    Animation<Texture> death = AnimationManager.animationManager.getAlienDead();
    public Alien(float x, float y) {
        super(x, y, 1);
        idle.setPlayMode(Animation.PlayMode.LOOP);
        sprite = new Sprite(idle.getKeyFrame(timeState));
        sprite.setPosition(x, y);
        sprite.setSize(25,47);
        collision = new Collision(x,y,sprite.getWidth(),sprite.getHeight());
        value=0;
    }

    public void update(float delta) {
        if (Hitpoints <= 0) {
            isDead= true;
        }
        if(isDead){
            if(death.isAnimationFinished(deathTimeState)){
                isDestroyed = true;
            }
            else{
                deathTimeState+= Gdx.graphics.getDeltaTime();
            }
        }
        if(!idle.isAnimationFinished(timeState)){
            timeState+= Gdx.graphics.getDeltaTime();}
        else{
            timeState =0;
        }
    }

    public void render(SpriteBatch batch) {
        if(!isDead){
            sprite.setRegion(idle.getKeyFrame(timeState));
        }
        else{
            sprite.setRegion(death.getKeyFrame(deathTimeState));
            sprite.setSize(47,25);
        }
        sprite.draw(batch);
    }
}
