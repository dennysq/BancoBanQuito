package ec.edu.espe.distribuidas.banco.transacciones;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;


public class DepositoRS implements Cuerpo  {
	//TODO Luis Valdebenito 
	private String resultado;
	
	public DepositoRS() {
		
	}
	
	public String asTexto() {

		return this.resultado;
	}
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public DepositoRS(String resultado) {
		this.resultado = resultado;
	}

	public boolean validate(String input) {

		return input.length() == 2;
	}

	public void build(String input) {
		if (validate(input)) {
			this.resultado = input;
		}

	}
}
