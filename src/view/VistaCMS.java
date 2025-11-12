package view;

import java.util.List;

import model.Contenido;

public class VistaCMS {

    public String renderListado(String encabezado, List<Contenido> contenidos) {
        StringBuilder salida = new StringBuilder();
        if (encabezado != null && !encabezado.isBlank()) {
            salida.append(encabezado).append(System.lineSeparator());
        }

        if (contenidos == null || contenidos.isEmpty()) {
            salida.append("No hay contenidos publicados.");
            return salida.toString();
        }

        int indice = 1;
        for (Contenido c : contenidos) {
            salida.append(indice++)
                    .append(". ID: ").append(c._getId())
                    .append(" | Título: ").append(c._getTitulo())
                    .append(" | Tipo: ").append(c._getTipoSimple())
                    .append(" | Autor: ").append(c._getAutor()._getNombre())
                    .append(" | Estado: ").append(c._getEstado())
                    .append(System.lineSeparator());
        }

        return salida.toString().stripTrailing();
    }
}
