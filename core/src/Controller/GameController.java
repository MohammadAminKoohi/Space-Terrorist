package Controller;

import Model.Bomb.AtomicBomb;
import Model.Bomb.Bomb;
import Model.Bomb.NormalBomb;
import Model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.SpaceTerrorists;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameController {
    private static Player player = Player.getPlayer();

    public static void update(SpaceTerrorists spaceTerrorists) {
        playerinput(spaceTerrorists);
        updatePlaneSprite();
        airResistance();
        boarderCheck();
        normalBomb();
        clusterBomb();
        atomicBomb();
        removeBombs();
    }
    public static void removeBombs(){
        for (int i = 0; i < player.bombs.size(); i++) {
            ArrayList<Bomb> removeList = new ArrayList<Bomb>();
               if (player.bombs.get(i).isDestroyed()) {
                removeList.add(player.bombs.get(i));
            }
            for (Bomb bomb : removeList) {
                player.bombs.remove(bomb);
            }
        }
    }
    public static void atomicBomb(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            player.addBomb(new AtomicBomb(player.planeSprite.getX() + player.planeSprite.getWidth() / 2, player.planeSprite.getY() + 10,player.speedX));
        }
    }
    public static void clusterBomb(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.C) && Player.player.clusterBombs > 0){
            player.addBomb(new NormalBomb(player.planeSprite.getX() + player.planeSprite.getWidth() / 2, player.planeSprite.getY() + 10,player.speedX));
            player.addBomb(new NormalBomb(player.planeSprite.getX() + player.planeSprite.getWidth() / 2, player.planeSprite.getY() + 10,player.speedX + 0.1f));
            player.addBomb(new NormalBomb(player.planeSprite.getX() + player.planeSprite.getWidth() / 2, player.planeSprite.getY() + 10,player.speedX - 0.1f));
            player.addBomb(new NormalBomb(player.planeSprite.getX() + player.planeSprite.getWidth() / 2, player.planeSprite.getY() + 10,player.speedX + 0.2f));
            player.addBomb(new NormalBomb(player.planeSprite.getX() + player.planeSprite.getWidth() / 2, player.planeSprite.getY() + 10,player.speedX - 0.2f));
            player.clusterBombs--;
        }
    }
    public static void normalBomb(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            player.addBomb(new NormalBomb(player.planeSprite.getX() + player.planeSprite.getWidth() / 2, player.planeSprite.getY() + 10,player.speedX));
        }
    }
    public static void playerinput(SpaceTerrorists spaceTerrorists) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (player.speedY < 1.3f)
                player.speedY += 0.1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (player.speedY > -1.3f)
                player.speedY -= 0.1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (player.speedX > -1.3f)
                player.speedX -= 0.1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (player.speedX < 1.3f)
                player.speedX += 0.1f;
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.S) && !Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.D)) {
            if(player.speedX < 0.01f && player.speedX > -0.01f){
                player.speedX = 0;
            }
            if(player.speedY < 0.01f && player.speedY > -0.01f){
                player.speedY = 0;
            }
        }
    }

    public static void airResistance() {
        if (player.speedX > 0) {
            player.speedX -= 0.01f;
        }
        if (player.speedX < 0) {
            player.speedX += 0.01f;
        }
        if (player.speedY > 0) {
            player.speedY -= 0.01f;
        }
        if (player.speedY < 0) {
            player.speedY += 0.01f;
        }
    }

    public static void updatePlaneSprite() {
        player.planeSprite.setX(player.planeSprite.getX() + player.speedX * player.speed * Gdx.graphics.getDeltaTime());
        player.planeSprite.setY(player.planeSprite.getY() + player.speedY * player.speed * Gdx.graphics.getDeltaTime());
        player.collision.move(player.planeSprite.getX(), player.planeSprite.getY());
        if (player.speedX < 0 && player.planeSprite.getTexture() != player.planeFlipped) {
            player.planeSprite.setTexture(player.planeFlipped);
        }
        if (player.speedX > 0 && player.planeSprite.getTexture() != player.plane) {
            player.planeSprite.setTexture(player.plane);
        }
        player.planeSprite.setOriginCenter();
        if(player.planeSprite.getTexture()==player.plane){
            player.planeSprite.setRotation((float) Math.toDegrees(Math.atan2(player.speedY, player.speedX)));
        }
        else{
            player.planeSprite.setRotation((float) Math.toDegrees(Math.atan2(player.speedY, player.speedX)) + 180);
        }
        if(player.speedX==0 && player.speedY==0){
            player.planeSprite.setRotation(0);
        }
    }

    public static void boarderCheck() {
        if (player.planeSprite.getX() < 0 - player.planeSprite.getWidth() + 40) {
            player.planeSprite.setX(Gdx.graphics.getWidth() + player.planeSprite.getWidth() - 40);
        }
        if (player.planeSprite.getX() > Gdx.graphics.getWidth() + player.planeSprite.getWidth() - 40) {
            player.planeSprite.setX(0 - player.planeSprite.getWidth() + 40);
            System.out.println(player.planeSprite.getX());
        }
        if (player.planeSprite.getY() < 220) {
            player.planeSprite.setY(220);
        }
        if (player.planeSprite.getY() > Gdx.graphics.getHeight() - player.planeSprite.getHeight()) {
            player.planeSprite.setY(Gdx.graphics.getHeight() - player.planeSprite.getHeight());
        }
    }
}
