/**
 * 
 */
package pe.banca.empresa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.banca.empresa.model.Cuenta;
import pe.banca.empresa.repositories.CuentaRepository;

/**
 * @author vector
 *
 */
@Service
public class CuentaServiceImpl implements CuentaService{

  @Autowired
  CuentaRepository cuentaRepository;
  
  /* (non-Javadoc)
   * @see pe.banca.cuenta.service.cuentaService#getAll()
   */
  @Override
  public List<Cuenta> getAll() {
    List<Cuenta> cuentaList = new ArrayList<>();
    cuentaRepository.findAll().forEach(cuentaList::add);
    return cuentaList;
    
  }
  
  public Cuenta save(Cuenta p) {
    return cuentaRepository.save(p);
  }

  @Override
  public Cuenta findById(Long cuentaId) {
    Optional<Cuenta> dbCuenta = cuentaRepository.findById(cuentaId);
    return dbCuenta.orElse(null);
  }

  /**
   * Reto 1: Refactorizar el codigo
   */
  @Override
  public Cuenta findByNroCta(String numeroCuenta) {
	List<Cuenta> cuentaList = new ArrayList<>();
	List<Cuenta> cuentaListByNro = new ArrayList<>();
    cuentaRepository.findAll().forEach(cuentaList::add);
    
    for(Cuenta cuenta: cuentaList) {
    	
    	if( numeroCuenta.equals(cuenta.getNumeroCuenta()) ) {
    		cuentaListByNro.add(cuenta);
    	}
    		
    }
	return !cuentaListByNro.isEmpty() ? cuentaListByNro.get(0) : null;
  }
  
  

}
