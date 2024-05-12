package Model;

import com.badlogic.gdx.Input;

public class GameSettings {
    public static int difficulty = 1;
    public static int upKey = Input.Keys.W;
    public static int downKey = Input.Keys.S;
    public static int rightKey = Input.Keys.D;
    public static int leftKey = Input.Keys.A;
    public static float tankSpeed = 30;
    public static float tankShootDelay = 3f;
    public static float ufoShootDelay = 2f;
    public static float tankShootRange = 500;
    public static float ufoShootRange = 500;
    public static float ufoSpawnDelay = 2f;
    public static void setInputs(int mode){
        if(mode==1){
            upKey = Input.Keys.W;
            downKey = Input.Keys.S;
            rightKey = Input.Keys.D;
            leftKey = Input.Keys.A;
        }
        else if(mode==2){
            upKey = Input.Keys.UP;
            downKey = Input.Keys.DOWN;
            rightKey = Input.Keys.RIGHT;
            leftKey = Input.Keys.LEFT;
        }
    }

    public static void setDifficulty(int difficulty){
        if(difficulty == 2){
            tankSpeed = 30;
            tankShootDelay = 3f;
            ufoShootDelay = 2f;
            tankShootRange = 500;
            ufoShootRange = 500;
            ufoSpawnDelay=2f;
        }
        else if(difficulty == 1){
            tankSpeed = 20;
            tankShootDelay = 4f;
            ufoShootDelay = 3f;
            tankShootRange = 250;
            ufoShootRange = 250;
            ufoSpawnDelay=4f;
        }
        else if(difficulty==3){
            tankSpeed = 50;
            tankShootDelay = 2f;
            ufoShootDelay = 1f;
            tankShootRange = 750;
            ufoShootRange = 750;
            ufoSpawnDelay=1f;
        }
        GameSettings.difficulty = difficulty;
    }

}
