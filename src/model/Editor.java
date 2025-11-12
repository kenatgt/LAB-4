package model;

public class Editor extends Usuario {

    // Constructor
    public Editor(String nombre, String email) {
        super(nombre, email);
    }

    // Métodos
    public String crearContenido(Contenido c) {
        if (c == null) {
            return _getNombre() + " no puede crear un contenido nulo.";
        }
        return _getNombre() + " creó el contenido: " + c._getTitulo();
    }

    public String editarContenido(Contenido c) {
        if (c == null) {
            return _getNombre() + " no puede editar un contenido nulo.";
        }
        return _getNombre() + " editó el contenido: " + c._getTitulo();
    }
}
