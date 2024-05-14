package Model.Collectibles;

import Model.Player;
import com.badlogic.gdx.graphics.Texture;

public class AtomicBombCollectible extends Collectible{
    public AtomicBombCollectible(float x,float y){
        super(x,y,new Texture("Collectibles/atomicBombCollectible.png"));
        collectibles.add(this);
    }
    public void collect(){
        Player.player.atomicBombs++;
        isDestroyed = true;
    }
}
