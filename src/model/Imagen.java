



public class Imagen extends Contenido implements Contenido.Publicable, Contenido.Visualizable {

    // Atributos (UML)
    private String resolucion;
    private String formato;

    public Imagen(int id, String titulo, String descripcion, Categoria categoria, Usuario autor,
                  String resolucion, String formato) {
        super(id, titulo, descripcion, categoria, autor);
        this.resolucion = resolucion;
        this.formato = formato;
    }

    // Métodos (UML)
    @Override public void publicar()   { /* lógica propia */ }
    @Override public void visualizar() { /* preparar datos para vista */ }
}