package user_20793038_SanhuezaVega;

import java.util.ArrayList;

/**
 * Interfaz de user
 */

public interface userInterface_20793038_SanhuezaVega {
    /**
     * Obtiene el nombre del usuario
     *
     * @return username  nombre del usuario
     */
    String getUsername();

    /**
     * Obtiene el vericador de si esta logueado el usuario
     *
     * @return isLogged  vericador de si esta logueado el usuario
     */
    int getIsLogged();

    /**
     * Comprueba si el usuario existe dentro de una lista de usuarios
     *
     * @param userList  lista de usuarios
     * @return boolean  verificador de si existe el usuario
     */
    boolean userExistsInList(ArrayList<user_20793038_SanhuezaVega> userList);

    /**
     * Loguea al usuario
     */
    void login();

    /**
     * Desloguea al usuario
     */
    void logout();
}
