package Controller;

import Collectibles.Collectible;
import Model.Bomb.AtomicBomb;
import Model.Bomb.Bomb;
import Model.Bomb.NormalBomb;
import Model.Player;
import Model.Spawner;
import Model.WaveManager;
import Obstacles.Obstacle;
import Obstacles.Tank;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.SpaceTerrorists;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameController {
    private static Player player = Player.getPlayer();
    public static Random random = new Random();

    public static void update(SpaceTerrorists spaceTerrorists) {
        playerinput(spaceTerrorists);
        updatePlaneSprite();
        cheatCodes(spaceTerrorists);
        airResistance();
        boarderCheck();
        normalBomb();
        clusterBomb();
        atomicBomb();
        collisionsHandler();
    }
    public static void cheatCodes(SpaceTerrorists spaceTerrorists){
        if(Gdx.input.isKeyJustPressed(Input.Keys.P)){
            WaveManager.waveManager.waveChanger(spaceTerrorists,true);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.G)){
            player.atomicBombs++;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.CONTROL_LEFT)){
            player.clusterBombs++;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.T)){
            Obstacle.obstacles.add(new Tank(random.nextInt(Gdx.graphics.getWidth()),random.nextInt(150)+50));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.H)){
            player.Hitpoint=25;
        }
    }
    public static void collisionsHandler(){
        for(Obstacle obstacle: Obstacle.obstacles){
            if(player.collision.isColliding(obstacle.collision)){
                player.Hitpoint=0;
            }
        }
        for(Collectible collectible: Collectible.collectibles){
            if(player.collision.isColliding(collectible.collision)){
                collectible.collect();
            }
        }
    }
    public static void atomicBomb(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.R) && player.atomicBombs>0){
            player.addBomb(new AtomicBomb(player.planeSprite.getX() + player.planeSprite.getWidth() / 2, player.planeSprite.getY() + 10,player.speedX));
            player.atomicBombs--;
            player.shotCount++;
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
            player.shotCount++;
        }
    }
    public static void normalBomb(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            player.addBomb(new NormalBomb(player.planeSprite.getX() + player.planeSprite.getWidth() / 2, player.planeSprite.getY() + 10,player.speedX));
            player.shotCount++;
        }
    }
    public static void playerinput(SpaceTerrorists spaceTerrorists) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            spaceTerrorists.isPaused= !spaceTerrorists.isPaused;
            return;
        }
        if(spaceTerrorists.isPaused){
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (player.speedY < 2f)
                player.speedY += 0.1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (player.speedY > -2f)
                player.speedY -= 0.1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (player.speedX > -2f)
                player.speedX -= 0.1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (player.speedX < 2f)
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