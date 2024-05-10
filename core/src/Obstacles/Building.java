package Obstacles;

import Collectibles.AtomicBombCollectible;
import Model.Bomb.AtomicBomb;
import Model.Collision;
import Model.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class Building extends Obstacle{
    Texture[] textures = new Texture[2];
    Random random = new Random();
    public Building(float x,float y){
        super(x,y,20);
        textures[0]= new Texture("Obstacles/building1.png");
        textures[1]= new Texture("Obstacles/building2.png");
        sprite = new Sprite(textures[random.nextInt(2)]);
        sprite.setPosition(x,y);
        sprite.setSize(sprite.getWidth()*2.5f,sprite.getHeight()*2.5f);
        collision = new Collision(x,y,sprite.getWidth(),sprite.getHeight());
        collision.move(x,y);
        value= 10;
    }
    public void update(float delta){
        if(Hitpoints<=0 && !isDestroyed){
            isDestroyed= true;
            AtomicBombCollectible atomicBombCollectible = new AtomicBombCollectible(x,y);
            Player.player.killCount+=value;
        }
    }
    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }
}
