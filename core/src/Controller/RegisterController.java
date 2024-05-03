package Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import view.MainScreen;

public class RegisterController {
    private Preferences preferences;
    public RegisterController(){
        preferences = Gdx.app.getPreferences("userCredentials");
    }

    public String register(String username,String password){
        if(username.equals("") ||password.equals("")){
            return "Username or password cannot be empty";
        }
        if(preferences.contains(username)){
            return "Username already exists";
        }
        preferences.putString(username,password);
        preferences.flush();
        return null;
    }
}
