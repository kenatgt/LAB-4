package controller;

import model.Usuario;

/**
 * Controlador encargado de gestionar las acciones de los usuarios:
 * inicio/cierre de sesión y permisos básicos.
 */
public class ControladorUsuario {

    private Usuario usuarioActivo;

    public String login(Usuario usuario) {
        if (usuario == null) {
            return "No se puede iniciar sesión sin un usuario.";
        }
        usuarioActivo = usuario;
        return usuario.iniciarSesion();
    }

    public String logout() {
        if (usuarioActivo == null) {
            return "No hay sesión activa.";
        }
        String mensaje = usuarioActivo.cerrarSesion();
        usuarioActivo = null;
        return mensaje;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }
}
