package ec.edu.espe.distribuidas.banco.consultas;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;

public class CuentaClienteRQ implements Cuerpo {
	private String codigoCliente;

	public String asTexto() {

		return this.codigoCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = StringUtils.leftPad(codigoCliente, 9, "0");
	}

	public boolean validate(String input) {
		// TODO Marco Palacios
		return input.length() >= 1 && input.length() <= 9;
	}

	public void build(String input) {
		// TODO Marco Palacios
		if (validate(input)) {
			setCodigoCliente(input);//use este metodo porque le hace el leftpad automaticamente
		}
	}

}
