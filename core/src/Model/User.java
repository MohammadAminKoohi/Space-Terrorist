package Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;

import java.util.ArrayList;

public class User {
    public static User loggedInUser;
    public static ArrayList<User> users = new ArrayList<User>();
    private String username;
    private String password;
    private Texture avatar;
    private int highScore;
    private int kills;
    private float accuracy;
    private int finalWave;
    private static Json json = new Json();
    public User(){

    }
    public User(String username, String password, Texture avatar) {
        this.username = username;
        this.password = password;
        this.kills = 0;
        this.highScore = 0;
        this.accuracy = 0;
        this.finalWave= 1;
        loggedInUser = this;
        users.add(this);
        addUser();
    }
    public static User getUserByUsername(String username){
        for(User user:users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    public static void saveUsers() {
        String usersJson = json.toJson(users);
        FileHandle file = Gdx.files.local("users.json");
        file.writeString(usersJson, false);
    }
    public void addUser(){
        String usersJson = json.toJson(users);
        FileHandle file = Gdx.files.local("users.json");
        file.writeString(usersJson, false);
    }

    public static void loadUsers() {
        FileHandle file = Gdx.files.local("users.json");
        if (file.exists()) {
            String usersJson = file.readString();
            users = json.fromJson(ArrayList.class, User.class, usersJson);
        }
    }
    public void saveGame(){
        User user = loggedInUser;
        user.setKills(Math.max(Player.player.killCount,user.getKills()));
        user.setHighScore(Math.max(Player.player.killCount*WaveManager.waveManager.wave*10+(Player.player.atomicBombs+ Player.player.clusterBombs)*75 ,user.getHighScore()));
        user.setAccuracy(Math.max(Player.getPlayer().getAccuracy(), user.getAccuracy()));
        user.setFinalWave(Math.max(WaveManager.waveManager.wave,user.getFinalWave()));
        saveUsers();
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        User.users = users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Texture getAvatar() {
        return avatar;
    }

    public void setAvatar(Texture avatar) {
        this.avatar = avatar;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public int getFinalWave() {
        return finalWave;
    }

    public void setFinalWave(int finalWave) {
        this.finalWave = finalWave;
    }

    public static Json getJson() {
        return json;
    }

    public static void setJson(Json json) {
        User.json = json;
    }
}