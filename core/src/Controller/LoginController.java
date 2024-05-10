package Controller;

import Model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class LoginController {
    public static String login(String username,String password){
        if(username.equals("") ||password.equals("")){
            return "Username or password cannot be empty";
        }
        User user = User.getUserByUsername(username);
        if(user==null){
            return "Username does not exist";
        }
        if(!user.getPassword().equals(password)){
            return "Password is incorrect";
        }
        return null;
    }
}
