package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import model.Buscador;
import model.Categoria;
import model.Contenido;
import model.Reporte;

public class ControladorContenido {

    private final List<Contenido> contenidos;
    private final Buscador buscador;
    private final Reporte reporte;

    public ControladorContenido() {
        this.contenidos = new ArrayList<>();
        this.buscador = new Buscador(contenidos);
        this.reporte = new Reporte();
    }

    public String gestionarContenido(Contenido contenido, String accion) {
        if (contenido == null) {
            return "Contenido no válido.";
        }
        if (accion == null || accion.isBlank()) {
            return "Acción no reconocida.";
        }

        String comando = accion.trim().toLowerCase();
        switch (comando) {
            case "crear":
                if (contenidos.contains(contenido)) {
                    return "El contenido ya está registrado: " + contenido._getTitulo();
                }
                contenido.crear();
                contenidos.add(contenido);
                return "Contenido agregado: " + contenido._getTitulo();
            case "editar":
                if (!contenidos.contains(contenido)) {
                    return "No se puede editar un contenido no registrado: " + contenido._getTitulo();
                }
                contenido.editar();
                return "Contenido editado: " + contenido._getTitulo();
            case "eliminar":
                if (!contenidos.contains(contenido)) {
                    return "No se puede eliminar un contenido no registrado: " + contenido._getTitulo();
                }
                contenido.eliminar();
                contenidos.remove(contenido);
                return "Contenido eliminado: " + contenido._getTitulo();
            default:
                return "Acción no reconocida: " + accion;
        }
    }

    public List<Contenido> filtrarContenido(String tipo, Categoria categoria) {
        List<Contenido> filtrados = buscador.buscarPorTipo(tipo);
        if (categoria == null) {
            return filtrados;
        }
        return filtrados.stream()
                .filter(c -> Objects.equals(c._getCategoria(), categoria))
                .collect(Collectors.toList());
    }

    public String generarReporte() {
        return reporte.generarResumen(contenidos);
    }

    public List<Contenido> getContenidos() {
        return new ArrayList<>(contenidos);
    }
}
