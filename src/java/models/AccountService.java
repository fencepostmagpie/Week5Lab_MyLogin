package models;


import models.User;



/**
 *
 * @author Aster
 */
public class AccountService {
    public User login(String username, String password) throws NullPointerException {
        User user = new User();
        user.setName(username);
        user.setPass(password);
        try {
            if ((user.getName().equals("abe") && user.getPass().equals("password")) || (user.getName().equals("barb" ) && user.getPass().equals("password"))) {
            return user;
            }
        }
        catch (NullPointerException e) {
            return null;
        }
        return null;
}
}