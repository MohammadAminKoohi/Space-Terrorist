package Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class freezBar {
    public boolean isFreez = false;
    public Texture freezBar = new Texture("freezBar.png");
    public Sprite freezBarSprite = new Sprite(freezBar);
    public float freezBarWidth = 0;
    public float freezBarHeight = 20;
    public int lastkillCount = 0;
    public float freezBarX = 0;
    public freezBar(){
        freezBarSprite.setSize(freezBarWidth, freezBarHeight);
        lastkillCount = 0;
    }
    public void render(SpriteBatch batch){
            freezBarSprite.setPosition(20, Gdx.graphics.getHeight()-100);
            freezBarSprite.setSize(freezBarWidth, freezBarHeight);
            freezBarSprite.draw(batch);
    }
    public void update(float delta){
        int diff = Player.player.killCount - lastkillCount;
        lastkillCount = Player.player.killCount;
        if(!isFreez){
            if(diff>0){
                float oldWidth = freezBarWidth;
                freezBarWidth += diff*10;
                if(freezBarWidth > 500){
                    freezBarWidth = 500;
                }
                float widthChange = freezBarWidth - oldWidth;
                freezBarX -= widthChange; // Adjust the x position
            }
            freezBarSprite.setPosition(freezBarX, Gdx.graphics.getHeight()-100);
            freezBarSprite.setSize(freezBarWidth, freezBarHeight);
        }
        else{
            freezBarWidth -= 0.5f;
            if(freezBarWidth <= 0){
                freezBarWidth = 0;
                isFreez = false;
            }
            freezBarSprite.setPosition(freezBarX, Gdx.graphics.getHeight()-100);
            freezBarSprite.setSize(freezBarWidth, freezBarHeight);
        }
    }
}
