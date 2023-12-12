package storage_20793038_SanhuezaVega;

import java.util.ArrayList;

import chatbot_20793038_SanhuezaVega.chatbot_20793038_SanhuezaVega;
import flow_20793038_SanhuezaVega.flow_20793038_SanhuezaVega;
import option_20793038_SanhuezaVega.option_20793038_SanhuezaVega;
public class storage_20793038_SanhuezaVega implements storageInterface_20793038_SanhuezaVega{
    /**
     * Lista de chatbots del almacen
     */
    ArrayList<chatbot_20793038_SanhuezaVega> chatbotStorage;

    /**
     * Lista de flujos del alamacen
     */
    ArrayList<flow_20793038_SanhuezaVega> flowStorage;

    /**
     * Lista de opciones del almacen
     */
    ArrayList<option_20793038_SanhuezaVega> optionStorage;

    /**
     * Constructor del almacen
     */
    public storage_20793038_SanhuezaVega() {
        this.chatbotStorage = new ArrayList<>();
        this.flowStorage = new ArrayList<>();
        this.optionStorage = new ArrayList<>();
    }

    public ArrayList<chatbot_20793038_SanhuezaVega> getChatbotStorage() {
        return chatbotStorage;
    }

    public ArrayList<flow_20793038_SanhuezaVega> getFlowStorage() {
        return flowStorage;
    }

    public ArrayList<option_20793038_SanhuezaVega> getOptionStorage() {
        return optionStorage;
    }

    @Override
    public void addChatbotInStorage(chatbot_20793038_SanhuezaVega cb){
        this.chatbotStorage.add(cb);
        System.out.println("Se ha enviado el chatbot al storage.");
    }

    @Override
    public void addFlowInStorage(flow_20793038_SanhuezaVega fl){
        this.flowStorage.add(fl);
        System.out.println("Se ha enviado el flujo al storage.");
    }

    @Override
    public void addOptionInStorage(option_20793038_SanhuezaVega op){
        this.optionStorage.add(op);
        System.out.println("Se ha enviado la opcion al storage.");
    }

    @Override
    public void showChatbotsInStorage(){
        ArrayList<chatbot_20793038_SanhuezaVega> chatbotStorage = this.chatbotStorage;

        System.out.println("#### Chatbots en el storage #####");
        for(int i = 0; i < chatbotStorage.size(); i++){
            System.out.println("Chatbot " + (i + 1) + ":\n" + chatbotStorage.get(i).toString());
        }
    }

    @Override
    public void showFlowsInStorage(){
        ArrayList<flow_20793038_SanhuezaVega> flowStorage = this.flowStorage;

        System.out.println("#### Flujos en el storage ####");
        for(int i = 0; i < flowStorage.size(); i++){
            System.out.println("Flujo " + (i + 1) + ":\n" + flowStorage.get(i).toString());
        }
    }

    @Override
    public void showOptionsInStorage(){
        ArrayList<option_20793038_SanhuezaVega> optionStorage = this.optionStorage;

        System.out.println("#### Opciones en el storage ####");
        for (int i = 0; i < optionStorage.size(); i++){
            System.out.println("Opcion " + (i + 1) + ":\n" + optionStorage.get(i).toString());
        }
    }

    @Override
    public boolean chosenChatbotExists(int choice){
        choice--;
        ArrayList<chatbot_20793038_SanhuezaVega> chatbotStorage = this.chatbotStorage;

        if(choice >= 0 && choice < chatbotStorage.size()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean chosenFlowExists(int choice){
        choice--;
        ArrayList<flow_20793038_SanhuezaVega> flowStorage = this.flowStorage;

        if(choice >= 0 && choice < flowStorage.size()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean chosenOptionExists(int choice){
        choice--;
        ArrayList<option_20793038_SanhuezaVega> optionStorage = this.optionStorage;

        if(choice >= 0 && choice < optionStorage.size()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public chatbot_20793038_SanhuezaVega getChosenChatbotAndRemove(int choice){
        choice--;
        ArrayList<chatbot_20793038_SanhuezaVega> chatbotStorage = this.chatbotStorage;

        chatbot_20793038_SanhuezaVega chosenChatbot = chatbotStorage.get(choice);
        chatbotStorage.remove(choice);

        return chosenChatbot;
    }

    @Override
    public flow_20793038_SanhuezaVega getChosenFlowAndRemove(int choice){
        choice--;
        ArrayList<flow_20793038_SanhuezaVega> flowStorage = this.flowStorage;

        flow_20793038_SanhuezaVega chosenFlow = flowStorage.get(choice);
        flowStorage.remove(choice);

        return chosenFlow;
    }

    @Override
    public option_20793038_SanhuezaVega getChosenOptionAndRemove(int choice){
        choice--;
        ArrayList<option_20793038_SanhuezaVega> optionStorage = this.optionStorage;

        option_20793038_SanhuezaVega chosenOption = optionStorage.get(choice);
        optionStorage.remove(choice);

        return chosenOption;
    }
}
