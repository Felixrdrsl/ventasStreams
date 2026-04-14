package services;

import lombok.Data;
import models.Venta;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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





}
