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
    public String publicar() {
        marcarComoPublicado();
        return "Video publicado: " + _getTitulo() + " en " + url;
    }

    @Override
    public String visualizar() {
        return "Reproduciendo video: " + _getTitulo() + " (" + duracion + " segundos)";
    }

    // Getters
    public String getUrl() { return url; }
    public int getDuracion() { return duracion; }
}
