package cbSystem_20793038_SanhuezaVega;

import java.util.ArrayList;
import java.util.Date;

import Tools.toolsInterface_20793038_SanhuezaVega;
import chatbot_20793038_SanhuezaVega.chatbot_20793038_SanhuezaVega;
import user_20793038_SanhuezaVega.user_20793038_SanhuezaVega;
import chatHistory_20793038_SanhuezaVega.chatHistory_20793038_SanhuezaVega;

public class cbSystem_20793038_SanhuezaVega implements toolsInterface_20793038_SanhuezaVega<chatbot_20793038_SanhuezaVega>{
    Date date;
    String name;
    ArrayList<user_20793038_SanhuezaVega> userList;
    ArrayList<chatHistory_20793038_SanhuezaVega> chatHistory;
    int startCBCodelink;
    ArrayList<chatbot_20793038_SanhuezaVega> chatbotList;

    public cbSystem_20793038_SanhuezaVega(Date date, String name, ArrayList<user_20793038_SanhuezaVega> userList, ArrayList<chatHistory_20793038_SanhuezaVega> chatHistory, int startCBCodelink, ArrayList<chatbot_20793038_SanhuezaVega> chatbotList) {
        this.date = date;
        this.name = name;
        this.userList = userList;
        this.chatHistory = chatHistory;
        this.startCBCodelink = startCBCodelink;
        this.chatbotList = chatbotList;
    }

    public cbSystem_20793038_SanhuezaVega(String name) {
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

    public ArrayList<user_20793038_SanhuezaVega> getUserList() {
        return userList;
    }

    public ArrayList<chatHistory_20793038_SanhuezaVega> getChatHistory() {
        return chatHistory;
    }

    public int getStartCBCodelink() {
        return startCBCodelink;
    }

    public ArrayList<chatbot_20793038_SanhuezaVega> getChatbotList() {
        return chatbotList;
    }

    @Override
    public void filterElementsInList(ArrayList<chatbot_20793038_SanhuezaVega> newCbList) {
        chatbot_20793038_SanhuezaVega selectedChatbot;
        int selectedChatbotID;

        for(int i = 0; i < newCbList.size(); i++){
            selectedChatbot = newCbList.get(i);
            selectedChatbotID = selectedChatbot.getId();

            if(!idExists(selectedChatbotID)) {
                this.chatbotList.add(selectedChatbot);
                // Aqui hay que poner un mensaje que se agrego algo xd
            }
            else {
                System.out.println("El chatbot con el id " + selectedChatbotID + " ya existe.");
            }
        }
    }

    @Override
    public boolean idExists(int id) {
        chatbot_20793038_SanhuezaVega selectedChatbot;
        int selectedID;
        ArrayList<chatbot_20793038_SanhuezaVega> cbList = this.chatbotList;

        for(int i = 0; i < cbList.size(); i++) {
            selectedChatbot = cbList.get(i);
            selectedID = selectedChatbot.getId();

            if(id == selectedID) {
                return true;
            }
        }
        return false;
    }
}
