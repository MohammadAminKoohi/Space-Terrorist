package Collectibles;

import Model.Player;
import com.badlogic.gdx.graphics.Texture;

public class ClusterBombCollectible extends Collectible{
    public ClusterBombCollectible(float x,float y){
        super(x,y,new Texture("Collectibles/clusterBombCollectible.png"));
        collectibles.add(this);
    }
    public void collect(){
        Player.player.clusterBombs++;
        isDestroyed = true;
    }
}
