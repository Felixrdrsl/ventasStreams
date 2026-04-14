package utilidades;

import models.Venta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

    public static List<Venta> cargarVentas() {

        Path ruta = Paths.get("src/main/resources/ventas.csv");
        List<Venta> ventas = new ArrayList<>();

        try {
            //
            List<String> filas = Files.readAllLines(ruta);
            //Eliminar la primera fila
            filas.removeFirst();
            //Convertir cada fila String a un objeto venta
            filas.forEach(l ->{
                List<String> campos = List.of(l.split(","));
                //Añadimos a List<Venta> un objeto nuevo venta a partir de la fila
                ventas.add(new Venta(
                        Long.parseLong(campos.get(0)),
                        campos.get(1),
                        campos.get(2),
                        campos.get(3),
                        Integer.parseInt(campos.get(4)),
                        Double.parseDouble(campos.get(5)),
                        LocalDate.parse(campos.get(6)),
                        campos.get(7)
                ));

            });



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ventas;

    }


}
