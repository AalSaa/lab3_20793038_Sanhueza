package Flow;

import java.util.ArrayList;

import Option.Option;

public class Flow {
    int id;
    String nameMSG;
    ArrayList<Option> optionList;

    public Flow(int id, String nameMSG, ArrayList<Option> optionList) {
        this.id = id;
        this.nameMSG = nameMSG;
        this.optionList = optionList;
    }

    public int getId() {
        return id;
    }

    public String getNameMSG() {
        return nameMSG;
    }

    public ArrayList<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(ArrayList<Option> optionList) {
        this.optionList = optionList;
    }

    public void flowAddOption(Option op){
        int optionID = op.getId();
        if (!idExists(optionID)){
            this.optionList.add(op);
            System.out.println("Se ha agregado la opcion al flujo.");
        }
        else {
            System.out.println("Ya existe una opcion con el id " + optionID + " en el flujo.");
        }
    }

    public boolean idExists(int id){
        Option selectedOption;
        int selectedID;
        ArrayList<Option> optionList = this.optionList;
        for (int i = 0; i < optionList.size(); i++){
            selectedOption = optionList.get(i);
            selectedID = selectedOption.getId();
            if (selectedID == id) {
                return true;
            }
        }
        return false;
    }
}
