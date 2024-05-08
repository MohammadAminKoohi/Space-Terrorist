package Model.Bomb;

import Model.AnimationManager;
import Model.Collision;
import Obstacles.Obstacle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AtomicBomb extends Bomb {
    float timeState = 0;
    public AtomicBomb(float x, float y, float velocityX) {
        super(x, y, velocityX * 100);
        velocityY = -10;
        texture = new Texture("spaceship/Missile_02.png");
        bombSprite = new Sprite(texture);
        bombSprite.setPosition(x, y);
        bombSprite.setSize(bombSprite.getWidth() * 0.06f, bombSprite.getHeight() * 0.06f);
        bombSprite.setOriginCenter();
        collision = new Collision(x, y, bombSprite.getWidth(), bombSprite.getHeight());
    }

    public void update(float delta) {
        if (this.canMove) {
            x += velocityX * delta;
            y += velocityY * delta;
            bombSprite.setPosition(x, y);
            airResistance();
            gravity();
            if (y < 20 || y > Gdx.graphics.getHeight() || x < 0 || x > Gdx.graphics.getWidth()) {
                canMove = false;
            }
            collision.move(x, y);
            for(Obstacle obstacle: Obstacle.obstacles){
                if(obstacle.collision.isColliding(collision)){
                    canMove = false;
                }
            }
        }
        else{
            killAll();
            Animation<Texture> nuclearExplosion = AnimationManager.animationManager.getNuclearExplosion();
            bombSprite.setRegion(nuclearExplosion.getKeyFrame(timeState));
            bombSprite.setPosition(x,y+300);
            bombSprite.setOriginCenter();
            bombSprite.setScale(225);
            bombSprite.setSize(bombSprite.getWidth() , bombSprite.getWidth() );
            if(nuclearExplosion.isAnimationFinished(timeState)){
                isDestroyed = true;
            }
            else{
                timeState += delta;
            }
        }
    }
    public void killAll(){
        for(Obstacle obstacle: Obstacle.obstacles){
            obstacle.Hitpoints = 0;
        }
    }
    public void airResistance() {

        if (velocityX < 3 && velocityX > -3) {
            velocityX = 0;
        }
        if(velocityX > 0) {
            velocityX -= 5;
        }
        if (velocityX < 0) {
            velocityX += 5;
        }
    }

    public void gravity() {
        velocityY -= 2f;
    }
}