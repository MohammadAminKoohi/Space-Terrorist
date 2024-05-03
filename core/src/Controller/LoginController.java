package Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class LoginController {
    private Preferences preferences;

    public LoginController(){
        preferences = Gdx.app.getPreferences("userCredentials");
    }
    public String login(String username,String password){
        if(username.equals("") ||password.equals("")){
            return "Username or password cannot be empty";
        }
        if(!preferences.contains(username)){
            return "Username does not exist";
        }
        if(!preferences.getString(username).equals(password)){
            return "Password is incorrect";
        }
        return null;
    }
}
