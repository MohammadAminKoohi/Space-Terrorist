package Obstacles;

import Model.Bomb.UfoMissile;
import Model.Bomb.tankMissile;
import Model.Collision;
import Model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ufo extends Obstacle {
    Texture texture = new Texture("Obstacles/Ufo/Ufo.png");
    float shootDelay = 0;

    public Ufo(float x, float y) {
        super(x, y, 4);
        speed = 50;
        sprite = new Sprite(texture);
        sprite.setSize(75,50);
        collision = new Collision(x, y, sprite.getWidth(), sprite.getHeight());
        value = 5;
    }

    public void update(float delta) {
        x += speed * delta;
        if (Hitpoints <= 0 && !isDestroyed) {
            isDestroyed = true;
            Player.player.killCount += value;
        } else if (x > Gdx.graphics.getWidth() || x < 0) {
            isDestroyed = true;
        }
        sprite.setPosition(x, y);
        missileShoot();
        collision.move(x, y);
    }

    public void missileShoot() {
        Sprite planeSprite = Player.player.planeSprite;
        shootDelay += Gdx.graphics.getDeltaTime();
        if (shootDelay < 2) {
            return;
        } else {
            shootDelay = 0;
        }
        float distance = (float) Math.sqrt((planeSprite.getX() - x) * (planeSprite.getX() - x) + (planeSprite.getY() - y) * (planeSprite.getY() - y));
        if(distance < 500){
            Player.player.addBomb(new UfoMissile(x, y, 1));
        }
    }

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
