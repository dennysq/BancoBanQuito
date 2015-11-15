package ec.edu.espe.distribuidas.banco;

public class MensajeRS extends Mensaje {

	public MensajeRS(String originador, String idMensaje) {
		this.cabecera = new Cabecera(Mensaje.TIPO_MENSAJE_RESPONSE, originador, idMensaje);
	}

}
