// Archivo: view/VistaCMS.java (CÓDIGO COMPLETO)

package view;

import controller.ControladorContenido;
import model.Contenido;
import java.util.List;

/**
 * Vista simple que se comunica con el usuario (a través de la consola).
 */
public class VistaCMS {
    
    private final ControladorContenido ctrlContenido;

    // Constructor para recibir un controlador si se necesita
    public VistaCMS(ControladorContenido ctrlContenido) {
        this.ctrlContenido = ctrlContenido;
    }

    public void mostrarTodosLosContenidos(List<Contenido> contenidos) {
        System.out.println("\n--- Contenidos Actuales del CMS (" + contenidos.size() + ") ---");
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenidos publicados.");
            return;
        }
        for (Contenido c : contenidos) {
            System.out.println(
                "ID: " + c._getId() + 
                " | Título: " + c._getTitulo() + 
                " | Tipo: " + c._getTipoSimple() +
                " | Autor: " + c._getAutor()._getNombre()
            );
        }
    }
    
    // Puedes agregar más métodos de visualización aquí.
}
