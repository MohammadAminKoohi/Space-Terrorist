package Model.Bomb;

import Model.AnimationManager;
import Model.Collision;
import Model.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class tankMissile extends Bomb {
    float timeState = 0;
    boolean explosionStarted = false;

    public tankMissile(float x, float y, float velocityX) {
        super(x, y, velocityX * 550);
        texture = new Texture("Obstacles/tank/tank_missile.png");
        bombSprite = new Sprite(texture);
        bombSprite.setPosition(x, y);
        bombSprite.setSize(bombSprite.getWidth() * 0.06f, bombSprite.getHeight() * 0.06f);
        bombSprite.setOriginCenter();
        damage = 1;
        collision = new Collision(x, y, bombSprite.getWidth(), bombSprite.getHeight());
    }

    public void autoAim() {
        float xDiff = Player.player.planeSprite.getX() - x;
        float yDiff = Player.player.planeSprite.getY() - y;
        float distance = (float) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        velocityX = xDiff / distance * 500;
        velocityY = yDiff / distance * 500;
    }

    public void update(float delta) {
        if(this.canMove) {
            autoAim();
            x += velocityX * delta;
            y += velocityY * delta;
            bombSprite.setPosition(x, y);
            bombSprite.setRotation((float) Math.toDegrees(Math.atan2(velocityY, velocityX)));
            if (y < 20 || y > 1080 || x < 0 || x > 1920) {
                canMove = false;
            }
            collision.move(x, y);
            if(Player.player.collision.isColliding(collision)){
                Player.player.Hitpoint -= 1;
                canMove = false;
            }
        } else {
            Animation<Texture> explosion = AnimationManager.animationManager.getTankMissileExplosion();
            bombSprite.setRegion(explosion.getKeyFrame(timeState));
            bombSprite.setOriginCenter();
            bombSprite.setScale(4f);
            bombSprite.setSize(bombSprite.getWidth(), bombSprite.getWidth());
            if (!explosion.isAnimationFinished(timeState)) {
                timeState += 0.1;
            } else {
                timeState = 0;
                isDestroyed = true;
            }
        }
    }

}
