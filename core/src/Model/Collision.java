package Model;

public class Collision {
    float x;
    float y;
    float width;
    float height;
    public Collision(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void move(float x, float y){
        this.x = x;
        this.y = y;
    }
    public boolean isColliding(Collision other){
        return x + width > other.x && x < other.x + other.width && y + height > other.y && y < other.y + other.height;
    }
}
