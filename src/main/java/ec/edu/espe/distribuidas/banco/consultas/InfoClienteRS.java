package ec.edu.espe.distribuidas.banco.consultas;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;

import ec.edu.espe.distribuidas.banco.util.MyStringUtils;

public class InfoClienteRS implements Cuerpo {
	private String resultado;
	private String codigoCliente;
	private String tipoDocumento;
	private String valorDocumento;
	private String apellido;
	private String nombre;
	private String direccion;
	private String numeroTelefonico;
	private String numeroMovil;
	private String correoElectronico;

	private String fechaNacimiento;

	public String asTexto() {

		return resultado + codigoCliente + tipoDocumento + valorDocumento + apellido + nombre + direccion
				+ numeroTelefonico + numeroMovil + correoElectronico + fechaNacimiento;
	}

	public InfoClienteRS() {

	}

	public void build(String input) {
		if (this.validate(input)) {
			try {
				if (input.length() < 412) {
					input = StringUtils.rightPad(input, 412, " ");
				}
				String values[] = MyStringUtils.splitByFixedLengths(input, new int[] { 3, 9, 400 });
				this.resultado = values[0];
				if (resultado.equals("OKO")) {
					this.codigoCliente = values[1];
					String clientValues[] = StringUtils.splitPreserveAllTokens(values[2].trim(), "|");
					this.tipoDocumento = clientValues[0].trim();
					this.valorDocumento = clientValues[1].trim();
					this.nombre = clientValues[2].trim();
					this.apellido = clientValues[3].trim();
					this.direccion = clientValues[4].trim();
					this.numeroTelefonico = clientValues[5].trim();
					this.numeroMovil = clientValues[6].trim();
					this.correoElectronico = clientValues[7].trim();
					this.fechaNacimiento = clientValues[8].trim();
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		} // hacer todos los request//metodovalidate, build, validar la longitud
			// de la cabecera , que sea RS o RQ validate tipos de respuesta,
			// validate
	}

	public boolean validate(String input) {
		return input.length() >= 3 && input.length() <= 412;

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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getValorDocumento() {
		return valorDocumento;
	}

	public void setValorDocumento(String valorDocumento) {
		this.valorDocumento = valorDocumento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getNumeroMovil() {
		return numeroMovil;
	}

	public void setNumeroMovil(String numeroMovil) {
		this.numeroMovil = numeroMovil;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "InfoClienteRS [resultado=" + resultado + ", codigoCliente=" + codigoCliente + ", tipoDocumento="
				+ tipoDocumento + ", valorDocumento=" + valorDocumento + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", direccion=" + direccion + ", numeroTelefonico=" + numeroTelefonico + ", numeroMovil=" + numeroMovil
				+ ", correoElectronico=" + correoElectronico + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
