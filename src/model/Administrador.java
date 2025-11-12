package model;

public class Administrador extends Usuario {

    // Constructor
    public Administrador(String nombre, String email) {
        super(nombre, email);
    }

    // Métodos
    public String publicarContenido(Contenido c) {
        if (c == null) {
            return _getNombre() + " no puede publicar un contenido nulo.";
        }
        return _getNombre() + " publicó el contenido: " + c._getTitulo();
    }

    public String eliminarContenido(Contenido c) {
        if (c == null) {
            return _getNombre() + " no puede eliminar un contenido nulo.";
        }
        return _getNombre() + " eliminó el contenido: " + c._getTitulo();
    }
}
