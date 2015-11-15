package ec.edu.espe.distribuidas.banco.consultas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;

import ec.edu.espe.distribuidas.banco.model.Cuenta;
import ec.edu.espe.distribuidas.banco.util.MyStringUtils;

public class CuentaClienteRS implements Cuerpo {

	private String resultado;
	private String codigoCliente;
	private String numCuentas;
	private List<Cuenta> cuentas;

	public String asTexto() {

		return this.codigoCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = StringUtils.leftPad(codigoCliente, 9, "0");
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getNumCuentas() {
		return numCuentas;
	}

	public void setNumCuentas(String numCuentas) {
		this.numCuentas = StringUtils.leftPad(numCuentas, 2, "0");
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public boolean validate(String input) {
		return input.length() >= 2 && input.length() <= 414;
	}

	public void build(String input) {
		if (this.validate(input)) {
			try {
				if (input.length() < 414) {
					input = StringUtils.rightPad(input, 414, " ");
				}
				String values[] = MyStringUtils.splitByFixedLengths(input, new int[] { 3, 9, 2, 400 });
				this.resultado = values[0];
				if (this.resultado.equals("OKO")) {

					this.codigoCliente = values[1];
					this.numCuentas = values[2];
					if (cuentas == null) {
						cuentas = new ArrayList<>();
					} else {
						cuentas.clear();
					}
					if (resultado.equals("OKO")) {
						String clientValues[] = StringUtils.splitPreserveAllTokens(values[3].trim(), "|");
						int stringIndex = 0;
						int numCuentasInt = Integer.valueOf(this.numCuentas);
						Cuenta c = null;
						for (int i = 0; i < numCuentasInt; i++) {
							c = new Cuenta();
							c.setNumeroCuenta(clientValues[stringIndex].trim());
							stringIndex++;
							c.setTipoCuenta(clientValues[stringIndex].trim());
							stringIndex++;
							c.setSaldoActual(clientValues[stringIndex].trim());
							stringIndex++;
							c.setFechaYHoraUM(clientValues[stringIndex].trim());
							stringIndex++;
							this.cuentas.add(c);
						}

					}
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "CuentaClienteRS [resultado=" + resultado + ", codigoCliente=" + codigoCliente + ", numCuentas="
				+ numCuentas + ", cuentas=" + cuentas + "]";
	}

}
