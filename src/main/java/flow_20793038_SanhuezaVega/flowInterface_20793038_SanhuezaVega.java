package flow_20793038_SanhuezaVega;

import option_20793038_SanhuezaVega.option_20793038_SanhuezaVega;

import java.util.ArrayList;

/**
 * Interfaz de flow.
 */

public interface flowInterface_20793038_SanhuezaVega {
    /**
     * Obtiene el id del flujo.
     *
     * @return id  id del flujo
     */
    int getId();

    /**
     * Obtiene un string que contiene los atributos del objeto.
     *
     * @return string  string con atributos del objeto.
     */
    String toString();

    /**
     * Agrega una opcion a la lista de opciones del flujo.
     *
     * @param op  opcion
     */
    void flowAddOption(option_20793038_SanhuezaVega op);
}
