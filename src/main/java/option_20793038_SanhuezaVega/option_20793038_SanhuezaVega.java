package option_20793038_SanhuezaVega;

import java.util.ArrayList;

public class option_20793038_SanhuezaVega implements optionInterface_20793038_SanhuezaVega{

    /**
     * El id de la opcion.
     */
    private int id;

    /**
     * El mensaje de la opcion.
     */
    private String message;

    /**
     * El codelink del chatbot asociado a la opcion.
     */
    private int cbCodelink;

    /**
     * El codelink del flujo asociado a la opcion.
     */
    private int fCodelink;

    /**
     * La lista de palabras claves de la opcion.
     */
    private ArrayList<String> keyword;

    /**
     * Constructor de option
     *
     * @param id  id de la opcion
     * @param message  mensaje de la opcion
     * @param cbCodelink  codigo del chatbot asociado a la opcion
     * @param fCodelink  codigo del flujo asociado a la opcion
     * @param keyword  lista de palabras clabes
     */
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
    public String toString() {
        return "id: " + id +
                ", message: '" + message + '\'' +
                ", cbCodelink: " + cbCodelink +
                ", fCodelink: " + fCodelink;
    }
}
