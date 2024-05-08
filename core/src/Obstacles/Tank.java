package Obstacles;

import Model.Bomb.tankMissile;
import Model.Collision;
import Model.Player;
import Model.WaveManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Tank extends Obstacle{
    Texture texture = new Texture("Obstacles/tank/tank.png");
    Sprite sprite;
    float shootDelay = 0;
    public Tank(float x,float y){
        super(x,y,8);
        speed= 30;
        sprite = new Sprite(texture);
        sprite.setScale(2.2f);
        collision = new Collision(x,y,sprite.getWidth(),sprite.getHeight());
        value=4;
    }
    public void update(float delta){
        x+=speed*delta;
        if(Hitpoints<=0 && !isDestroyed){
            isDestroyed = true;
            Player.player.killCount+=value;
        }
        else if(x> Gdx.graphics.getWidth() || x<0){
            isDestroyed = true;
        }
        sprite.setPosition(x,y);
        if(WaveManager.waveManager.wave>= 2){
            missileShoot();
        }
        collision.move(x,y);
    }
    public void missileShoot(){
        Sprite planeSprite = Player.player.planeSprite;
        shootDelay+=Gdx.graphics.getDeltaTime();
        if(shootDelay<1){
            return;
        }
        else{
            shootDelay = 0;
        }
        float distance  = (float) Math.sqrt((planeSprite.getX()-x)*(planeSprite.getX()-x) + (planeSprite.getY()-y)*(planeSprite.getY()-y));
        if(distance<500){
            Player.player.addBomb(new tankMissile(x,y,1));
        }
    }
    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }
}
