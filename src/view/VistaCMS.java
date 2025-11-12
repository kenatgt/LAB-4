// Archivo: MainCMS.java

import controller.ControladorContenido;
import controller.ControladorUsuario;
import model.*;
import view.VistaCMS;

public class MainCMS {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión de Contenidos (CMS) Iniciado ===");

        // 1. Inicializar Controladores
        ControladorUsuario ctrlUsuario = new ControladorUsuario();
        ControladorContenido ctrlContenido = new ControladorContenido();
        VistaCMS vista = new VistaCMS(ctrlContenido);

        // 2. Crear Roles, Categorías y Objetos de Prueba
        Administrador admin = new Administrador("Elena Admin", "elena@cms.com");
        Editor editor = new Editor("Pablo Editor", "pablo@cms.com");
        
        Categoria tecnologia = new Categoria("Tecnologia", "Novedades en gadgets");
        Categoria deportes = new Categoria("Deportes", "Resumen de partidos");

        // 3. Simular un Flujo: Login y Creación de Contenido
        ctrlUsuario.login(editor);
        
        Contenido articulo1 = new Articulo(
            1, "Java y POO Avanzado", "Introducción a patrones de diseño", 
            tecnologia, editor, "Texto completo sobre la POO..."
        );
        
        Contenido video1 = new Video(
            2, "Lo más destacado del mes", "Momentos clave", 
            deportes, editor, "https://video.com/deportes", 240
        );

        // 4. Utilizar el Controlador de Contenido
        ctrlContenido.gestionarContenido(articulo1, "crear");
        ctrlContenido.gestionarContenido(video1, "crear");
        
        // El Editor no tiene el método 'publicar', pero el Articulo sí implementa Publicable
        if (articulo1 instanceof Publicable) {
            ((Publicable) articulo1).publicar();
        }
        
        // 5. Utilizar la Vista para mostrar contenidos
        vista.mostrarTodosLosContenidos(ctrlContenido.getContenidos());
        
        // 6. Filtrar y Visualizar
        System.out.println("\n--- Filtrando por Articulo en Tecnologia ---");
        ctrlContenido.filtrarContenido("Articulo", tecnologia);
        
        System.out.println("\n--- Visualizando el Video ---");
        if (video1 instanceof Visualizable) {
            ((Visualizable) video1).visualizar();
        }
        
        // 7. Simular rol de Administrador y eliminación
        ctrlUsuario.logout();
        ctrlUsuario.login(admin);
        admin.eliminarContenido(video1);
        ctrlContenido.gestionarContenido(video1, "eliminar");
        
        // 8. Reporte
        System.out.println("\n--- Generando Reporte Final ---");
        ctrlContenido.generarReporte();
        
        ctrlUsuario.logout();
    }
}
