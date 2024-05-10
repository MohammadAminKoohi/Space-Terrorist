package Controller;

import Model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import view.MainScreen;

public class RegisterController {

    public static String register(String username,String password){
        if(username.equals("") ||password.equals("")){
            return "Username or password cannot be empty";
        }
        if(User.getUserByUsername(username)!=null){
            return "Username already exists";
        }
        User user = new User(username,password,null);
        return null;
    }
}
