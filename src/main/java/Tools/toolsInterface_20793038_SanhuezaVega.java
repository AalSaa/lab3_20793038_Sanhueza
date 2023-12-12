package Tools;

import java.util.ArrayList;

/**
 * Interface de tools
 * @param <Element> clase relacionada a las opreaciones
 */

public interface toolsInterface_20793038_SanhuezaVega<Element> {
    /**
     * filtra y agrega los elementos de una lista al momento de traspasar su contenido a otra
     *
     * @param elementList  lista de elementos a filtrar
     */
    void filterElementsInList(ArrayList<Element> elementList);

    /**
     * Verifica si ya existe un elemento con ese id en una lista de elementos
     * @param id  id a verificar si existe
     * @return boolean  confirmacion si existe el id
     */
    boolean idExists(int id);

    /**
     * Muestra los elementos que estan contenidos en una lista la cual es un atributo del objeto actual
     */
    void showElements();
}
