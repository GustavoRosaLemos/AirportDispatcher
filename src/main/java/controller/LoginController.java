package controller;

import model.User;

public class LoginController {
    public static boolean checkCredentials(String username, String password) {
        User user = DatabaseController.getUser(username, password);
        if (user.getUsername() != null && user.getPassword() != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
