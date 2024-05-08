package Model.Bomb;

import Model.AnimationManager;
import Model.Collision;
import Model.Player;
import Obstacles.Obstacle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class NormalBomb extends Bomb {

    float timeState = 0;
    public NormalBomb(float x, float y, float velocityX) {
        super(x, y, velocityX*550);
        texture = new Texture("spaceship/Missile_01.png");
        bombSprite = new Sprite(texture);
        bombSprite.setPosition(x,y);
        bombSprite.setSize(bombSprite.getWidth() * 0.06f, bombSprite.getHeight() * 0.06f);
        bombSprite.setOriginCenter();
        damage = 1;
        collision = new Collision(x, y, bombSprite.getWidth(), bombSprite.getHeight());
    }

    public void update(float delta) {
        if (this.canMove) {
            x += velocityX * delta;
            y += velocityY * delta;
            bombSprite.setPosition(x, y);
            bombSprite.setRotation((float) Math.toDegrees(Math.atan2(velocityY, velocityX)));
            airResistance();
            gravity();
            if (y < 20 || y > Gdx.graphics.getHeight() || x < 0 || x > Gdx.graphics.getWidth()) {
                canMove = false;
            }
            collision.move(x, y);
            for(Obstacle obstacle: Obstacle.obstacles){
                if(obstacle.collision.isColliding(collision)){
                    Player.player.successfullShotCount++;
                    obstacle.Hitpoints -= 1;
                    canMove = false;
                }
            }
        }
        else {
            Animation<Texture> explosion= AnimationManager.animationManager.getExplosion2();
            bombSprite.setRegion(explosion.getKeyFrame(timeState));
            bombSprite.setOriginCenter();
            bombSprite.setScale(4f);
            bombSprite.setSize(bombSprite.getWidth() , bombSprite.getWidth() );
            if(!explosion.isAnimationFinished(timeState)){
                timeState+= delta;
            }
            else{
                isDestroyed = true;
            }
        }
    }

    public void airResistance() {
        if (velocityX > 0) {
            velocityX -= 0.05f;
        }
        if (velocityX < 0) {
            velocityX += -0.05f;
        }
    }

    public void gravity() {
        velocityY -= 5f;
    }
}