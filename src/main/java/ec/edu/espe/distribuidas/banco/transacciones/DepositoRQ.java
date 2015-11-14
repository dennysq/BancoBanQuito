package ec.edu.espe.distribuidas.banco.transacciones;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ec.edu.espe.distribuidas.banco.Cuerpo;

public class DepositoRQ implements Cuerpo {
	private String numeroCuenta;
	private String tipoCuenta;
	private Float valor;
	private String tipoDocumentoDepositante;
	private String valorDocumentoDepositante;

	public String asTexto() {
		BigDecimal bd = new BigDecimal(valor);
		return this.numeroCuenta + this.tipoCuenta + bd.setScale(2, RoundingMode.HALF_EVEN).toString()
				+ this.tipoDocumentoDepositante + this.valorDocumentoDepositante;
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

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Float getValor() {
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

}
