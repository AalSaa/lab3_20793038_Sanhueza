package Option;

import java.util.ArrayList;

public class Option {
    private int id;
    private String message;
    private int cbCodelink;
    private int fCodelink;
    private ArrayList<String> keyword;

    public Option(int id, String message, int cbCodelink, int fCodelink, ArrayList<String> keyword) {
        this.id = id;
        this.message = message;
        this.cbCodelink = cbCodelink;
        this.fCodelink = fCodelink;
        this.keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getCbCodelink() {
        return cbCodelink;
    }

    public int getfCodelink() {
        return fCodelink;
    }

    public ArrayList<String> getKeyword() {
        return keyword;
    }
}
