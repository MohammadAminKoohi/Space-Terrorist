package Model;

import Obstacles.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Spawner {
    public static Spawner spawner = new Spawner();
    Random random = new Random();
    Texture alert = new Texture("Obstacles/Ufo/alert.png");
    Sprite alertSprite = new Sprite(alert);
    int y = 0;
    boolean buildingSpawned = false;
    boolean alienSpawned = false;
    boolean wallSpawned = false;
    public float timer= 2;
    public void spawn(SpriteBatch batch){
        render(batch);
        if(!buildingSpawned){
            buildingSpawner();
        }
        if(!alienSpawned){
            alienSpawner();
        }
        if(!wallSpawned){
            wallSpawner();
        }
        truckSpawner();
        tankSpawner();
        if(WaveManager.waveManager.wave>=3){
            ufoSpawner(batch);
        }
    }
    public void render(SpriteBatch batch){
        for(Obstacle obstacle: Obstacle.obstacles){
            obstacle.render(batch);
        }
    }
    public void update(float delta){
        for(Obstacle obstacle: Obstacle.obstacles){
            obstacle.update(delta);
        }
    }
    public void wallSpawner(){
        wallSpawned= true;
        for(int i = 0; i < 6; i++){
            Obstacle.obstacles.add(new Wall(random.nextInt(Gdx.graphics.getWidth()), random.nextInt(200)));
        }
    }
    public void alienSpawner(){
        alienSpawned= true;
        for(int i = 0; i < 15; i++){
            Obstacle.obstacles.add(new Alien(random.nextInt(Gdx.graphics.getWidth()), random.nextInt(200)));
        }
    }
    public void buildingSpawner() {
        buildingSpawned = true;
        int x = random.nextInt(Gdx.graphics.getWidth() - 200) + 50;
        int X;
        Obstacle.obstacles.add(new Building(x, 200));
        while(true){
            X = random.nextInt(Gdx.graphics.getWidth() - 200) + 50;
            if(X > 0 && X < x - 200){
                break;
            }
            if(X < Gdx.graphics.getWidth()-200 && X > x + 200){
                break;
            }
        }
        Obstacle.obstacles.add(new Building(X, 200));
    }
    public void truckSpawner(){
        if(random.nextInt(1001) % 700 == 0){
            Obstacle.obstacles.add(new Obstacles.Truck(0, random.nextInt(150)+50));
        }
    }
    public void tankSpawner(){
        if(random.nextInt(901) % 700 == 0){
            Obstacle.obstacles.add(new Obstacles.Tank(0, random.nextInt(150)+50));
        }
    }
    public void ufoSpawner(SpriteBatch batch){
        if(y==0){
            y = random.nextInt(1300)+200;
        }
        if(timer<=0){
            Obstacle.obstacles.add(new Ufo(0, y));
            timer = 2;
            y = 0;
        }
        else if(timer < 1){
            alertSprite.setPosition(10, y);
            alertSprite.setSize(100, 100);
            alertSprite.setColor(1, 1, 1, 0.5f);
            alertSprite.draw(batch);
            timer-= Gdx.graphics.getDeltaTime();
        }
        else{
            timer-= Gdx.graphics.getDeltaTime();
        }
    }
}
