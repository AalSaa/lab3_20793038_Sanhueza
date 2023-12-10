package chatbot_20793038_SanhuezaVega;

import java.util.ArrayList;

import Tools.toolsInterface_20793038_SanhuezaVega;
import flow_20793038_SanhuezaVega.flow_20793038_SanhuezaVega;

public class chatbot_20793038_SanhuezaVega implements chatbotInterface_20793038_SanhuezaVega,
                                                      toolsInterface_20793038_SanhuezaVega<flow_20793038_SanhuezaVega>{
    int id;
    String name;
    String welcomeMessage;
    int startFCodelink;
    ArrayList<flow_20793038_SanhuezaVega> flowList;

    public chatbot_20793038_SanhuezaVega(int id, String name, String welcomeMessage,
                                         int startFCodelink, ArrayList<flow_20793038_SanhuezaVega> flowList) {
        this.id = id;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFCodelink = startFCodelink;
        this.flowList = new ArrayList<>();

        filterElementsInList(flowList);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    @Override
    public int getStartFCodelink() {
        return startFCodelink;
    }

    @Override
    public ArrayList<flow_20793038_SanhuezaVega> getFlowList() {
        return flowList;
    }

    @Override
    public void chatbotAddFlow(flow_20793038_SanhuezaVega fl){
        ArrayList<flow_20793038_SanhuezaVega> flInList = new ArrayList<>();
        flInList.add(fl);

        filterElementsInList(flInList);
    }

    @Override
    public void filterElementsInList(ArrayList<flow_20793038_SanhuezaVega> newFlList) {
        flow_20793038_SanhuezaVega selectedFlow;
        int selectedFlowID;

        for(int i = 0; i < newFlList.size(); i++){
            selectedFlow = newFlList.get(i);
            selectedFlowID = selectedFlow.getId();

            if(!idExists(selectedFlowID)) {
                this.flowList.add(selectedFlow);
                // Aqui hay que poner un mensaje que se agrego algo xd
            }
            else {
                System.out.println("El flujo con el id " + selectedFlowID + " ya existe.");
            }
        }
    }

    @Override
    public boolean idExists(int id) {
        flow_20793038_SanhuezaVega selectedFlow;
        int selectedID;
        ArrayList<flow_20793038_SanhuezaVega> fList = this.flowList;

        for(int i = 0; i < fList.size(); i++) {
            selectedFlow = fList.get(i);
            selectedID = selectedFlow.getId();

            if(id == selectedID) {
                return true;
            }
        }
        return false;
    }
}
