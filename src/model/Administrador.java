public class Administrador extends Usuario {

    // Constructor
    public Administrador(String nombre, String email) {
        super(nombre, email);
    }

    // Métodos
    public void publicarContenido(Contenido c) {
        System.out.println("El administrador publicó el contenido: " + c._getTitulo());
    }

    public void eliminarContenido(Contenido c) {
        System.out.println("El administrador eliminó el contenido: " + c._getTitulo());
    }
}
