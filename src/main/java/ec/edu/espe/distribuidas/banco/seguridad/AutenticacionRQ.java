package ec.edu.espe.distribuidas.banco.seguridad;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;

public class AutenticacionRQ implements Cuerpo {
	private String usuario;
	private String clave;

	public String asTexto() {

		return this.usuario+this.clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario=StringUtils.rightPad(usuario, 10);
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = StringUtils.rightPad(clave, 10);
	}

	public boolean validate(String input) {
		// TODO Marco Palacios
		return false;
	}

	public void build(String input) {
		// TODO Marco Palacios
		
	}

}
