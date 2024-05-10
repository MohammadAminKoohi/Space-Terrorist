package Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Fire {
    public static ArrayList<Fire> fires = new ArrayList<Fire>();
    public Sprite mainSprite;
    public Sprite fireSprite= new Sprite();
    float timeState=0;
    Animation<Texture> fireAnimation = AnimationManager.animationManager.getFireAnimation();
    public Fire(Sprite sprite){
        mainSprite = sprite;
        fireSprite = new Sprite(fireAnimation.getKeyFrame(timeState));
        fires.add(this);
    }
    public void update(float delta){
        fireSprite.setRegion(fireAnimation.getKeyFrame(timeState));
        fireSprite.setPosition(mainSprite.getX()-mainSprite.getWidth()*0.2f,mainSprite.getY()+20);
        fireSprite.setSize(mainSprite.getWidth()*1.5f,mainSprite.getHeight()*1.5f);
        if (!fireAnimation.isAnimationFinished(timeState)) {
            timeState += delta;
        }
        else {
            timeState = 0;
        }

    }
}
