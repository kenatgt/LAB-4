package model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Reporte {

    public String generarResumen(List<Contenido> contenidos) {
        List<Contenido> lista = contenidos == null ? List.of() : contenidos;
        StringBuilder resumen = new StringBuilder();
        resumen.append("Total de contenidos: ").append(lista.size());

        if (lista.isEmpty()) {
            resumen.append(System.lineSeparator()).append("No hay contenidos para mostrar.");
            return resumen.toString();
        }

        Map<String, Long> porTipo = lista.stream()
                .collect(Collectors.groupingBy(Contenido::_getTipoSimple, TreeMap::new, Collectors.counting()));
        resumen.append(System.lineSeparator()).append("Por tipo:");
        porTipo.forEach((tipo, cantidad) ->
                resumen.append(System.lineSeparator())
                        .append(" - ")
                        .append(tipo)
                        .append(':')
                        .append(' ')
                        .append(cantidad));

        Map<Contenido.Estado, Long> porEstado = lista.stream()
                .collect(Collectors.groupingBy(Contenido::_getEstado, TreeMap::new, Collectors.counting()));
        resumen.append(System.lineSeparator()).append("Por estado:");
        porEstado.forEach((estado, cantidad) ->
                resumen.append(System.lineSeparator())
                        .append(" - ")
                        .append(estado)
                        .append(':')
                        .append(' ')
                        .append(cantidad));

        return resumen.toString();
    }
}
