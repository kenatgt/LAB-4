

public class Articulo extends Contenido implements Contenido.Publicable, Contenido.Visualizable {
    // Atributos 
    private String texto;

    // Constructor
    public Articulo(int id, String titulo, String descripcion, Categoria categoria, Usuario autor, String texto) {
        super(id, titulo, descripcion, categoria, autor);
        this.texto = (texto);
    }

    // Métodos
    @Override public void publicar()   { /* lógica propia */ }
    @Override public void visualizar() { /* preparar datos para vista */ }
    
}
