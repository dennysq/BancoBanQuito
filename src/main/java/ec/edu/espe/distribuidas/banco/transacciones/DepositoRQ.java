package ec.edu.espe.distribuidas.banco.transacciones;


import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;

public class DepositoRQ implements Cuerpo {
	private String numeroCuenta;
	private String tipoCuenta;
	private String valor;
	private String tipoDocumentoDepositante;
	private String valorDocumentoDepositante;

	public String asTexto() {

		return this.numeroCuenta + this.tipoCuenta + this.valor + this.tipoDocumentoDepositante
				+ this.valorDocumentoDepositante;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public String getTipoDocumentoDepositante() {
		return tipoDocumentoDepositante;
	}

	public void setValor(String valor) {
		
		this.valor = StringUtils.leftPad(valor, 10, "0");
	}

	public String getValor() {
		return valor;
	}

	public String getValorDocumentoDepositante() {
		return valorDocumentoDepositante;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public void setTipoDocumentoDepositante(String tipoDocumentoDepositante) {
		this.tipoDocumentoDepositante = tipoDocumentoDepositante;
	}

	public void setValorDocumentoDepositante(String valorDocumentoDepositante) {
		this.valorDocumentoDepositante = valorDocumentoDepositante;
	}

	public boolean validate(String input) {
		// TODO Luis Valdebenito
		return false;
	}

	public void build(String input) {
		// TODO Luis Valdebenito
		
	}

}
