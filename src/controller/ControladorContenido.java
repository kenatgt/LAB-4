package controller;

import java.util.ArrayList;
import java.util.List;

import model.Contenido;
import model.Categoria;
import model.Reporte;
import model.Buscador;

/**
 * Controlador que gestiona la lógica relacionada con los contenidos.
 * Se comunica con las clases del modelo y con la vista (VistaCMS).
 */
public class ControladorContenido {

    private List<Contenido> contenidos;
    private Buscador buscador;
    private Reporte reporte;

    public ControladorContenido() {
        contenidos = new ArrayList<>();
        buscador = new Buscador();
        reporte = new Reporte();
    }

    // ====== Métodos principales ======

    public void gestionarContenido(Contenido c, String accion) {
        switch (accion.toLowerCase()) {
            case "crear":
                c.crear();
                contenidos.add(c);
                System.out.println("Contenido agregado: " + c._getTitulo());
                break;
            case "editar":
                c.editar();
                System.out.println("Contenido editado: " + c._getTitulo());
                break;
            case "eliminar":
                c.eliminar();
                contenidos.remove(c);
                System.out.println("Contenido eliminado: " + c._getTitulo());
                break;
            default:
                System.out.println("Acción no reconocida: " + accion);
                break;
        }
    }

    public void filtrarContenido(String tipo, Categoria cat) {
        System.out.println("Filtrando contenidos...");
        List<Contenido> filtrados = buscador.buscarPorTipo(tipo);
        filtrados.retainAll(buscador.buscarPorCategoria(cat));

        for (Contenido c : filtrados) {
            System.out.println(" - " + c._getTitulo() + " (" + c._getTipoSimple() + ")");
        }
    }

    public void generarReporte() {
        reporte.generarResumen();
    }

    // Getters y utilidades
    public List<Contenido> getContenidos() {
        return contenidos;
    }
}
