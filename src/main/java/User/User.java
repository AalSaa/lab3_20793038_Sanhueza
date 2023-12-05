package User;

import java.util.ArrayList;

public class User {
    String username;
    String role;
    int isLogged;
    int cbCodelink;
    int fCodelink;

    public User(String username, String rol, int status, int cbCodelink, int fCodelink) {
        this.username = username;
        this.role = rol;
        this.isLogged = status;
        this.cbCodelink = cbCodelink;
        this.fCodelink = fCodelink;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public int getIsLogged() {
        return isLogged;
    }

    public int getCbCodelink() {
        return cbCodelink;
    }

    public int getFCodelink() {
        return fCodelink;
    }

    public void setStatus(int status) {
        this.isLogged = status;
    }

    public void setCbCodelink(int cbCodelink) {
        this.cbCodelink = cbCodelink;
    }

    public void setFCodelink(int fCodelink) {
        this.fCodelink = fCodelink;
    }
}
