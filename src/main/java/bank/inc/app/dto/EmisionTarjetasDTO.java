package bank.inc.app.dto;

import bank.inc.app.persistencia.entidades.EmisionTarjeta;
import java.util.Date;
import lombok.Data;

@Data
public class EmisionTarjetasDTO {

    private Integer id;
    private String numerotarjeta;
    private String nombretitular;
    private int estado;
    private Double saldo;
    private Date fechacreacion;
    private Date fechavence;
    private Integer idproducto;
    
    public static EmisionTarjetasDTO parseEmisiontarjeta(EmisionTarjeta e) {

        EmisionTarjetasDTO emisiontarjetasdto = new EmisionTarjetasDTO();

        emisiontarjetasdto.setId(e.getId());
        emisiontarjetasdto.setNumerotarjeta(e.getNumeroTarjeta());
        emisiontarjetasdto.setNombretitular(e.getNombreTitular());
        emisiontarjetasdto.setEstado(e.getEstado());
        emisiontarjetasdto.setSaldo(e.getSaldo());
        emisiontarjetasdto.setFechacreacion(e.getFecha_creacion());
        emisiontarjetasdto.setFechavence(e.getFecha_vence());
        
        return emisiontarjetasdto;

    }
}
