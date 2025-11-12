package model;

import java.util.Objects;

public class Contenido {

    public enum Estado {
        BORRADOR,
        PUBLICADO,
        ELIMINADO
    }

    private final int id;
    private String titulo;
    private String descripcion;
    private final Categoria categoria;
    private final Usuario autor;
    private Estado estado = Estado.BORRADOR;

    protected Contenido(int id, String titulo, String descripcion, Categoria categoria, Usuario autor) {
        this.id = id;
        this.titulo = Objects.requireNonNull(titulo, "El título no puede ser nulo").trim();
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción no puede ser nula").trim();
        this.categoria = Objects.requireNonNull(categoria, "La categoría no puede ser nula");
        this.autor = Objects.requireNonNull(autor, "El autor no puede ser nulo");
        this.categoria.asignarContenido(this);
    }

    public void crear() {
        if (estado != Estado.ELIMINADO) {
            estado = Estado.BORRADOR;
        }
    }

    public void editar() {
        if (estado != Estado.ELIMINADO) {
            estado = Estado.BORRADOR;
        }
    }

    public void eliminar() {
        estado = Estado.ELIMINADO;
    }

    protected void marcarComoPublicado() {
        if (estado != Estado.ELIMINADO) {
            estado = Estado.PUBLICADO;
        }
    }

    public int _getId() { return id; }
    public String _getTitulo() { return titulo; }
    public String _getDescripcion() { return descripcion; }
    public Categoria _getCategoria() { return categoria; }
    public Usuario _getAutor() { return autor; }
    public String _getTipoSimple() { return this.getClass().getSimpleName(); }
    public Estado _getEstado() { return estado; }
}

