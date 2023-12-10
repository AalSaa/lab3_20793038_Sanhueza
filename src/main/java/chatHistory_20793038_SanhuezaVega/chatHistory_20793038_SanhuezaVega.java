package chatHistory_20793038_SanhuezaVega;

import java.util.ArrayList;

public class chatHistory_20793038_SanhuezaVega {
    String username;
    ArrayList<String> RecordList;

    public chatHistory_20793038_SanhuezaVega(String username, ArrayList<String> recordList) {
        this.username = username;
        RecordList = recordList;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<String> getRecordList() {
        return RecordList;
    }
}
