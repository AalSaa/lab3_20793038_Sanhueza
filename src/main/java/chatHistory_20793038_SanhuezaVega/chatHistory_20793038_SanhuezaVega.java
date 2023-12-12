package chatHistory_20793038_SanhuezaVega;

import java.util.ArrayList;

public class chatHistory_20793038_SanhuezaVega implements chatHistoryInterface_20793038_SanhuezaVega{
    /**
     * El nombre del usuario propietario de los registros
     */
    String username;
    /**
     * La lista de registros
     */
    ArrayList<String> RecordList;

    /**
     * Constructor de chatHistory
     *
     * @param username  usuario propietario de los registros
     * @param recordList  lista de registros
     */
    public chatHistory_20793038_SanhuezaVega(String username, ArrayList<String> recordList) {
        this.username = username;
        RecordList = recordList;
    }
}
