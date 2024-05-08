package Model.Bomb;

import Model.AnimationManager;
import Model.Collision;
import Model.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class UfoMissile extends Bomb {
    float timeState = 0;
    boolean explosionStarted = false;
    float timer = 5;

    public UfoMissile(float x, float y, float velocityX) {
        super(x, y, velocityX * 550);
        Animation<Texture> ufoMissile = AnimationManager.animationManager.getUfoMissile();
        texture = ufoMissile.getKeyFrame(0);
        bombSprite = new Sprite(texture);
        bombSprite.setScale(10f);
        bombSprite.setPosition(x, y);
        bombSprite.setSize(bombSprite.getWidth() * 0.06f, bombSprite.getHeight() * 0.06f);
        bombSprite.setOriginCenter();
        damage = 1;
        collision = new Collision(x, y, bombSprite.getWidth(), bombSprite.getHeight());
    }

    public void autoAim() {
        float xDiff = Player.player.planeSprite.getX() + Player.player.planeSprite.getWidth()/2 - x;
        float yDiff = Player.player.planeSprite.getY() + Player.player.planeSprite.getHeight()/2 - y;
        float distance = (float) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        velocityX = xDiff / distance * 300;
        velocityY = yDiff / distance * 300;
    }

    public void update(float delta) {
        if(this.canMove) {
            autoAim();
            x += velocityX * delta;
            y += velocityY * delta;
            Animation<Texture> ufoMissile = AnimationManager.animationManager.getUfoMissile();
            if(ufoMissile.isAnimationFinished(timeState)){
                timeState = 0;
            }
            else{
                timeState+=delta;
            }
            bombSprite.setRegion(ufoMissile.getKeyFrame(timeState));
            bombSprite.setScale(10f);
            bombSprite.setPosition(x, y);
            bombSprite.setRotation((float) Math.toDegrees(Math.atan2(velocityY, velocityX))+180);
            if (y < 20 || y > 1080 || x < 0 || x > 1920) {
                canMove = false;
            }
            collision.move(x, y);
            if(Player.player.collision.isColliding(collision)){
                Player.player.Hitpoint -= 2;
                canMove = false;
            }
            timer-=delta;
            if(timer<=0){
                canMove = false;
            }
        } else {
            isDestroyed = true;
        }
    }

}
