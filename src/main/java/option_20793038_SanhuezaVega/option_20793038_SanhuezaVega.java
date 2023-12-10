package option_20793038_SanhuezaVega;

import java.util.ArrayList;

public class option_20793038_SanhuezaVega implements optionInterface_20793038_SanhuezaVega{
    private int id;
    private String message;
    private int cbCodelink;
    private int fCodelink;
    private ArrayList<String> keyword;

    public option_20793038_SanhuezaVega(int id, String message, int cbCodelink, int fCodelink, ArrayList<String> keyword) {
        this.id = id;
        this.message = message;
        this.cbCodelink = cbCodelink;
        this.fCodelink = fCodelink;
        this.keyword = keyword;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getCbCodelink() {
        return cbCodelink;
    }

    @Override
    public int getfCodelink() {
        return fCodelink;
    }

    @Override
    public ArrayList<String> getKeyword() {
        return keyword;
    }
}
