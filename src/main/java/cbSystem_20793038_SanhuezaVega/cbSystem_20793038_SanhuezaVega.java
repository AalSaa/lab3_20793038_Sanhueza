package cbSystem_20793038_SanhuezaVega;

import java.util.ArrayList;
import java.util.Date;

import Tools.toolsInterface_20793038_SanhuezaVega;
import chatbot_20793038_SanhuezaVega.chatbot_20793038_SanhuezaVega;
import user_20793038_SanhuezaVega.user_20793038_SanhuezaVega;
import chatHistory_20793038_SanhuezaVega.chatHistory_20793038_SanhuezaVega;

public class cbSystem_20793038_SanhuezaVega implements cbSystemInterface_20793038_SanhuezaVega
                                                     , toolsInterface_20793038_SanhuezaVega<chatbot_20793038_SanhuezaVega>{
    Date date;
    String name;
    ArrayList<user_20793038_SanhuezaVega> userList;
    ArrayList<chatHistory_20793038_SanhuezaVega> chatHistory;
    int startCBCodelink;
    ArrayList<chatbot_20793038_SanhuezaVega> chatbotList;

    public cbSystem_20793038_SanhuezaVega(String name, int startCBCodelink,
                                          ArrayList<chatbot_20793038_SanhuezaVega> chatbotList) {
        this.date = new Date();
        this.name = name;
        this.userList = new ArrayList<>();
        this.chatHistory = new ArrayList<>();
        this.startCBCodelink = startCBCodelink;
        this.chatbotList = new ArrayList<>();

        filterElementsInList(chatbotList);
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

    public user_20793038_SanhuezaVega getLoggedUser(){
        user_20793038_SanhuezaVega selectedUser;
        int selectedUserIsLogged;
        ArrayList<user_20793038_SanhuezaVega> userList = this.userList;

        for(int i = 0; i < userList.size(); i++){
            selectedUser = userList.get(i);
            selectedUserIsLogged = selectedUser.getIsLogged();

            if(selectedUserIsLogged == 1){
                return  selectedUser;
            }
        }
        return null;
    }

    public boolean someoneLoggedIn(){
        user_20793038_SanhuezaVega selectedUser;
        int selectedUserIsLogged;
        ArrayList<user_20793038_SanhuezaVega> userList = this.userList;

        for(int i = 0; i < userList.size(); i++){
            selectedUser = userList.get(i);
            selectedUserIsLogged = selectedUser.getIsLogged();

            if(selectedUserIsLogged == 1){
                return  true;
            }
        }
        return false;
    }

    @Override
    public void systemAddChatbot(chatbot_20793038_SanhuezaVega cb){
        ArrayList<chatbot_20793038_SanhuezaVega> cbInList = new ArrayList<>();
        cbInList.add(cb);

        filterElementsInList(cbInList);
    }

    @Override
    public void systemAddUser(user_20793038_SanhuezaVega user){
        ArrayList<user_20793038_SanhuezaVega> currentUserList = this.userList;
        if(!user.userExistsInList(currentUserList)){
            this.userList.add(user);
            System.out.println("Se ha agregado el usuario correctamente.");
        }
        else {
            System.out.println(user.getUsername() + " ya existe.");
        }
    }

    @Override
    public void systemLogin(String username){
        if(!someoneLoggedIn()){
            user_20793038_SanhuezaVega selectedUser;
            String selectedUsername;
            int userExists = 0;
            ArrayList<user_20793038_SanhuezaVega> userList = this.userList;

            for(int i = 0; i < userList.size(); i++){
                selectedUser = userList.get(i);
                selectedUsername = selectedUser.getUsername();

                if(selectedUsername.equalsIgnoreCase(username)){
                    selectedUser.login();
                    System.out.println("Se ha logueado al usuario.");
                    userExists = 1;
                }
            }

            if(userExists == 0){
                System.out.println("El usuario no existe.");
            }
        }

        else{
            System.out.println("Ya existe un usuario logueado.");
        }
    }

    @Override
    public void systemLogout(){
        if(someoneLoggedIn()){
            user_20793038_SanhuezaVega selectedUser;
            int selectedUserIsLogged;
            ArrayList<user_20793038_SanhuezaVega> userList = this.userList;

            for(int i = 0; i < userList.size(); i++){
                selectedUser = userList.get(i);
                selectedUserIsLogged = selectedUser.getIsLogged();

                if(selectedUserIsLogged == 1){
                    selectedUser.logout();
                    System.out.println("El usuario se ha deslogueado.");
                }
            }
        }

        else {
            System.out.println("No hay un usuario logueado.");
        }
    }

    @Override
    public void filterElementsInList(ArrayList<chatbot_20793038_SanhuezaVega> newCbList){
        chatbot_20793038_SanhuezaVega selectedChatbot;
        int selectedChatbotID;

        for(int i = 0; i < newCbList.size(); i++){
            selectedChatbot = newCbList.get(i);
            selectedChatbotID = selectedChatbot.getId();

            if(!idExists(selectedChatbotID)){
                this.chatbotList.add(selectedChatbot);
                // Aqui hay que poner un mensaje que se agrego algo xd
            }
            else{
                System.out.println("El chatbot con el id " + selectedChatbotID + " ya existe.");
            }
        }
    }

    @Override
    public boolean idExists(int id){
        chatbot_20793038_SanhuezaVega selectedChatbot;
        int selectedID;
        ArrayList<chatbot_20793038_SanhuezaVega> cbList = this.chatbotList;

        for(int i = 0; i < cbList.size(); i++){
            selectedChatbot = cbList.get(i);
            selectedID = selectedChatbot.getId();

            if(id == selectedID){
                return true;
            }
        }
        return false;
    }

    public chatbot_20793038_SanhuezaVega getChatbotByID(int id){
        chatbot_20793038_SanhuezaVega selectedChatbot;
        int selectedChatbotID;
        ArrayList<chatbot_20793038_SanhuezaVega> chatbotList = this.chatbotList;

        for(int i = 0; i < chatbotList.size(); i++){
            selectedChatbot = chatbotList.get(i);
            selectedChatbotID = selectedChatbot.getId();

            if(id == selectedChatbotID){
                return selectedChatbot;
            }
        }
        return null;
    }

    @Override
    public void showElements(){
        ArrayList<chatbot_20793038_SanhuezaVega> chatbotList = this.chatbotList;
        System.out.println("#### Chatbots en el sistema ####");
        for(int i = 0; i < chatbotList.size(); i++){
            System.out.println("Chatbot " + (i + 1) + ":\n" + chatbotList.get(i).toString());
        }
    }
}
