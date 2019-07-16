/**
 * 
 */
package pe.banca.empresa.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.banca.empresa.dto.TopTranferDTO;
import pe.banca.empresa.model.Cuenta;
import pe.banca.empresa.model.Transferencia;
import pe.banca.empresa.service.CuentaService;
import pe.banca.empresa.service.TransferenciaService;
import pe.banca.empresa.util.ConversorMoneda;
import pe.banca.empresa.util.Moneda;

/**
 * 
 * @author vector
 */

@RestController
public class TransferenciaController {
  
  @Autowired
  TransferenciaService transferenciaService;
  
  @Autowired
  CuentaService cuentaService;
  
  /**
   * Reto 2: Refactorizar el metodo
   * @param p
   * @return
   */
  @PostMapping(path = "/api/transferencia")
  public ResponseEntity<Transferencia> register(@RequestBody Transferencia p) {
	  Cuenta cuentaOrigen = cuentaService.findByNroCta(p.getNumeroCuentaOrigen());
	  Cuenta cuentaDestino = cuentaService.findByNroCta(p.getNumeroCuentaDestino());
	  BigDecimal importe = p.getImporte();
	  if(!cuentaOrigen.getMoneda().equals(cuentaDestino.getMoneda())) {
		  if ( cuentaOrigen.getMoneda().equals("PEN") ) {
			  switch (cuentaDestino.getMoneda()) {
				case "EUR":
					importe = ConversorMoneda.conversorImporte(Moneda.PEN.getId(), Moneda.EUR.getId(), importe);
					break;
				case "USD":
					importe = ConversorMoneda.conversorImporte(Moneda.PEN.getId(), Moneda.USD.getId(), importe);
					break;
		
				default:
					break;
			  }
		  } else if ( cuentaOrigen.getMoneda().equals("EUR") ) {
			  switch (cuentaDestino.getMoneda()) {
				case "PEN":
					importe = ConversorMoneda.conversorImporte(Moneda.EUR.getId(), Moneda.PEN.getId(), importe);
					break;
				case "USD":
					importe = ConversorMoneda.conversorImporte(Moneda.EUR.getId(), Moneda.USD.getId(), importe);
					break;
		
				default:
					break;
			  }
		  } else if ( cuentaOrigen.getMoneda().equals("USD") ) {
			  switch (cuentaDestino.getMoneda()) {
				case "PEN":
					importe = ConversorMoneda.conversorImporte(Moneda.USD.getId(), Moneda.PEN.getId(), importe);
					break;
				case "EUR":
					importe = ConversorMoneda.conversorImporte(Moneda.USD.getId(), Moneda.EUR.getId(), importe);
					break;
		
				default:
					break;
			  }
		  }
		  
	  }
	  p.setImporte(importe);
	  return ResponseEntity.ok(transferenciaService.save(p));
  }
  
  @GetMapping(path = "/api/transferencia")
  public ResponseEntity<List<Transferencia>> getAlltransferenciaServicios() {
    return ResponseEntity.ok(transferenciaService.getAll());
  }
  
  @GetMapping(path = "/api/transferencia/{transferencia-id}")
  public ResponseEntity<Transferencia> gettransferenciaServicioById(@PathVariable(name="transferencia-id", required=true)Long transferenciaServicioId) {
    Transferencia transferenciaServicio = transferenciaService.findById(transferenciaServicioId);
    if (transferenciaServicio != null) {
      return ResponseEntity.ok(transferenciaServicio);
    }
    return ResponseEntity.notFound().build();
  }
  
  /**
   * Reto 3:
   * Esta API devuelve los 5 mayores montos de tranferencias de los clientes, con su nombre, email, importe, el nombre servicio pagado y el nombre de la empresa.
   * Solo deben contar los servicios pagados que comiencen y terminen dentro de las duraciones mencionadas.
   * 
   * No cambie la firma del metodo y los tipos de datos devueltos.
   * @return
   */
  @GetMapping(path = "/api/top-tranfer")
  public ResponseEntity<List<TopTranferDTO>> getTopTranfer(
      @RequestParam(value="max", defaultValue="5") Long count,
      @RequestParam(value="startTime", required=true) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startTime,
      @RequestParam(value="endTime", required=true) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endTime){
    List<TopTranferDTO> topDrivers = new ArrayList<TopTranferDTO>();
    /**
     * Realice su implementacion aqui. ArrayList de Tranferecias con los montos tops.
     * 
     */
    
    return ResponseEntity.ok(topDrivers);
    
  }
  
  
}
