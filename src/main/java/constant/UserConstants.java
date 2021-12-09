package constant;

import model.User;

public class UserConstants {
    public static final User[] USERS = {
            User.builder().username("gustavo.lemos").password("123456").build(),
            User.builder().username("paulo.dalescio").password("123456").build()
    };
}
