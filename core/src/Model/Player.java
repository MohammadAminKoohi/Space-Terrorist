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
    public int clusterBombs = 10;
    public ArrayList<Bomb> bombs;
    public Collision collision;

    private Player(){
        planeSprite.setPosition(600, 600);
        planeSprite.setSize(planeSprite.getWidth()*1.3f, planeSprite.getHeight()*1.3f);
        bombs = new ArrayList<Bomb>();
        collision = new Collision(planeSprite.getX(), planeSprite.getY(), planeSprite.getWidth(), planeSprite.getHeight());
    }
    public static Player getPlayer(){
        return player;
    }
    public void addBomb(Bomb bomb){
        bombs.add(bomb);
    }
}
