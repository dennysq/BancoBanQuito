package ec.edu.espe.distribuidas.banco;

import org.apache.commons.codec.digest.DigestUtils;

public abstract class Mensaje {
	protected Cabecera cabecera;
	protected String Tipo;
	protected Cuerpo cuerpo;
	public static final String TIPO_MENSAJE_REQUEST = "RQ";
	public static final String TIPO_MENSAJE_RESPONSE = "RS";
	public static final String ID_MENSAJE_INFOCLIENTE = "CLIBUSSIMP";
	public static final String ID_MENSAJE_CUENTACLIENTE = "CLIBUSCUEN";
	public static final String ID_MENSAJE_AUTENTICACION = "AUTENTIC01";
	public static final String ID_MENSAJE_DEPOSITO = "TRADEPOSIT";
	public static final String ID_MENSAJE_RETIRO = "TRARETIROV";



	public boolean validateBobyHash() {
		return DigestUtils.md5Hex(this.cuerpo.asTexto()).equals(cabecera.getVerificacion());

	}

	public void setCuerpo(Cuerpo cuerpo) {
		this.cuerpo = cuerpo;
		this.cabecera.setLongitudCuerpo(String.valueOf(this.cuerpo.asTexto().length()));
		this.cabecera.setVerificacion(DigestUtils.md5Hex(this.cuerpo.asTexto()));

	}

	public Cuerpo getCuerpo() {

		return cuerpo;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String asTexto() {

		return this.cabecera.asTexto() + this.cuerpo.asTexto();

	}

	public abstract boolean build(String input);

	public boolean validate(String input) {

		return input.length() >= Cabecera.HEADER_LENGTH;
	}

	public Cabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}

}
