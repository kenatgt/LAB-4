package model;

public class Articulo extends Contenido implements Publicable, Visualizable {
    private String texto;

    public Articulo(int id, String titulo, String descripcion, Categoria categoria, Usuario autor, String texto) {
        super(id, titulo, descripcion, categoria, autor);
        this.texto = texto;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando artículo: " + _getTitulo());
    }

    @Override
    public void visualizar() {
        System.out.println("Leyendo artículo: " + _getTitulo());
        System.out.println(texto);
    }

    public String getTexto() {
        return texto;
    }
}
