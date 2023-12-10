package flow_20793038_SanhuezaVega;

import java.util.ArrayList;

import Tools.toolsInterface_20793038_SanhuezaVega;
import option_20793038_SanhuezaVega.option_20793038_SanhuezaVega;

public class flow_20793038_SanhuezaVega implements flowInterface_20793038_SanhuezaVega,
                                                   toolsInterface_20793038_SanhuezaVega<option_20793038_SanhuezaVega>{
    int id;
    String nameMSG;
    ArrayList<option_20793038_SanhuezaVega> optionList;

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
    public String getNameMSG() {
        return nameMSG;
    }

    @Override
    public ArrayList<option_20793038_SanhuezaVega> getOptionList() {
        return optionList;
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
                // Aqui hay que poner un mensaje que se agrego algo xd
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
}




