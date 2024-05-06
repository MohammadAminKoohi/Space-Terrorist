package Model.Bomb;

import Model.Collision;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.awt.*;

public abstract class Bomb {
    Texture texture;
    public Sprite bombSprite;
    public float x;
    public float y;
    public float velocityX;
    public float velocityY;
    public float damage;
    public boolean isDestroyed = false;
    public boolean canMove = true;
    public Collision collision;
    public Bomb(float x, float y, float velocityX){
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = -400;
    }
    public abstract void update(float delta);
    public boolean isDestroyed(){
        return isDestroyed;
    }
}
