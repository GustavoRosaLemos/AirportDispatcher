package controller;

import constant.UserConstants;
import model.User;

public class LoginControllerImpl implements LoginController {
    public static boolean checkCredentials(String username, String password) {
        for (User user : UserConstants.USERS) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
