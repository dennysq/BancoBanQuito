package ec.edu.espe.distribuidas.banco.transacciones;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;
import ec.edu.espe.distribuidas.banco.util.MyStringUtils;

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
		this.numeroCuenta = StringUtils.leftPad(numeroCuenta, 9, "0");
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = StringUtils.leftPad(tipoCuenta, 2, "0");
	}

	public void setTipoDocumentoDepositante(String tipoDocumentoDepositante) {
		this.tipoDocumentoDepositante = StringUtils.rightPad(tipoDocumentoDepositante, 5, " ");
	}

	public void setValorDocumentoDepositante(String valorDocumentoDepositante) {
		this.valorDocumentoDepositante = StringUtils.rightPad(valorDocumentoDepositante, 15, " ");
	}

	public boolean validate(String input) {
		return input.length() >= 1 && input.length() <= 41;
	}

	public void build(String input) {
		// TODO Luis Valdebenito
		if (validate(input)) {
			try {
				String values[] = MyStringUtils.splitByFixedLengths(input, new int[] { 9, 2, 10, 5, 15 });

				setNumeroCuenta(values[0]);// para que se haga el leftpad
				setTipoCuenta(values[1]);
				setValor(values[2]);
				setTipoDocumentoDepositante(values[3]);
				setValorDocumentoDepositante(valorDocumentoDepositante = values[4]);

			} catch (Exception e) {

				// e.printStackTrace();
				System.out.println("" + e);
			}

		}


	}

}
