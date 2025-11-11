package model;

public class Imagen extends Contenido implements Publicable, Visualizable {
    private String resolucion;
    private String formato;

    public Imagen(int id, String titulo, String descripcion, Categoria categoria, Usuario autor, String resolucion, String formato) {
        super(id, titulo, descripcion, categoria, autor);
        this.resolucion = resolucion;
        this.formato = formato;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando imagen: " + _getTitulo() + " en formato " + formato);
    }

    @Override
    public void visualizar() {
        System.out.println("Mostrando imagen: " + _getTitulo() + " (" + resolucion + ")");
    }

    public String getResolucion() { return resolucion; }
    public String getFormato() { return formato; }
}
