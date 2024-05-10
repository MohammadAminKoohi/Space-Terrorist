package Obstacles;

import Collectibles.ClusterBombCollectible;
import Model.Collision;
import Model.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Wall extends Obstacle{
    Texture texture = new Texture("Obstacles/wall.png");
    Random random = new Random();
    public Wall(float x,float y){
        super(x,y,10);
        sprite = new Sprite(texture);
        sprite.setPosition(x,y);
        sprite.setScale(1f);
        collision = new Collision(x,y,sprite.getWidth(),sprite.getHeight());
        value=3;
    }
    public void update(float delta){
        if(Hitpoints<=0 && !isDestroyed){
            isDestroyed= true;
            ClusterBombCollectible clusterBombCollectible = new ClusterBombCollectible(x,y);
            Player.player.killCount+=value;
        }
    }
    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }
}
