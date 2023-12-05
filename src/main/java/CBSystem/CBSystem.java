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

}
