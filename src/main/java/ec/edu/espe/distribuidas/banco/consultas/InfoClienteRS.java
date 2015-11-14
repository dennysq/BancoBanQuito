package ec.edu.espe.distribuidas.banco.consultas;

import ec.edu.espe.distribuidas.banco.Cuerpo;

public class InfoClienteRS implements Cuerpo {
	private String resultado;
	private String codigoCliente;
	private String tipoDocumento;
	private String valorDocumento;
	private String apellido;
	private String nombre;
	private String direccion;
	private String numeroTelefónico;
	private String numeroMovil;
	private String correoElectronico;
	
	private String fechaNacimiento;

	public String asTexto() {

		return this.codigoCliente;
	}

	public InfoClienteRS() {

	}

	public void build(String in) {
		if (this.validate(in)) {
				this.resultado=in.substring(0,3);
				this.resultado=in.substring(3,12);
				//String aux=StringUtils.spli
		}//hacer todos los request//metodovalidate, build, validar la longitud de la cabecera , que sea RS o RQ validate tipos de respuesta, validate  
	}

	private boolean validate(String datos) {
		return datos.length() >= 12 && datos.length() < 412;

	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

}
