package ec.edu.espe.distribuidas.banco.consultas;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;
import ec.edu.espe.distribuidas.banco.util.MyStringUtils;

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
		this.valor = StringUtils.rightPad(valor, 15, " ");
	}

	public String asTexto() {

		return this.tipoDocumento + this.valor;
	}

	public boolean validate(String input) {
		// TODO Marco Palacios
		return input.length() >= 1 && input.length() <= 20;
	}

	public void build(String input) {
		// TODO Marco Palacios
		if (validate(input)) {
			try {
				if (input.length() < 20) {
					input = StringUtils.rightPad(input, 20, " ");
				}
				String values[] = MyStringUtils.splitByFixedLengths(input, new int[] { 5, 15 });//aqui estaba 10 marco le cambie a 15

				this.tipoDocumento = values[0];
				setValor(values[1]);//para que se haga el rightPad

			} catch (Exception e) {

				// e.printStackTrace();
				System.out.println("" + e);
			}

		}

	}

}
