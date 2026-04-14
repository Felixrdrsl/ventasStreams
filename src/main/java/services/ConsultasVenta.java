package services;

import lombok.Data;
import models.Venta;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class ConsultasVenta {

    private List<Venta> ventas;

    public ConsultasVenta(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * Devuelve las ventas con importe total mayor a 100€
     * @return
     */
    public List<Venta> getVentasMayor100(){
        return ventas.stream()
                .filter(venta -> venta.getTotalLinea() > 100)
                .toList();
    }

    /**
     * Develve la categoria Electronics
     * @return
     */
    public List<Venta> getVentasByCategoriaElectronica(){
        return ventas.stream()
                .filter(v -> v.getCategoria().equals("Electronics"))
                .toList();
    }

    /**
     * Devuelve los productos vendidos ordenador por nombre. Sin repetidos.
     * @return
     */
    public List<String> getProductosVendidosOrder(){
        return ventas.stream()
                .map(Venta::getProducto)
                .distinct()
                .sorted()
                .toList();
    }

    /**
     * Devuelve la primera Venta en España
     * @return
     */
    public Optional<Venta> getPrimeraVentaSpain(){
        return ventas.stream()
                .filter(v -> v.getPais().equals("Spain"))
                .findFirst();
    }

    /**
     * Devuelve el Top10 ventas por importe total
     * @return
     */
    public List<Venta> getTop10VentasPorImporteTotal(){
        return ventas.stream()
                .sorted(Comparator.comparing(Venta::getTotalLinea).reversed())
                .limit(10)
                .toList();
    }

    /**
     * Facturacion total de ventas
     * @return
     */
    public double getFacuturacionTotal(){
        return ventas.stream()
                .mapToDouble(Venta::getTotalLinea)
                .sum();
    }

    /**
     * Estadisticas del precio unitario
     * @return
     */
    public DoubleSummaryStatistics getEstadisticasPrecioUnitario(){
        return ventas.stream()
                .collect(Collectors.summarizingDouble(Venta::getPrecioUnitario));
    }

    /**
     * Devuelve las ventas agrupadas por categoria y las cuenta cuantas hay de cada una
     * @return
     */
    public Map<String,Long> getNumeroDeVentasPorCategoria(){
        return ventas.stream()
                .collect(Collectors.groupingBy(Venta::getCategoria,
                        Collectors.counting()));
    }
    /**
     * Ventas agrupadas por país. Muestra país y total facturación de ese país
     * @return
     */
    public Map<String,Double> getFacturacionTotalPais(){
        return ventas.stream()
                .collect(Collectors.groupingBy(Venta::getPais,Collectors.summingDouble(Venta::getTotalLinea)));

    }
    /**
     * Número de ventas agrupadas por método de pago
     * @return
     */
    public Map<String, Long> getNumeroVentasPorMetodoPago() {
        return ventas.stream()
                .collect(Collectors.groupingBy(Venta::getMetodoPago,
                        Collectors.counting()));
    }




}
