package Obstacles;

import Model.Collision;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class Building extends Obstacle{
    Texture[] textures = new Texture[2];
    Sprite sprite;
    Random random = new Random();
    public Building(float x,float y){
        super(x,y,20);
        textures[0]= new Texture("Obstacles/building1.png");
        textures[1]= new Texture("Obstacles/building2.png");
        sprite = new Sprite(textures[random.nextInt(2)]);
        sprite.setPosition(x,y);
        sprite.setSize(sprite.getWidth()*2.5f,sprite.getHeight()*2.5f);
        collision = new Collision(x,y,sprite.getWidth(),sprite.getHeight());
        collision.move(x,y);
    }
    public void update(float delta){
        if(Hitpoints<=0){
            isDestroyed= true;
        }
        //place for collectibles
    }
    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }
}
