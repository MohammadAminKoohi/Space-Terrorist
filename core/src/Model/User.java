package Model;

public class User {
    private String username;
    private String password;
    private String avatar;
    private int highScore;
    private int score;
    private int kills;
    private int accuracy;
    private int difficulty;
    private int lastRound;

    public User(String username, String password, String avatar, int score, int kills, int accuracy, int difficulty, int lastRound) {
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.score = score;
        this.kills = kills;
        this.accuracy = accuracy;
        this.difficulty = difficulty;
        this.lastRound = lastRound;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getLastRound() {
        return lastRound;
    }

    public void setLastRound(int lastRound) {
        this.lastRound = lastRound;
    }
}
