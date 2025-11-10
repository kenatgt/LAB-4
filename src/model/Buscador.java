


import java.util.*;
import java.util.stream.Collectors;


public class Buscador {

    private final Collection<Contenido> fuente;

    // Constructor
    public Buscador(Collection<Contenido> fuente) {
        this.fuente = Objects.requireNonNull(fuente);
    }

    // métodos
    public List<Contenido> buscarPorTipo(String tipo) {
        if (tipo == null) return List.of();
        String t = tipo.trim().toLowerCase();
        return fuente.stream()
                .filter(c -> c._getTipoSimple().toLowerCase().equals(t))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Contenido> buscarPorCategoria(Categoria cat) {
        if (cat == null) return List.of();
        return fuente.stream()
                .filter(c -> Objects.equals(c._getCategoria(), cat))
                .collect(Collectors.toUnmodifiableList());
    }
}
