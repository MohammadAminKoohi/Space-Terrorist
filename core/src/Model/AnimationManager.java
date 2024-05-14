package Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AnimationManager {
    public static AnimationManager animationManager = new AnimationManager();
    Texture eplosion0 = new Texture("spaceship/missile_01_explosion/Missile_1_Explosion_000.png");
    Texture eplosion1 = new Texture("spaceship/missile_01_explosion/Missile_1_Explosion_001.png");
    Texture eplosion2 = new Texture("spaceship/missile_01_explosion/Missile_1_Explosion_002.png");
    Texture eplosion3 = new Texture("spaceship/missile_01_explosion/Missile_1_Explosion_003.png");
    Texture eplosion4 = new Texture("spaceship/missile_01_explosion/Missile_1_Explosion_004.png");
    Texture eplosion5 = new Texture("spaceship/missile_01_explosion/Missile_1_Explosion_005.png");
    Texture eplosion6 = new Texture("spaceship/missile_01_explosion/Missile_1_Explosion_006.png");
    Texture eplosion7 = new Texture("spaceship/missile_01_explosion/Missile_1_Explosion_007.png");
    Texture eplosion8 = new Texture("spaceship/missile_01_explosion/Missile_1_Explosion_008.png");
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
    Animation<Texture> dead = new Animation<Texture>(0.5f, dead0, dead1, dead2, dead3, dead4);
    Texture tankMissileExplosion0 = new Texture("Obstacles/tank/Missile_3_Explosion_000.png");
    Texture tankMissileExplosion1 = new Texture("Obstacles/tank/Missile_3_Explosion_001.png");
    Texture tankMissileExplosion2 = new Texture("Obstacles/tank/Missile_3_Explosion_002.png");
    Texture tankMissileExplosion3 = new Texture("Obstacles/tank/Missile_3_Explosion_003.png");
    Texture tankMissileExplosion4 = new Texture("Obstacles/tank/Missile_3_Explosion_004.png");
    Texture tankMissileExplosion5 = new Texture("Obstacles/tank/Missile_3_Explosion_005.png");
    Texture tankMissileExplosion6 = new Texture("Obstacles/tank/Missile_3_Explosion_006.png");
    Texture tankMissileExplosion7 = new Texture("Obstacles/tank/Missile_3_Explosion_007.png");
    Texture tankMissileExplosion8 = new Texture("Obstacles/tank/Missile_3_Explosion_008.png");

    public Animation<Texture> getTankMissileExplosion() {
        return new Animation<Texture>(0.2f, tankMissileExplosion0, tankMissileExplosion1, tankMissileExplosion2, tankMissileExplosion3, tankMissileExplosion4, tankMissileExplosion5, tankMissileExplosion6, tankMissileExplosion7, tankMissileExplosion8);
    }

    Texture explosion20 = new Texture("spaceship/type2Explosion/1.png");
    Texture explosion21 = new Texture("spaceship/type2Explosion/2.png");
    Texture explosion22 = new Texture("spaceship/type2Explosion/3.png");
    Texture explosion23 = new Texture("spaceship/type2Explosion/4.png");
    Texture explosion24 = new Texture("spaceship/type2Explosion/5.png");
    Texture explosion25 = new Texture("spaceship/type2Explosion/6.png");
    Texture explosion26 = new Texture("spaceship/type2Explosion/7.png");
    Texture explosion27 = new Texture("spaceship/type2Explosion/8.png");
    Texture explosion28 = new Texture("spaceship/type2Explosion/9.png");
    Texture explosion29 = new Texture("spaceship/type2Explosion/10.png");
    Texture explosion210 = new Texture("spaceship/type2Explosion/11.png");
    Texture explosion211 = new Texture("spaceship/type2Explosion/12.png");

    public Animation<Texture> getExplosion2() {
        return new Animation<Texture>(0.07f, explosion23, explosion24, explosion25, explosion26, explosion27, explosion28, explosion29, explosion210, explosion211);
    }

    Texture nuclearExplosion0 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion1.png");
    Texture nuclearExplosion1 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion2.png");
    Texture nuclearExplosion2 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion3.png");
    Texture nuclearExplosion3 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion4.png");
    Texture nuclearExplosion4 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion5.png");
    Texture nuclearExplosion5 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion6.png");
    Texture nuclearExplosion6 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion7.png");
    Texture nuclearExplosion7 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion8.png");
    Texture nuclearExplosion8 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion9.png");
    Texture nuclearExplosion9 = new Texture("spaceship/NuclearExplosion/Nuclear_explosion10.png");

    public Animation<Texture> getNuclearExplosion() {
        return new Animation<Texture>(0.1f, nuclearExplosion0, nuclearExplosion1, nuclearExplosion2, nuclearExplosion3, nuclearExplosion4, nuclearExplosion5, nuclearExplosion6, nuclearExplosion7, nuclearExplosion8, nuclearExplosion9);
    }
    Texture ufoMissileTexture0= new Texture("Obstacles/ufo/Missile/1_0.png");
    Texture ufoMissileTexture1 = new Texture("Obstacles/ufo/Missile/1_1.png");
    Texture ufoMissileTexture2 = new Texture("Obstacles/ufo/Missile/1_2.png");
    Texture ufoMissileTexture3 = new Texture("Obstacles/ufo/Missile/1_3.png");
    Texture ufoMissileTexture4 = new Texture("Obstacles/ufo/Missile/1_4.png");
    Texture ufoMissileTexture5 = new Texture("Obstacles/ufo/Missile/1_5.png");
    Texture ufoMissileTexture6 = new Texture("Obstacles/ufo/Missile/1_6.png");
    Texture ufoMissileTexture7 = new Texture("Obstacles/ufo/Missile/1_7.png");
    Texture ufoMissileTexture8 = new Texture("Obstacles/ufo/Missile/1_8.png");
    Texture ufoMissileTexture9 = new Texture("Obstacles/ufo/Missile/1_9.png");
    Texture ufoMissileTexture10 = new Texture("Obstacles/ufo/Missile/1_10.png");
    Texture ufoMissileTexture11 = new Texture("Obstacles/ufo/Missile/1_11.png");
    Texture ufoMissileTexture12 = new Texture("Obstacles/ufo/Missile/1_12.png");
    Texture ufoMissileTexture13 = new Texture("Obstacles/ufo/Missile/1_13.png");
    Texture ufoMissileTexture14 = new Texture("Obstacles/ufo/Missile/1_14.png");
    Texture ufoMissileTexture15 = new Texture("Obstacles/ufo/Missile/1_15.png");
    Texture ufoMissileTexture16 = new Texture("Obstacles/ufo/Missile/1_16.png");
    Texture ufoMissileTexture17 = new Texture("Obstacles/ufo/Missile/1_17.png");
    Texture ufoMissileTexture18 = new Texture("Obstacles/ufo/Missile/1_18.png");
    Texture ufoMissileTexture19 = new Texture("Obstacles/ufo/Missile/1_19.png");
    Texture ufoMissileTexture20 = new Texture("Obstacles/ufo/Missile/1_20.png");
    Texture ufoMissileTexture21 = new Texture("Obstacles/ufo/Missile/1_21.png");
    Texture ufoMissileTexture22 = new Texture("Obstacles/ufo/Missile/1_22.png");
    Texture ufoMissileTexture23 = new Texture("Obstacles/ufo/Missile/1_23.png");
    Texture ufoMissileTexture24 = new Texture("Obstacles/ufo/Missile/1_24.png");
    Texture ufoMissileTexture25 = new Texture("Obstacles/ufo/Missile/1_25.png");
    Texture ufoMissileTexture26 = new Texture("Obstacles/ufo/Missile/1_26.png");
    Texture ufoMissileTexture27 = new Texture("Obstacles/ufo/Missile/1_27.png");
    Texture ufoMissileTexture28 = new Texture("Obstacles/ufo/Missile/1_28.png");
    Texture ufoMissileTexture29 = new Texture("Obstacles/ufo/Missile/1_29.png");
    Texture ufoMissileTexture30 = new Texture("Obstacles/ufo/Missile/1_30.png");
    Texture ufoMissileTexture31 = new Texture("Obstacles/ufo/Missile/1_31.png");
    Texture ufoMissileTexture32 = new Texture("Obstacles/ufo/Missile/1_32.png");
    Texture ufoMissileTexture33 = new Texture("Obstacles/ufo/Missile/1_33.png");
    Texture ufoMissileTexture34 = new Texture("Obstacles/ufo/Missile/1_34.png");
    Texture ufoMissileTexture35 = new Texture("Obstacles/ufo/Missile/1_35.png");
    Texture ufoMissileTexture36 = new Texture("Obstacles/ufo/Missile/1_36.png");
    Texture ufoMissileTexture37 = new Texture("Obstacles/ufo/Missile/1_37.png");
    Texture ufoMissileTexture38 = new Texture("Obstacles/ufo/Missile/1_38.png");
    Texture ufoMissileTexture39 = new Texture("Obstacles/ufo/Missile/1_39.png");
    Texture ufoMissileTexture40 = new Texture("Obstacles/ufo/Missile/1_40.png");
    Texture ufoMissileTexture41 = new Texture("Obstacles/ufo/Missile/1_41.png");
    Texture ufoMissileTexture42 = new Texture("Obstacles/ufo/Missile/1_42.png");
    Texture ufoMissileTexture43 = new Texture("Obstacles/ufo/Missile/1_43.png");
    Texture ufoMissileTexture44 = new Texture("Obstacles/ufo/Missile/1_44.png");
    Texture ufoMissileTexture45 = new Texture("Obstacles/ufo/Missile/1_45.png");
    Texture ufoMissileTexture46 = new Texture("Obstacles/ufo/Missile/1_46.png");
    Texture ufoMissileTexture47 = new Texture("Obstacles/ufo/Missile/1_47.png");
    Texture ufoMissileTexture48 = new Texture("Obstacles/ufo/Missile/1_48.png");
    Texture ufoMissileTexture49 = new Texture("Obstacles/ufo/Missile/1_49.png");
    Texture ufoMissileTexture50 = new Texture("Obstacles/ufo/Missile/1_50.png");
    Texture ufoMissileTexture51 = new Texture("Obstacles/ufo/Missile/1_51.png");
    Texture ufoMissileTexture52 = new Texture("Obstacles/ufo/Missile/1_52.png");
    Texture ufoMissileTexture53 = new Texture("Obstacles/ufo/Missile/1_53.png");
    Texture ufoMissileTexture54 = new Texture("Obstacles/ufo/Missile/1_54.png");
    Texture ufoMissileTexture55 = new Texture("Obstacles/ufo/Missile/1_55.png");
    Texture ufoMissileTexture56 = new Texture("Obstacles/ufo/Missile/1_56.png");
    Texture ufoMissileTexture57 = new Texture("Obstacles/ufo/Missile/1_57.png");
    Texture ufoMissileTexture58 = new Texture("Obstacles/ufo/Missile/1_58.png");
    Texture ufoMissileTexture59 = new Texture("Obstacles/ufo/Missile/1_59.png");
    Animation<Texture> greenUfoMissile = new Animation<Texture>(0.01f, ufoMissileTexture0, ufoMissileTexture1, ufoMissileTexture2, ufoMissileTexture3, ufoMissileTexture4, ufoMissileTexture5, ufoMissileTexture6, ufoMissileTexture7, ufoMissileTexture8, ufoMissileTexture9, ufoMissileTexture10, ufoMissileTexture11, ufoMissileTexture12, ufoMissileTexture13, ufoMissileTexture14, ufoMissileTexture15, ufoMissileTexture16, ufoMissileTexture17, ufoMissileTexture18, ufoMissileTexture19, ufoMissileTexture20, ufoMissileTexture21, ufoMissileTexture22, ufoMissileTexture23, ufoMissileTexture24, ufoMissileTexture25, ufoMissileTexture26, ufoMissileTexture27, ufoMissileTexture28, ufoMissileTexture29, ufoMissileTexture30, ufoMissileTexture31, ufoMissileTexture32, ufoMissileTexture33, ufoMissileTexture34, ufoMissileTexture35, ufoMissileTexture36, ufoMissileTexture37, ufoMissileTexture38, ufoMissileTexture39, ufoMissileTexture40, ufoMissileTexture41, ufoMissileTexture42, ufoMissileTexture43, ufoMissileTexture44, ufoMissileTexture45, ufoMissileTexture46, ufoMissileTexture47, ufoMissileTexture48, ufoMissileTexture49, ufoMissileTexture50, ufoMissileTexture51, ufoMissileTexture52, ufoMissileTexture53, ufoMissileTexture54, ufoMissileTexture55, ufoMissileTexture56, ufoMissileTexture57, ufoMissileTexture58, ufoMissileTexture59);
    Texture fireTexture0= new Texture("Obstacles/Fire/Fire+Sparks1.png");
    Texture fireTexture1 = new Texture("Obstacles/Fire/Fire+Sparks2.png");
    Texture fireTexture2 = new Texture("Obstacles/Fire/Fire+Sparks3.png");
    Texture fireTexture3 = new Texture("Obstacles/Fire/Fire+Sparks4.png");
    Texture fireTexture4 = new Texture("Obstacles/Fire/Fire+Sparks5.png");
    Texture fireTexture5 = new Texture("Obstacles/Fire/Fire+Sparks6.png");
    Texture fireTexture6 = new Texture("Obstacles/Fire/Fire+Sparks7.png");
    Texture fireTexture7 = new Texture("Obstacles/Fire/Fire+Sparks8.png");
    Texture fireTexture8 = new Texture("Obstacles/Fire/Fire+Sparks9.png");
    Texture fireTexture9 = new Texture("Obstacles/Fire/Fire+Sparks10.png");
    Texture fireTexture10 = new Texture("Obstacles/Fire/Fire+Sparks11.png");
    Texture fireTexture11 = new Texture("Obstacles/Fire/Fire+Sparks12.png");
    Texture fireTexture12 = new Texture("Obstacles/Fire/Fire+Sparks13.png");
    Texture fireTexture13 = new Texture("Obstacles/Fire/Fire+Sparks14.png");
    Texture fireTexture14 = new Texture("Obstacles/Fire/Fire+Sparks15.png");
    Texture fireTexture15 = new Texture("Obstacles/Fire/Fire+Sparks16.png");
    Texture fireTexture16 = new Texture("Obstacles/Fire/Fire+Sparks17.png");
    Texture fireTexture17 = new Texture("Obstacles/Fire/Fire+Sparks18.png");
    Texture fireTexture18 = new Texture("Obstacles/Fire/Fire+Sparks19.png");
    Animation<Texture> fireAnimation = new Animation<Texture>(0.1f, fireTexture0, fireTexture1, fireTexture2, fireTexture3, fireTexture4, fireTexture5, fireTexture6, fireTexture7, fireTexture8, fireTexture9, fireTexture10, fireTexture11, fireTexture12, fireTexture13, fireTexture14, fireTexture15, fireTexture16, fireTexture17, fireTexture18);
    public Animation<Texture> getFireAnimation(){
        return fireAnimation;
    }
    public Animation<Texture> getUfoMissile(){
        return greenUfoMissile;
    }
    public Animation<Texture> getAlienDead() {
        return dead;
    }

    public Animation<Texture> getAlienIdle() {
        return idle;
    }

    public Animation<Texture> getBombExplosion() {
        return explosion;
    }
}
