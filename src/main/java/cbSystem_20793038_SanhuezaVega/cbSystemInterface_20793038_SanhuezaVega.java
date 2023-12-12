package cbSystem_20793038_SanhuezaVega;

import chatbot_20793038_SanhuezaVega.chatbot_20793038_SanhuezaVega;
import storage_20793038_SanhuezaVega.storage_20793038_SanhuezaVega;
import user_20793038_SanhuezaVega.user_20793038_SanhuezaVega;

import java.util.ArrayList;

/**
 * Interfaz del chatbot System
 */

public interface cbSystemInterface_20793038_SanhuezaVega {
    /**
     * Obtiene la lista de chatbots del sistema
     *
     * @return chatbotList lista de chatbots del sistema
     */
    ArrayList<chatbot_20793038_SanhuezaVega> getChatbotList();

    /**
     * Obtiene el almacenamieto de objetos del sistema
     *
     * @return  systemStorage  almacenamiento de objetos del sistema
     */
    storage_20793038_SanhuezaVega getSystemStorage();

    /**
     * Obtiene al usuario logueado en el sistema
     *
     * @return loggedUser  usuario logueado en el sistema
     */
    user_20793038_SanhuezaVega getLoggedUser();

    /**
     * revisa si alguien esta logueado en el sistema
     *
     * @return boolean  confirmador de si alguien esta logueado en el sistema
     */
    boolean someoneLoggedIn();

    /**
     * Obtiene un chatbot del sistema segun su id
     *
     * @param id  id del chatbot a buscar
     * @return cb  chatbot a buscar
     */
    chatbot_20793038_SanhuezaVega getChatbotByID(int id);

    /**
     * Agrega un chatbot al sistema
     *
     * @param cb  chatbot a agregar
     */
    void systemAddChatbot(chatbot_20793038_SanhuezaVega cb);

    /**
     * Agrega un usuario al sistema
     *
     * @param user  usuario a agregar
     */
    void systemAddUser(user_20793038_SanhuezaVega user);

    /**
     * Loguea a un usuario en el sistema
     *
     * @param username  nombre del usuario a loguear
     */
    void systemLogin(String username);

    /**
     * Desloguea al usuario logueado en el sistema
     */
    void systemLogout();
}
