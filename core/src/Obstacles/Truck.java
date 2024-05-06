package Obstacles;

import Model.Collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Truck extends Obstacle{
    Texture texture = new Texture("Obstacles/truck.png");
    Sprite sprite;
    Random random = new Random();
    public Truck(float x,float y){
        super(x,y,5);
        speed= 40;
        sprite = new Sprite(texture);
        sprite.setScale(1.5f);
        collision = new Collision(x,y,sprite.getWidth(),sprite.getHeight());
    }
    public void update(float delta){
        x+=speed*delta;
        if(x> Gdx.graphics.getWidth() || x<0 || Hitpoints<=0){
            isDestroyed = true;
        }
        sprite.setPosition(x,y);
        collision.move(x,y);
    }
    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }
}
