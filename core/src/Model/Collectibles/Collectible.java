package Model.Collectibles;

import Model.Collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public abstract class Collectible {
    public static ArrayList<Collectible> collectibles = new ArrayList<Collectible>();
    Texture texture;
    public Sprite sprite;
    final float startingX;
    float x;
    float y;
    float speedX= 100f;
    final float speedY= 150f;
    public boolean isDestroyed = false;
    public Collision collision;
    public Collectible(float x, float y,Texture texture){
        this.startingX = x;
        this.x = x;
        this.y = y;
        this.texture = texture;
        sprite = new Sprite(texture);
        sprite.setPosition(x,y);
        sprite.setSize(50,50);
        sprite.setAlpha(0.5f);
        collision = new Collision(x,y,sprite.getWidth(),sprite.getHeight());
    }
    public void update(float delta){
        x+=speedX*delta;
        y+=speedY*delta;
        sprite.setPosition(x,y);
        collision.move(x,y);
        if(y> Gdx.graphics.getHeight()){
            isDestroyed = true;
        }
        if(x > startingX+20 || x < startingX-20){
            speedX*=-1;
        }
    }
    public abstract void collect();
}
