package ec.edu.espe.distribuidas.banco;

import org.apache.commons.codec.digest.DigestUtils;

public class MensajeRQ {
	private Cabecera cabecera;
	private Cuerpo cuerpo;
	private static final String TIPO_MENSAJE = "RQ";

	public MensajeRQ(String originador, String idMensaje) {
		this.cabecera = new Cabecera(TIPO_MENSAJE, originador, idMensaje);
	}

	public Cabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}

	public Cuerpo getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(Cuerpo cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String asTexto() {
		this.cabecera.setLongitudCuerpo(String.valueOf(this.cuerpo.asTexto().length()));
		this.cabecera
				.setVerificacion(DigestUtils.md5Hex(this.cabecera.asTextoSinVerificacion() + this.cuerpo.asTexto()));
		return this.cabecera.asTexto() + this.cuerpo.asTexto();
		
	}

}
