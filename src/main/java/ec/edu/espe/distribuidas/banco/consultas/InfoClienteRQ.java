package ec.edu.espe.distribuidas.banco.consultas;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;

public class InfoClienteRQ implements Cuerpo {
	private String tipoDocumento;
	private String valor;

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String asTexto() {

		return this.tipoDocumento + this.valor;
	}

}
