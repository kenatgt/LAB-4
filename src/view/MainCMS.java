package view;

import controller.ControladorContenido;
import controller.ControladorUsuario;
import java.util.List;
import model.Administrador;
import model.Articulo;
import model.Categoria;
import model.Contenido;
import model.Editor;
import model.Publicable;
import model.Visualizable;
import model.Video;

public final class MainCMS {

    private MainCMS() {
        // Evitar instancias
    }

    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión de Contenidos (CMS) Iniciado ===");

        ControladorUsuario ctrlUsuario = new ControladorUsuario();
        ControladorContenido ctrlContenido = new ControladorContenido();
        VistaCMS vista = new VistaCMS();

        Administrador admin = new Administrador("Elena Admin", "elena@cms.com");
        Editor editor = new Editor("Pablo Editor", "pablo@cms.com");

        Categoria tecnologia = new Categoria("Tecnologia", "Novedades en gadgets");
        Categoria deportes = new Categoria("Deportes", "Resumen de partidos");

        System.out.println(ctrlUsuario.login(editor));

        Contenido articulo1 = new Articulo(
                1,
                "Java y POO Avanzado",
                "Introducción a patrones de diseño",
                tecnologia,
                editor,
                "Texto completo sobre la POO..."
        );

        Contenido video1 = new Video(
                2,
                "Lo más destacado del mes",
                "Momentos clave",
                deportes,
                editor,
                "https://video.com/deportes",
                240
        );

        System.out.println(ctrlContenido.gestionarContenido(articulo1, "crear"));
        System.out.println(ctrlContenido.gestionarContenido(video1, "crear"));

        if (articulo1 instanceof Publicable) {
            Publicable publicable = (Publicable) articulo1;
            System.out.println(publicable.publicar());
        }

        System.out.println();
        System.out.println(vista.renderListado("Contenidos actuales del CMS", ctrlContenido.getContenidos()));

        System.out.println();
        System.out.println("--- Filtrando por Articulo en Tecnologia ---");
        List<Contenido> filtrados = ctrlContenido.filtrarContenido("Articulo", tecnologia);
        System.out.println(vista.renderListado("Resultados del filtro", filtrados));

        System.out.println();
        System.out.println("--- Visualizando el Video ---");
        if (video1 instanceof Visualizable) {
            Visualizable visualizableVideo = (Visualizable) video1;
            System.out.println(visualizableVideo.visualizar());
        }

        System.out.println(ctrlUsuario.logout());
        System.out.println(ctrlUsuario.login(admin));
        System.out.println(admin.eliminarContenido(video1));
        System.out.println(ctrlContenido.gestionarContenido(video1, "eliminar"));

        System.out.println();
        System.out.println("--- Generando Reporte Final ---");
        System.out.println(ctrlContenido.generarReporte());

        System.out.println(ctrlUsuario.logout());
    }
}
