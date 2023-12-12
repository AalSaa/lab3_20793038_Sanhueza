package user_20793038_SanhuezaVega;

import java.util.ArrayList;

public class user_20793038_SanhuezaVega implements userInterface_20793038_SanhuezaVega{
    /**
     * El nombre del usuario
     */
    String username;
    /**
     * El comprobador si el usuario esta logueado
     */
    int isLogged;

    /**
     * El codigo del chatbot donde esta ubicado actualmente el usuario
     */
    int cbCodelink;

    /**
     * El codigo del flujo donde esta ubicado actualmente el usuario
     */
    int fCodelink;

    /**
     * Constructor del usuario
     *
     * @param username  nombre del usuario
     * @param isLogged  comprobador si el usuario esta logueado
     * @param cbCodelink  codigo del chatbot donde esta ubicado actualmente el usuario
     * @param fCodelink  codigo del flujo donde esta ubicado actualmente el usuario
     */
    public user_20793038_SanhuezaVega(String username, int isLogged, int cbCodelink, int fCodelink) {
        this.username = username;
        this.isLogged = isLogged;
        this.cbCodelink = cbCodelink;
        this.fCodelink = fCodelink;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getIsLogged() {
        return isLogged;
    }

    @Override
    public boolean userExistsInList(ArrayList<user_20793038_SanhuezaVega> userList) {
        user_20793038_SanhuezaVega selectedUser;
        String selectedUsername;
        String username = this.username;

         for(int i = 0; i < userList.size(); i++) {
            selectedUser = userList.get(i);
            selectedUsername = selectedUser.getUsername();

            if(selectedUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void login(){
        this.isLogged = 1;
    }

    @Override
    public void logout(){
        this.isLogged = 0;
    }
}
