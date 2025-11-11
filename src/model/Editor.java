package model;

public class Editor extends Usuario {

    // Constructor
    public Editor(String nombre, String email) {
        super(nombre, email);
    }

    // Métodos
    public void crearContenido(Contenido c) {
        System.out.println("El editor creó el contenido: " + c._getTitulo());
    }

    public void editarContenido(Contenido c) {
        System.out.println("El editor editó el contenido: " + c._getTitulo());
    }
}
