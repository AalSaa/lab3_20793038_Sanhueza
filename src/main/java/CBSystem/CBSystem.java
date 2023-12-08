package CBSystem;

import java.util.ArrayList;
import java.util.Date;

import Chatbot.Chatbot;
import User.User;
import ChatHistory.ChatHistory;

public class CBSystem {
    Date date;
    String name;
    ArrayList<User> userList;
    ArrayList<ChatHistory> chatHistory;
    int startCBCodelink;
    ArrayList<Chatbot> chatbotList;

    public CBSystem(Date date, String name, ArrayList<User> userList, ArrayList<ChatHistory> chatHistory, int startCBCodelink, ArrayList<Chatbot> chatbotList) {
        this.date = date;
        this.name = name;
        this.userList = userList;
        this.chatHistory = chatHistory;
        this.startCBCodelink = startCBCodelink;
        this.chatbotList = chatbotList;
    }

    public CBSystem(String name) {
        this.date = new Date();
        this.name = name;
        this.userList = new ArrayList<>();
        this.chatHistory = new ArrayList<>();
        this.startCBCodelink = -1;
        this.chatbotList = new ArrayList<>();
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public ArrayList<ChatHistory> getChatHistory() {
        return chatHistory;
    }

    public int getStartCBCodelink() {
        return startCBCodelink;
    }

    public ArrayList<Chatbot> getChatbotList() {
        return chatbotList;
    }

    public void systemAddChatbot(Chatbot cb) {
        int chatbotID = cb.getId();

        if(!idExists(chatbotID)) {
            this.chatbotList.add(cb);
            System.out.println("Se ha agregado el chatbot al sistema.");
        }
        else {
            System.out.println("Ya existe un chatbot con id " + chatbotID + " en el sistema.");
        }
    }

    public void systemAddUser (User user) {
        if (!userExists(user.getUsername())) {
            this.userList.add(user);
            if (user.getRole().equals("admin")) {
                System.out.println("Se ha agregado a " + user.getUsername() + " como admin del sistema.");
            }
            else {
                System.out.println("Se ha agregado a " + user.getUsername() + " como usuario del sistema.");
            }
        }
        else {
            System.out.println("El usuario " + user.getUsername() + " ya existe en el sistema.");
        }
    }

    public boolean idExists(int id) {
        Chatbot selectedCB;
        int selectedID;
        ArrayList<Chatbot> chatbotList = this.chatbotList;
        for (int i = 0; i < chatbotList.size(); i++) {
            selectedCB = chatbotList.get(i);
            selectedID = selectedCB.getId();
            if (selectedID == id) {
                return  true;
            }
        }
        return false;
    }

    public boolean userExists (String username) {
        User selectedUser;
        String selectedUsername;
        ArrayList<User> userList = this.userList;
        for (int i = 0; i < userList.size(); i++) {
            selectedUser = userList.get(i);
            selectedUsername = selectedUser.getUsername();
            if(username.equals(selectedUsername)){
                return true;
            }
        }
        return false;
    }
}
