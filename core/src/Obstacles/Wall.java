package Obstacles;

import Model.Collision;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Wall extends Obstacle{
    Texture texture = new Texture("Obstacles/wall.png");
    Sprite sprite;
    Random random = new Random();
    public Wall(float x,float y){
        super(x,y,7);
        sprite = new Sprite(texture);
        sprite.setPosition(x,y);
        sprite.setScale(1f);
        collision = new Collision(x,y,sprite.getWidth(),sprite.getHeight());
    }
    public void update(float delta){
        if(Hitpoints<=0){
            isDestroyed= true;

        }

    }
    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }
}
