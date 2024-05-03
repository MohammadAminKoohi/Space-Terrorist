package Model.Bomb;

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
    public Bomb(float x, float y, float velocityX){
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = 0;
    }
    public abstract void update(float delta);
    public abstract boolean isDestroyed();
}
