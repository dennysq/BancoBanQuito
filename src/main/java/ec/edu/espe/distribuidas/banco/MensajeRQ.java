package ec.edu.espe.distribuidas.banco;



public class MensajeRQ extends Mensaje {

	public MensajeRQ(String originador, String idMensaje) {
		this.cabecera = new Cabecera(Mensaje.TIPO_MENSAJE_REQUEST, originador, idMensaje);
	}

}
