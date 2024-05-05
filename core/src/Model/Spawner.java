package Model;

import Obstacles.Alien;
import Obstacles.Building;
import Obstacles.Obstacle;
import Obstacles.Wall;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Spawner {
    public static Spawner spawner = new Spawner();
    Random random = new Random();
    boolean buildingSpawned = false;
    boolean alienSpawned = false;
    boolean wallSpawned = false;
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
        Obstacle.obstacles.add(new Building(x, 250));
        while(true){
            X = random.nextInt(Gdx.graphics.getWidth() - 200) + 50;
            if(X > 0 && X < x - 200){
                break;
            }
            if(X < Gdx.graphics.getWidth()-200 && X > x + 200){
                break;
            }
        }
        Obstacle.obstacles.add(new Building(X, 250));
    }
    public void truckSpawner(){
        if(random.nextInt(1001) % 450 == 0){
            Obstacle.obstacles.add(new Obstacles.Truck(0, random.nextInt(150)+50));
        }
    }
    public void tankSpawner(){
        if(random.nextInt(901) % 450 == 0){
            Obstacle.obstacles.add(new Obstacles.Tank(0, random.nextInt(150)+50));
        }
    }
}
