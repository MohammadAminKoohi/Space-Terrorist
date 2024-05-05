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
    public float hitPoints = 100;
    public int clusterBombs = 10;
    public ArrayList<Bomb> bombs;
    //exhaust animation frames
//    TextureRegion

    private Player(){
        planeSprite.setPosition(600, 600);
        planeSprite.setSize(planeSprite.getWidth()*1.3f, planeSprite.getHeight()*1.3f);
        bombs = new ArrayList<Bomb>();
    }
    public static Player getPlayer(){
        return player;
    }
    public void addBomb(Bomb bomb){
        bombs.add(bomb);
    }
}
