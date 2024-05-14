package Model.Obstacles;

import Model.Collision;
import Model.Fire;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public abstract class Obstacle {
    public static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    public float x;
    public float y;
    public float speed;
    public int Hitpoints;
    public boolean isDestroyed = false;
    public Collision collision;
    public int value;
    public Sprite sprite;
    public Fire fire;

    public Obstacle(float x, float y, int Hitpoints) {
        this.x = x;
        this.y = y;
        this.Hitpoints = Hitpoints;
        obstacles.add(this);
    }

    public abstract void update(float delta);
    public abstract void render(SpriteBatch batch);
    public void destroy() {
        obstacles.remove(this);
    }
}
