package Model.Bomb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class NormalBomb extends Bomb {
    public NormalBomb(float x, float y, float velocityX) {
        super(x, y, velocityX*450);
        texture = new Texture("spaceship/Missile_01.png");
        bombSprite = new Sprite(texture);
        bombSprite.setPosition(x,y);
        bombSprite.setSize(bombSprite.getWidth() * 0.06f, bombSprite.getHeight() * 0.06f);
    }

    public void update(float delta) {
        if (this.canMove) {
            x += velocityX * delta;
            y += velocityY * delta;
            bombSprite.setPosition(x, y);
            airResistance();
            gravity();
            if (y < 0 || y > Gdx.graphics.getHeight() || x < 0 || x > Gdx.graphics.getWidth()) {
                isDestroyed = true;
            }
        }
    }

    public boolean isDestroyed() {
        if (isDestroyed) {
            return true;
        }
        return false;
    }

    public void airResistance() {
        if (velocityX > 0) {
            velocityX -= 1;
        }
        if (velocityX < 0) {
            velocityX += 1;
        }
    }

    public void gravity() {
        velocityY -= 5f;
    }
}