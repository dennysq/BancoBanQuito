package ec.edu.espe.distribuidas.banco.seguridad;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;
import ec.edu.espe.distribuidas.banco.util.MyStringUtils;

public class AutenticacionRQ implements Cuerpo {
	private String usuario;
	private String clave;

	public String asTexto() {

		return this.usuario + this.clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = StringUtils.rightPad(usuario, 10, " ");
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = StringUtils.rightPad(clave, 10, " ");
	}

	public boolean validate(String input) {
		// TODO Marco Palacios
		return input.length() >= 1 && input.length() <= 20;

	}

	public void build(String input) {
		// TODO Marco Palacios
		if (this.validate(input)) {
			if (validate(input)) {
				try {
					if (input.length() < 20) {
						//DQ esto nos ayuda a que en el metodo splitByFixedLengths no nos bote la exception
						StringUtils.rightPad(input, 20, " ");

					}
					String values[] = MyStringUtils.splitByFixedLengths(input, new int[] { 10, 10 });
					this.usuario = values[0];
					this.clave = values[1];

				} catch (Exception e) {

					// e.printStackTrace();
					System.out.println("" + e);
				}

			}

		}

	}

}
