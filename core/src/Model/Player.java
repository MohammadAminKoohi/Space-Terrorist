package Model;

import Model.Bomb.Bomb;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Player {
    public static Player player = new Player();
    public Texture plane = new Texture("spaceship/Ship.png");
    public Texture planeFlipped = new Texture("spaceship/shipFlipped.png");
    public Sprite planeSprite = new Sprite(plane);
    public float speedX = 0;
    public float speedY = 0;
    public float speed = 300;
    public float Hitpoint = 25;
    public int atomicBombs = 0;
    public int clusterBombs = 3;
    public int killCount = 0;
    public int shotCount = 0;
    public int successfullShotCount = 0;
    public ArrayList<Bomb> bombs;
    public Collision collision;
    public Fire fire;
    public freezBar freezBar = new freezBar();
    private Player(){
        planeSprite.setPosition(600, 600);
        planeSprite.setSize(planeSprite.getWidth()*1.3f, planeSprite.getHeight()*1.3f);
        bombs = new ArrayList<Bomb>();
        collision = new Collision(planeSprite.getX(), planeSprite.getY(), planeSprite.getWidth(), planeSprite.getHeight());
    }
    public static Player getPlayer(){
        return player;
    }
    public void newGame(){
        player.Hitpoint = 25;
        player.atomicBombs = 0;
        player.clusterBombs = 3;
        player.killCount = 0;
        player.shotCount = 0;
        player.successfullShotCount = 0;
        player.speedX=0;
        player.speedY=0;
        player.planeSprite.setPosition(600, 600);
        bombs = new ArrayList<Bomb>();
        collision = new Collision(planeSprite.getX(), planeSprite.getY(), planeSprite.getWidth(), planeSprite.getHeight());
        player.fire = null;
    }
    public void addBomb(Bomb bomb){
        bombs.add(bomb);
    }
    public float getAccuracy(){
return (float) Math.round(((float)successfullShotCount/shotCount)*100*100)/100;
    }
}
