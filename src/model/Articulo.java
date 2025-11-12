package model;

public class Articulo extends Contenido implements Publicable, Visualizable {
    private final String texto;

    public Articulo(int id, String titulo, String descripcion, Categoria categoria, Usuario autor, String texto) {
        super(id, titulo, descripcion, categoria, autor);
        this.texto = texto;
    }

    @Override
    public String publicar() {
        marcarComoPublicado();
        return "Artículo publicado: " + _getTitulo();
    }

    @Override
    public String visualizar() {
        return "Leyendo artículo: " + _getTitulo() + System.lineSeparator() + texto;
    }

    public String getTexto() { return texto; }
}
