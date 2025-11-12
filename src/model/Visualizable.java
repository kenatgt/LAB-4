package model;

/**
 * Interface que define el comportamiento de visualización.
 * Las clases que implementen esta interfaz deben definir
 * cómo se muestra su contenido al usuario.
 */
public interface Visualizable {
    /**
     * Devuelve una representación amigable para mostrar el contenido.
     */
    String visualizar();
}
