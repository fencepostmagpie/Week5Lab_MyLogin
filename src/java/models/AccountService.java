package models;


import models.User;



/**
 *
 * @author Aster
 */
public class AccountService {
    public User login(String username, String password) {
        String user = username;
        String pass = password;
        if ((user.equals("abe") && pass.equals("password")) || (user.equals("barb" ) && password.equals("password"))) {
            User profile = new User(); 
            profile.setName(user);
            profile.setPass("");
            return profile;
        }
        else {
            return null;
        }
    }
}
