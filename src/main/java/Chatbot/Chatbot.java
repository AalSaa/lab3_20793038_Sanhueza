package Chatbot;

import java.util.ArrayList;

import Flow.Flow;

public class Chatbot{
    int id;
    String name;
    String welcomeMessage;
    int startFCodelink;
    ArrayList<Flow> flowList;

    public Chatbot(int id, String name, String welcomeMessage, int startFCodelink, ArrayList<Flow> flowList) {
        this.id = id;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFCodelink = startFCodelink;
        this.flowList = flowList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public int getStartFCodelink() {
        return startFCodelink;
    }

    public ArrayList<Flow> getFlowList() {
        return flowList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void setStartFCodelink(int startFCodelink) {
        this.startFCodelink = startFCodelink;
    }

    public void setFlowList(ArrayList<Flow> flowList) {
        this.flowList = flowList;
    }

    public void chatbotAddFlow(Flow fl){
        int flowID = fl.getId();
        if (!idExists(flowID)){
            this.flowList.add(fl);
            System.out.println("Se ha agregado el flujo al chatbot.");
        }
        else {
            System.out.println("Ya existe un flujo con el id " + flowID + " en el chatbot.");
        }
    }

    public boolean idExists(int id){
        Flow selectedFlow;
        int selectedID;
        ArrayList<Flow> flowList = this.flowList;
        for (int i = 0; i < flowList.size(); i++){
            selectedFlow = flowList.get(i);
            selectedID = selectedFlow.getId();
            if (selectedID == id){
                return true;
            }
        }
        return false;
    }
}
