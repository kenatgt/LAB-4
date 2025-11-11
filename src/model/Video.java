package model;

public class Video extends Contenido implements Contenido.Publicable, Contenido.Visualizable {

    // Atributos
    private String url;
    private float duracion;

    // Constructor  
    public Video(int id, String titulo, String descripcion, Categoria categoria, Usuario autor,
                 String url, float duracion) {
        super(id, titulo, descripcion, categoria, autor);
        this.url = url;
        this.duracion = Math.max(0f, duracion);
    }

     // Métodos (UML)
    @Override public void publicar()   { /* lógica propia */ }
    @Override public void visualizar() { /* preparar datos para vista */ }
}


