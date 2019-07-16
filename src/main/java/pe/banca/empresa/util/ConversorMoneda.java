package pe.banca.empresa.util;

import java.math.BigDecimal;

public class ConversorMoneda {

	public static BigDecimal conversorImporte(int monedaOrigen, int monedaDestino, BigDecimal importeOrigen) {
		
		BigDecimal importeConvertido = importeOrigen;
		
		if(monedaOrigen == 109 && monedaDestino == 44) { //PEN a EUR
			importeConvertido = importeOrigen.multiply(new BigDecimal("0,270870"));
		} else if(monedaOrigen == 109 && monedaDestino == 147) { //PEN a USD
			importeConvertido = importeOrigen.multiply(new BigDecimal("0,30358"));
		} else if(monedaOrigen == 44 && monedaDestino == 109) { //EUR a PEN
			importeConvertido = importeOrigen.multiply(new BigDecimal("3.69"));
		} else if(monedaOrigen == 44 && monedaDestino == 147) { //EUR a USD
			importeConvertido = importeOrigen.multiply(new BigDecimal("1,12072"));
		} else if(monedaOrigen == 147 && monedaDestino == 109) { //USD a PEN
			importeConvertido = importeOrigen.multiply(new BigDecimal("3.11"));
		} else if(monedaOrigen == 147 && monedaDestino == 44) { //USD a EUR
			importeConvertido = importeOrigen.multiply(new BigDecimal("0,892246"));
		} 
		return importeConvertido;
	}
	
}
