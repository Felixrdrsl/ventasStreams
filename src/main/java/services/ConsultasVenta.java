package services;

import lombok.Data;
import models.Venta;

import java.util.List;

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





}
