package flow_20793038_SanhuezaVega;

import java.util.ArrayList;

import Tools.toolsInterface_20793038_SanhuezaVega;
import option_20793038_SanhuezaVega.option_20793038_SanhuezaVega;

public class flow_20793038_SanhuezaVega implements flowInterface_20793038_SanhuezaVega
                                                 , toolsInterface_20793038_SanhuezaVega<option_20793038_SanhuezaVega>{
    /**
     * El id del flujo.
     */
    int id;

    /**
     *  El nombre del mensaje del flujo.
     */
    String nameMSG;

    /**
     * La lista de opciones del flujo.
     */
    ArrayList<option_20793038_SanhuezaVega> optionList;

    /**
     * Constructor de flow
     *
     * @param id  id del flujo
     * @param nameMSG  nombre del mensaje del flujo
     * @param optionList  lista de opciones del flujo
     */
    public flow_20793038_SanhuezaVega(int id, String nameMSG, ArrayList<option_20793038_SanhuezaVega> optionList) {
        this.id = id;
        this.nameMSG = nameMSG;
        this.optionList = new ArrayList<>();
        filterElementsInList(optionList);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", nameMSG: '" + nameMSG + '\'';
    }

    @Override
    public void flowAddOption(option_20793038_SanhuezaVega op) {
        ArrayList<option_20793038_SanhuezaVega> opInList = new ArrayList<>();
        opInList.add(op);

        filterElementsInList(opInList);
    }

    @Override
    public void filterElementsInList(ArrayList<option_20793038_SanhuezaVega> newOpList) {
        option_20793038_SanhuezaVega selectedOption;
        int selectedOptionID;

        for(int i = 0; i < newOpList.size(); i++){
            selectedOption = newOpList.get(i);
            selectedOptionID = selectedOption.getId();

            if(!idExists(selectedOptionID)) {
                this.optionList.add(selectedOption);
                System.out.println("Se ha agregado la opcion al flujo.");
            }
            else {
                System.out.println("La opcion con el id " + selectedOptionID + " ya existe.");
            }
        }
    }

    @Override
    public boolean idExists(int id) {
        option_20793038_SanhuezaVega selectedOption;
        int selectedID;
        ArrayList<option_20793038_SanhuezaVega> opList = this.optionList;

        for(int i = 0; i < opList.size(); i++) {
            selectedOption = opList.get(i);
            selectedID = selectedOption.getId();

            if(id == selectedID) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showElements(){
        ArrayList<option_20793038_SanhuezaVega> optionList = this.optionList;

        System.out.println("#### Opciones en el flujo ####");
        for(int i = 0; i < optionList.size(); i++){
            System.out.println("Opcion " + (i + 1) + ":\n" + optionList.get(i).toString());
        }
    }
}




