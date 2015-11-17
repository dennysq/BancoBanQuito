package ec.edu.espe.distribuidas.banco.transacciones;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;
import ec.edu.espe.distribuidas.banco.util.MyStringUtils;

public class RetiroRQ implements Cuerpo {
	// TODO Marco Palacios
	private String NumeroCuenta;
	private String TipoCuenta;
	private String Valor;
	private String TipoDocumentoCliente;
	private String ValorDocumentoCliente;

	@Override
	public String asTexto() {

		return this.NumeroCuenta + this.TipoCuenta + this.Valor + this.TipoDocumentoCliente
				+ this.ValorDocumentoCliente;
	}

	@Override
	public boolean validate(String input) {
		return input.length() >= 1 && input.length() <= 41;
	}

	@Override
	public void build(String input) {
		if (validate(input)) {
			try {
				String values[] = MyStringUtils.splitByFixedLengths(input, new int[] { 9, 2, 10, 5, 15 });

				setNumeroCuenta(values[0]);// para que se haga el leftpad
				setTipoCuenta(values[1]);
				setValor(values[2]);
				setTipoDocumentoCliente(values[3]);
				setValorDocumentoCliente(ValorDocumentoCliente = values[4]);

			} catch (Exception e) {

				// e.printStackTrace();
				System.out.println("" + e);
			}

		}

	}

	public String getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.NumeroCuenta = StringUtils.leftPad(numeroCuenta, 9, "0");
	}

	public String getTipoCuenta() {
		return TipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.TipoCuenta = StringUtils.leftPad(tipoCuenta, 2, "0");
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = StringUtils.leftPad(valor, 10, "0");
	}

	public String getTipoDocumentoCliente() {
		return TipoDocumentoCliente;
	}

	public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
		this.TipoDocumentoCliente = StringUtils.rightPad(tipoDocumentoCliente, 5, " ");
	}

	public String getValorDocumentoCliente() {
		return ValorDocumentoCliente;
	}

	public void setValorDocumentoCliente(String valorDocumentoCliente) {
		this.ValorDocumentoCliente = StringUtils.rightPad(valorDocumentoCliente, 15, " ");
	}
}
