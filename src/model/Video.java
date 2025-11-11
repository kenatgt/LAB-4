package model;

public class Video extends Contenido implements Publicable, Visualizable {

    // Atributos
    private String url;
    private int duracion;

    // Constructor
    public Video(int id, String titulo, String descripcion, Categoria categoria, Usuario autor, String url, int duracion) {
        super(id, titulo, descripcion, categoria, autor);
        this.url = url;
        this.duracion = duracion;
    }

    // Implementaciones de las interfaces
    @Override
    public void publicar() {
        System.out.println("Publicando video: " + _getTitulo() + " en " + url);
    }

    @Override
    public void visualizar() {
        System.out.println("Reproduciendo video: " + _getTitulo() + " (" + duracion + " segundos)");
    }

    // Getters
    public String getUrl() { return url; }
    public int getDuracion() { return duracion; }
}
