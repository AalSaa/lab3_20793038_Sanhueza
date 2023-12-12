package chatbot_20793038_SanhuezaVega;

import java.util.ArrayList;

import Tools.toolsInterface_20793038_SanhuezaVega;
import flow_20793038_SanhuezaVega.flow_20793038_SanhuezaVega;

public class chatbot_20793038_SanhuezaVega implements chatbotInterface_20793038_SanhuezaVega
                                                    , toolsInterface_20793038_SanhuezaVega<flow_20793038_SanhuezaVega>{
    /**
     * El id del chatbot.
     */
    int id;

    /**
     * El nombre del chatbot.
     */
    String name;

    /**
     * El mensaje de bienvenida del chatbot.
     */
    String welcomeMessage;

    /**
     * El codigo del flujo inicial asociado al chatbot.
     */
    int startFCodelink;

    /**
     * La lista de flujos del chatbot.
     */
    ArrayList<flow_20793038_SanhuezaVega> flowList;

    /**
     * Constructor de un chatbot
     *
     * @param id  id del chatbot
     * @param name  nombre del chatbot
     * @param welcomeMessage  mensaje de bienvenida del chatbot.
     * @param startFCodelink  codigo del flujo inicial del chatbot.
     * @param flowList  lista de opciones del chatbot.
     */
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
    public ArrayList<flow_20793038_SanhuezaVega> getFlowList() {
        return flowList;
    }

    public flow_20793038_SanhuezaVega getFlowByID(int id){
        flow_20793038_SanhuezaVega selectedFlow;
        int selectedFlowID;
        ArrayList<flow_20793038_SanhuezaVega> flowList = this.flowList;

        for(int i = 0; i < flowList.size(); i++){
            selectedFlow = flowList.get(i);
            selectedFlowID = selectedFlow.getId();

            if(id == selectedFlowID){
                return selectedFlow;
            }
        }
        return null;
    }

    @Override
    public void showElements(){
        ArrayList<flow_20793038_SanhuezaVega> flowList = this.flowList;

        System.out.println("#### Flujos en el chatbot ####");
        for(int i = 0; i < flowList.size(); i++){
            System.out.println("Flujo " + (i + 1) + ":\n" + flowList.get(i).toString());
        }
    }

    @Override
    public void chatbotAddFlow(flow_20793038_SanhuezaVega fl){
        ArrayList<flow_20793038_SanhuezaVega> flInList = new ArrayList<>();
        flInList.add(fl);

        filterElementsInList(flInList);
    }

    public String toString() {
        return  "id: " + id +
                ", name: '" + name + '\'' +
                ", welcomeMessage: '" + welcomeMessage + '\'' +
                ", startFCodelink: " + startFCodelink;
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
                System.out.println("Se ha agregado el flujo al chatbot.");
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
