package model;

public class Contenido {

     // Atributos
    private int id;
    private String titulo;
    private String descripcion;
    private Categoria categoria;
    private Usuario autor;

    // Constructor 
    protected Contenido(int id, String titulo, String descripcion, Categoria categoria, Usuario autor) {
        this.id = id;
        this.titulo = (titulo);
        this.descripcion = (descripcion);
        this.categoria = categoria;
        this.autor = autor;
    }

    public void crear() { /* base mínima */ }
    public void editar() { /* base mínima */ }
    public void eliminar() { /* base mínima */ }

    // Getters y Setters 
    public int _getId() { return id; }
    public String _getTitulo() { return titulo; }
    public String _getDescripcion() { return descripcion; }
    public Categoria _getCategoria() { return categoria; }
    public Usuario _getAutor() { return autor; }
    public String _getTipoSimple() { return this.getClass().getSimpleName(); }


}


