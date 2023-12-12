package chatbot_20793038_SanhuezaVega;

import flow_20793038_SanhuezaVega.flow_20793038_SanhuezaVega;

import java.util.ArrayList;

/**
 * Interfaz de chatbot.
 */

public interface chatbotInterface_20793038_SanhuezaVega {
    /**
     * Obtiene el id del chatbot.
     *
     * @return id  id del chatbot
     */
    int getId();

    /**
     * Obtiene la lista de flujos del chatbot.
     *
     * @return flowList lista de flujos del chatbot
     */
    ArrayList<flow_20793038_SanhuezaVega> getFlowList();

    /**
     * Obtiene un flujo que esta dentro del chatbot segun su id
     * @param id  id del flujo buscado
     * @return  flujo buscado
     */
    flow_20793038_SanhuezaVega getFlowByID(int id);

    /**
     * Obtiene un string que contiene los atributos del objeto.
     *
     * @return string  string con atributos del objeto.
     */
    String toString();

    /**
     * Agrega un flujo al chatbot
     *
     * @param fl  flujo a agregar
     */
    void chatbotAddFlow(flow_20793038_SanhuezaVega fl);

}
