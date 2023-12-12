package storage_20793038_SanhuezaVega;

import chatbot_20793038_SanhuezaVega.chatbot_20793038_SanhuezaVega;
import flow_20793038_SanhuezaVega.flow_20793038_SanhuezaVega;
import option_20793038_SanhuezaVega.option_20793038_SanhuezaVega;

/**
 * Interfaz del storage
 */

public interface storageInterface_20793038_SanhuezaVega {
    /**
     * Agrega un chatbot al almacen
     *
     * @param cb  chatbot a agregar
     */
    void addChatbotInStorage(chatbot_20793038_SanhuezaVega cb);

    /**
     * Agrega un flujo en el almacen
     *
     * @param fl  flujo a agregar
     */
    void addFlowInStorage(flow_20793038_SanhuezaVega fl);

    /**
     * Agrega una opcion en el almacen
     *
     * @param op  opcion a agregar
     */
    void addOptionInStorage(option_20793038_SanhuezaVega op);

    /**
     * Muestra los chatbots que estan dentro del almacen
     */
    void showChatbotsInStorage();

    /**
     * Muestra los flujos que estan dentro del almacen
     */
    void showFlowsInStorage();

    /**
     * Muestra las opciones que estan dentro del alamacen
     */
    void showOptionsInStorage();

    /**
     * Comprueba si existe el chatbot elegido
     *
     * @param choice  numero de eleccion del chatbot
     *
     * @return boolean  confirmacion si existe el chatbot
     */
    boolean chosenChatbotExists(int choice);

    /**
     * Comprueba si existe el flujo elegido
     *
     * @param choice  numero de eleccion del flujo
     *
     * @return boolean  confirmacion si existe el flujo
     */
    boolean chosenFlowExists(int choice);

    /**
     * Comprueba si existe la opcion elegida
     *
     * @param choice  numero de eleccion de la opcion
     *
     * @return boolean  confirmacion si existe la opcion
     */
    boolean chosenOptionExists(int choice);

    /**
     * Obtiene un chatbot del almacen y lo elimina
     *
     * @param choice  numero de eleccion del chatbot
     *
     * @return cb  chatbot elegido
     */
    chatbot_20793038_SanhuezaVega getChosenChatbotAndRemove(int choice);

    /**
     * Obtiene un flujo del almacen y lo elimina
     *
     * @param choice  numero de eleccion del flujo
     *
     * @return fl  flujo elegido
     */
    flow_20793038_SanhuezaVega getChosenFlowAndRemove(int choice);

    /**
     * Obtiene una opcion del almacen y la elimina
     *
     * @param choice  numero de eleccion de la opcion
     * @return op  opcion elegida
     */
    option_20793038_SanhuezaVega getChosenOptionAndRemove(int choice);
}
