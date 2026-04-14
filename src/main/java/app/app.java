package app;

import models.Venta;
import services.ConsultasVenta;
import utilidades.CsvLoader;

import java.util.List;

public class app {

    static void main() {

    //Cargar fichero ventas.csv
        List<Venta> ventas= CsvLoader.cargarVentas();
        ventas.forEach(IO::println);

        //crear servicio ConsultasVentas
        ConsultasVenta consVenta = new ConsultasVenta(ventas);


        //hacer consultas

        IO.println("---- 1. ---- getVentasMayor100");
        IO.println( consVenta.getVentasMayor100()
                .stream().count());

        IO.println("--- 2. ---> getVentasByCategoriaElectronica");
        consVenta.getVentasByCategoriaElectronica().forEach(System.out::println);

        IO.println("--- 3. ---> getProductosVendidosOrder");
        consVenta.getProductosVendidosOrder().forEach(System.out::println);

        IO.println("--- 4. ---> getPrimeraVentaSpain");
        consVenta.getPrimeraVentaSpain().ifPresent(System.out::println);

        IO.println("--- 5. ---> getTop10VentasPorImporteTotal()");
        consVenta.getTop10VentasPorImporteTotal().forEach(System.out::println);






    }


}
