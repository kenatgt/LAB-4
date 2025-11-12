package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Buscador {

    private final Collection<Contenido> fuente;

    // Constructor
    public Buscador(Collection<Contenido> fuente) {
        this.fuente = Objects.requireNonNull(fuente);
    }

    // métodos
    public List<Contenido> buscarPorTipo(String tipo) {
        if (fuente.isEmpty()) {
            return List.of();
        }
        if (tipo == null || tipo.isBlank()) {
            return new ArrayList<>(fuente);
        }
        String t = tipo.trim().toLowerCase();
        return fuente.stream()
                .filter(c -> c._getTipoSimple().toLowerCase().equals(t))
                .collect(Collectors.toList());
    }

    public List<Contenido> buscarPorCategoria(Categoria cat) {
        if (fuente.isEmpty()) {
            return List.of();
        }
        if (cat == null) {
            return new ArrayList<>(fuente);
        }
        return fuente.stream()
                .filter(c -> Objects.equals(c._getCategoria(), cat))
                .collect(Collectors.toList());
    }
}
