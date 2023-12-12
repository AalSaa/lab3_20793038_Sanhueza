package cbSystem_20793038_SanhuezaVega;

import java.util.ArrayList;
import java.util.Date;

import Tools.toolsInterface_20793038_SanhuezaVega;
import chatbot_20793038_SanhuezaVega.chatbot_20793038_SanhuezaVega;
import user_20793038_SanhuezaVega.user_20793038_SanhuezaVega;
import chatHistory_20793038_SanhuezaVega.chatHistory_20793038_SanhuezaVega;
import storage_20793038_SanhuezaVega.storage_20793038_SanhuezaVega;

public class cbSystem_20793038_SanhuezaVega implements cbSystemInterface_20793038_SanhuezaVega
                                                     , toolsInterface_20793038_SanhuezaVega<chatbot_20793038_SanhuezaVega>{
    /**
     *  La fecha de creacion del sistema,
     */
    Date date;

    /**
     * El nombre del sistema.
     */
    String name;

    /**
     * La lista de usuarios del sistema.
     */
    ArrayList<user_20793038_SanhuezaVega> userList;

    /**
     * La lista de registros del sistema.
     */
    ArrayList<chatHistory_20793038_SanhuezaVega> chatHistory;

    /**
     * El codigo del chatbot inicial del sistema.
     */
    int startCBCodelink;

    /**
     * La lista de chatbots del sistema.
     */
    ArrayList<chatbot_20793038_SanhuezaVega> chatbotList;

    /**
     * El almacenamiento de objetos del sistema.
     */
    storage_20793038_SanhuezaVega systemStorage;

    /**
     * Constructor del chatbotSystem
     *
     * @param name  nombre del sistema
     * @param startCBCodelink  codigo del chatbot inicial del sistema
     * @param chatbotList lista de chatbots del sistema
     */
    public cbSystem_20793038_SanhuezaVega(String name, int startCBCodelink,
                                          ArrayList<chatbot_20793038_SanhuezaVega> chatbotList) {
        this.date = new Date();
        this.name = name;
        this.userList = new ArrayList<>();
        this.chatHistory = new ArrayList<>();
        this.startCBCodelink = startCBCodelink;
        this.chatbotList = new ArrayList<>();
        this.systemStorage = new storage_20793038_SanhuezaVega();

        filterElementsInList(chatbotList);
    }

    public ArrayList<chatbot_20793038_SanhuezaVega> getChatbotList() {
        return chatbotList;
    }

    public storage_20793038_SanhuezaVega getSystemStorage() {
        return systemStorage;
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
                System.out.println("Se ha agregado el chatbot al sistema.");
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

    @Override
    public void showElements(){
        ArrayList<chatbot_20793038_SanhuezaVega> chatbotList = this.chatbotList;
        System.out.println("#### Chatbots en el sistema ####");
        for(int i = 0; i < chatbotList.size(); i++){
            System.out.println("Chatbot " + (i + 1) + ":\n" + chatbotList.get(i).toString());
        }
    }
}
