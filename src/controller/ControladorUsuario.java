package controller;

import model.Usuario;

/**
 * Controlador encargado de gestionar las acciones de los usuarios:
 * inicio/cierre de sesión y permisos básicos.
 */
public class ControladorUsuario {

    private Usuario usuarioActivo;

    public void login(Usuario usuario) {
        usuario.iniciarSesion();
        usuarioActivo = usuario;
    }

    public void logout() {
        if (usuarioActivo != null) {
            usuarioActivo.cerrarSesion();
            usuarioActivo = null;
        } else {
            System.out.println("No hay sesión activa.");
        }
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }
}
