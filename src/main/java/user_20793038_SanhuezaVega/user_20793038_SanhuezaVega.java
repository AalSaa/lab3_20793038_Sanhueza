package user_20793038_SanhuezaVega;

import java.util.ArrayList;

public class user_20793038_SanhuezaVega implements userInterface_20793038_SanhuezaVega{
    String username;
    int isLogged;
    int cbCodelink;
    int fCodelink;

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
    public int getCbCodelink() {
        return cbCodelink;
    }

    @Override
    public int getfCodelink() {
        return fCodelink;
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

    public String toString() {
        return "user_20793038_SanhuezaVega{" +
                "username='" + username + '\'' +
                ", isLogged=" + isLogged +
                ", cbCodelink=" + cbCodelink +
                ", fCodelink=" + fCodelink +
                '}';
    }
}
