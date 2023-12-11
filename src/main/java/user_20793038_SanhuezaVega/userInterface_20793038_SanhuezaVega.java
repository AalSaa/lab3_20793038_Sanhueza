package user_20793038_SanhuezaVega;

import java.util.ArrayList;

public interface userInterface_20793038_SanhuezaVega {
    String getUsername();
    int getIsLogged();
    int getCbCodelink();
    int getfCodelink();
    boolean userExistsInList(ArrayList<user_20793038_SanhuezaVega> userList);

    void login();
    void logout();
}
