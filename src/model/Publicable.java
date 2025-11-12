package model;
/**
 * Interface que define el comportamiento de publicación.
 * Las clases que implementen esta interfaz deben definir
 * cómo se publica su contenido.
 */
public interface Publicable {
    /**
     * Indica el resultado de publicar el contenido.
     */
    String publicar();
}
