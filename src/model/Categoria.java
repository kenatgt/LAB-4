


import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria {

    // Atributos 
    private String nombre;
    private String descripcion;
    private final Set<Contenido> contenidos = new LinkedHashSet<>();

    public Categoria(String nombre, String descripcion) {
        this.nombre = Objects.requireNonNull(nombre).trim(); // Evitar null y espacios innecesarios
        this.descripcion = descripcion;
    }

    // Método 
    public void asignarContenido(Contenido c) {
        if (c == null) return;
        contenidos.add(c);
    }

    Set<Contenido> _getContenidos() { return Set.copyOf(contenidos); }
}
