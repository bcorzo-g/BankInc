package bank.inc.app.dto;

import bank.inc.app.persistencia.entidades.Producto;
import lombok.Data;

@Data
public class ProductoDTO {

    private Integer id;
    private String nombre;

    public static ProductoDTO parseProducto(Producto p) {

        ProductoDTO productodto = new ProductoDTO();

        productodto.setId(p.getId());
        productodto.setNombre(p.getNombre());
        return productodto;

    }
}
