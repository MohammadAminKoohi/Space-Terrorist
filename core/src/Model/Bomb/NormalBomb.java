package Model.Bomb;

import Model.AnimationManager;
import Model.Collision;
import Obstacles.Obstacle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class NormalBomb extends Bomb {

    float timeState = 0;
    boolean explosionStarted = false;
    public NormalBomb(float x, float y, float velocityX) {
        super(x, y, velocityX*450);
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
            if (y < 0 || y > Gdx.graphics.getHeight() || x < 0 || x > Gdx.graphics.getWidth()) {
                isDestroyed = true;
            }
            collision.move(x, y);
            for(Obstacle obstacle: Obstacle.obstacles){
                if(obstacle.collision.isColliding(collision)){
                    obstacle.Hitpoints -= 1;
                    canMove = false;
                }
            }
        }
        else {
            Animation<Texture> explosion= AnimationManager.animationManager.getBombExplosion();
            bombSprite.setRegion(explosion.getKeyFrame(timeState));
            bombSprite.setScale(5f);
            bombSprite.setRotation(bombSprite.getRotation()+90);
            if(!explosion.isAnimationFinished(timeState)){
                timeState+= Gdx.graphics.getDeltaTime();
            }
            else{
                timeState =0;
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
            velocityX -= 0.2f;
        }
        if (velocityX < 0) {
            velocityX += -0.2f;
        }
    }

    public void gravity() {
        velocityY -= 10f;
    }
}