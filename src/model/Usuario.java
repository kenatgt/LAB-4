package model;

public class Usuario {

    // Atributos
    private String nombre;
    private String email;

    // Constructor
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Métodos
    public void iniciarSesion() {
        System.out.println(nombre + " ha iniciado sesión.");
    }

    public void cerrarSesion() {
        System.out.println(nombre + " ha cerrado sesión.");
    }

    // Getters
    public String _getNombre() { return nombre; }
    public String _getEmail() { return email; }

    @Override
    public String toString() {
        return nombre + " (" + email + ")";
    }
}
