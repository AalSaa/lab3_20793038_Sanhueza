package ChatHistory;

import java.util.ArrayList;

public class ChatHistory {
    String username;
    ArrayList<String> RecordList;

    public ChatHistory(String username, ArrayList<String> recordList) {
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
