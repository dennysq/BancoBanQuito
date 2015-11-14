package ec.edu.espe.distribuidas.banco.consultas;

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
		this.codigoCliente = codigoCliente;
	}

}
