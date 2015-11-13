package ec.edu.espe.distribuidas.banco;

public class MensajeRS {
	private Cabecera cabecera;
	private Cuerpo cuerpo;
	private static final String TIPO_MENSAJE = "RS";

	public MensajeRS(String originador, String idMensaje) {
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

}
