package model;

public class Usuario {

    private final String nombre;
    private final String email;
    private boolean sesionActiva;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String iniciarSesion() {
        if (sesionActiva) {
            return nombre + " ya tiene una sesión activa.";
        }
        sesionActiva = true;
        return nombre + " ha iniciado sesión.";
    }

    public String cerrarSesion() {
        if (!sesionActiva) {
            return nombre + " no tiene una sesión activa.";
        }
        sesionActiva = false;
        return nombre + " ha cerrado sesión.";
    }

    public String _getNombre() { return nombre; }
    public String _getEmail() { return email; }
    public boolean tieneSesionActiva() { return sesionActiva; }

    @Override
    public String toString() {
        return nombre + " (" + email + ")";
    }
}
