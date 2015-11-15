package ec.edu.espe.distribuidas.banco.seguridad;

import ec.edu.espe.distribuidas.banco.Cuerpo;

public class AutenticacionRS implements Cuerpo {
	private String message;

	public AutenticacionRS() {

	}

	public String asTexto() {

		return this.message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AutenticacionRS(String message) {
		this.message = message;
	}

	public boolean validate(String input) {

		return input.length() == 2;
	}

	public void build(String input) {
		if (validate(input)) {
			this.message = input;
		}

	}
}
