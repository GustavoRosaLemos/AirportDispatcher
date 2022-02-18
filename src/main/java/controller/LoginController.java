package controller;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class LoginController {
    public static boolean checkCredentials(String username, String password) {
        User user = DatabaseController.getUser(username, password);
        if (user != null) {
            Map<String, String> userMap = new HashMap<>();
            userMap.put("username", user.getUsername());
            userMap.put("password", user.getPassword());
            userMap.put("usernameInserted", username);
            userMap.put("passwordInserted", password);
            if (userMap.get("username") != null && userMap.get("password") != null) {
                if (userMap.get("username").equals(userMap.get("usernameInserted")) && userMap.get("password").equals(userMap.get("passwordInserted"))) {
                    return true;
                }
            }
        }
        return false;
    }
}
