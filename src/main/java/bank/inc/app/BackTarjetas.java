package bank.inc.app;

import bank.inc.app.dto.AnulacionDTO;
import bank.inc.app.dto.CompraDTO;
import bank.inc.app.dto.EmisionTarjetasDTO;
import bank.inc.app.dto.ListaEmisionTarjetasDTO;
import bank.inc.app.dto.ListaProductosDTO;
import bank.inc.app.dto.NuevaTarjetaDTO;
import bank.inc.app.dto.NumeroEnrrolamientoDTO;
import bank.inc.app.dto.ProductoDTO;
import bank.inc.app.dto.ResultadoTransaccionDTO;
import bank.inc.app.dto.SaldoDTO;
import bank.inc.app.dto.TransaccionDTO;
import bank.inc.app.negocio.NegocioTarjetas;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackTarjetas {

    @Autowired
    private NegocioTarjetas ntarjetas;
    
    @ApiOperation(value = "/card", httpMethod = "GET")
    @RequestMapping(value = "/card", method = RequestMethod.GET, params = {"productId", "titular"})
    public ResponseEntity<NuevaTarjetaDTO> generarNumeroTarjeta(@RequestParam String productId, @RequestParam String titular) {

        return new ResponseEntity(ntarjetas.generarTarjeta(productId, titular), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/card/enroll", method = RequestMethod.POST)
    public ResponseEntity<NumeroEnrrolamientoDTO> activarTarjeta(@RequestBody NumeroEnrrolamientoDTO numeroEnrolamiento) {

        return new ResponseEntity(ntarjetas.enrrolarTarjeta(numeroEnrolamiento), HttpStatus.OK);
    }

    @RequestMapping(value = "/card", method = RequestMethod.DELETE, params = "cardId")
    public ResponseEntity<NumeroEnrrolamientoDTO> bloquearTarjeta(@RequestParam String cardId) {

        return new ResponseEntity(ntarjetas.bloquearTarjeta(cardId), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/card/balance", method = RequestMethod.POST)
    public ResponseEntity<SaldoDTO> recargarSaldo(@RequestBody SaldoDTO recarga) {

        return new ResponseEntity(ntarjetas.regargarSaldo(recarga), HttpStatus.OK);
    }

    @RequestMapping(value = "/card/balance", method = RequestMethod.GET, params = "cardId")
    public ResponseEntity<SaldoDTO> consultarSaldo(@RequestParam String cardId) {

        return new ResponseEntity(ntarjetas.consultarSaldo(cardId), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/transaction/purchase", method = RequestMethod.POST)
    public ResponseEntity<ResultadoTransaccionDTO> comprar(@RequestBody CompraDTO compra) {
        
        return new ResponseEntity(ntarjetas.comprar(compra), HttpStatus.OK);
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.GET, params = "transactionId")
    public ResponseEntity<TransaccionDTO> consultarTransaccion(@RequestParam Integer transactionId) {
        
        return new ResponseEntity(ntarjetas.consultarTransaccion(transactionId), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/transaction/anulation", method = RequestMethod.POST)
    public ResponseEntity<ResultadoTransaccionDTO> anularTransaccion(@RequestBody AnulacionDTO anulacion) {
        
        return new ResponseEntity(ntarjetas.anularTransaccion(anulacion), HttpStatus.OK);
    }

    @RequestMapping(value = "/veremisiontarjetas", method = RequestMethod.GET)
    public ResponseEntity<ListaEmisionTarjetasDTO> verEmisionTarjetas() {

        List<EmisionTarjetasDTO> lemisiontarjetas = ntarjetas.listaEmisionTarjetas();
        ListaEmisionTarjetasDTO lemisiontarjetasdto = new ListaEmisionTarjetasDTO();
        System.out.println(lemisiontarjetas.size());
        lemisiontarjetasdto.setLemisiontarjetas(lemisiontarjetas);
        return new ResponseEntity(lemisiontarjetasdto, HttpStatus.OK);

    }
    
    @RequestMapping(value = "/verproductos", method = RequestMethod.GET)
    public ResponseEntity<ListaProductosDTO> verProductos() {

        List<ProductoDTO> lproductos = ntarjetas.listaProductos();
        ListaProductosDTO lproductosdto = new ListaProductosDTO();
        System.out.println(lproductos.size());
        lproductosdto.setLproductos(lproductos);
        return new ResponseEntity(lproductosdto, HttpStatus.OK);

    }
    
}
