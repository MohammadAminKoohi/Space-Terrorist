package Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AnimationManager {
    public static AnimationManager animationManager = new AnimationManager();
    Texture eplosion0 = new Texture("spaceship/missle_01_explosion/Missile_1_Explosion_000.png");
    Texture eplosion1 = new Texture("spaceship/missle_01_explosion/Missile_1_Explosion_001.png");
    Texture eplosion2 = new Texture("spaceship/missle_01_explosion/Missile_1_Explosion_002.png");
    Texture eplosion3 = new Texture("spaceship/missle_01_explosion/Missile_1_Explosion_003.png");
    Texture eplosion4 = new Texture("spaceship/missle_01_explosion/Missile_1_Explosion_004.png");
    Texture eplosion5 = new Texture("spaceship/missle_01_explosion/Missile_1_Explosion_005.png");
    Texture eplosion6 = new Texture("spaceship/missle_01_explosion/Missile_1_Explosion_006.png");
    Texture eplosion7 = new Texture("spaceship/missle_01_explosion/Missile_1_Explosion_007.png");
    Texture eplosion8 = new Texture("spaceship/missle_01_explosion/Missile_1_Explosion_008.png");
    Animation<Texture> explosion = new Animation<Texture>(0.03f, eplosion0, eplosion1, eplosion2, eplosion3, eplosion4, eplosion5, eplosion6, eplosion7, eplosion8);
    Texture idle0 = new Texture("Obstacles/alien/green__0000_idle_1.png");
    Texture idle1 = new Texture("Obstacles/alien/green__0001_idle_2.png");
    Texture idle2 = new Texture("Obstacles/alien/green__0002_idle_3.png");
    Animation<Texture> idle = new Animation<Texture>(1f, idle0, idle1, idle2);
    Texture dead0 = new Texture("Obstacles/alien/green__0022_dead_1.png");
    Texture dead1 = new Texture("Obstacles/alien/green__0023_dead_2.png");
    Texture dead2 = new Texture("Obstacles/alien/green__0024_dead_3.png");
    Texture dead3 = new Texture("Obstacles/alien/green__0025_dead_4.png");
    Texture dead4 = new Texture("Obstacles/alien/green__0026_dead_5.png");
    Animation<Texture> dead = new Animation<Texture>(0.2f, dead0, dead1, dead2, dead3, dead4);
    Texture tankMissileExplosion0 = new Texture("Obstacles/tank/Missile_3_Explosion_000.png");
    Texture tankMissileExplosion1 = new Texture("Obstacles/tank/Missile_3_Explosion_001.png");
    Texture tankMissileExplosion2 = new Texture("Obstacles/tank/Missile_3_Explosion_002.png");
    Texture tankMissileExplosion3 = new Texture("Obstacles/tank/Missile_3_Explosion_003.png");
    Texture tankMissileExplosion4 = new Texture("Obstacles/tank/Missile_3_Explosion_004.png");
    Texture tankMissileExplosion5 = new Texture("Obstacles/tank/Missile_3_Explosion_005.png");
    Texture tankMissileExplosion6 = new Texture("Obstacles/tank/Missile_3_Explosion_006.png");
    Texture tankMissileExplosion7 = new Texture("Obstacles/tank/Missile_3_Explosion_007.png");
    Texture tankMissileExplosion8 = new Texture("Obstacles/tank/Missile_3_Explosion_008.png");
    public Animation<Texture> getTankMissileExplosion(){
        return new Animation<Texture>(0.03f, tankMissileExplosion0, tankMissileExplosion1, tankMissileExplosion2, tankMissileExplosion3, tankMissileExplosion4, tankMissileExplosion5, tankMissileExplosion6, tankMissileExplosion7, tankMissileExplosion8);
    }

    public Animation<Texture> getAlienDead(){
        return dead;
    }
    public Animation<Texture> getAlienIdle(){
        return idle;
    }
    public Animation<Texture> getBombExplosion(){
        return explosion;
    }
}
