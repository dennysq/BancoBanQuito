package ec.edu.espe.distribuidas.banco;

import ec.edu.espe.distribuidas.banco.consultas.CuentaClienteRQ;
import ec.edu.espe.distribuidas.banco.consultas.InfoClienteRQ;
import ec.edu.espe.distribuidas.banco.seguridad.AutenticacionRQ;
import ec.edu.espe.distribuidas.banco.transacciones.RetiroRQ;

public class MensajeRQ extends Mensaje {
	public MensajeRQ() {
	}

	public MensajeRQ(String originador, String idMensaje) {
		this.cabecera = new Cabecera(Mensaje.TIPO_MENSAJE_REQUEST, originador, idMensaje);
	}

	@Override
	public boolean build(String input) {
		boolean result = true;
		if (validate(input)) {
			this.cabecera = new Cabecera();
			// Prueba repositorio GIT
			if (this.cabecera.build(input.substring(0, Cabecera.HEADER_LENGTH))) {
				// se obtiene el resto del mensaje que seria el cuerpo
				String cuerpo = input.substring(Cabecera.HEADER_LENGTH);
				if (this.cabecera.getTipoMensaje().equals(Mensaje.TIPO_MENSAJE_REQUEST)) {
					switch (this.cabecera.getIdMensaje()) {
					case ID_MENSAJE_RETIRO:
						// TODO MARCO PALACIOS
						RetiroRQ retRQ = new RetiroRQ();
						retRQ.build(cuerpo);
						this.cuerpo = retRQ;
						break;
					case ID_MENSAJE_AUTENTICACION:
						AutenticacionRQ auth = new AutenticacionRQ();
						auth.build(cuerpo);
						this.cuerpo = auth;
						break;
					case ID_MENSAJE_CUENTACLIENTE:
						CuentaClienteRQ accountRQ = new CuentaClienteRQ();
						accountRQ.build(cuerpo);
						this.cuerpo = accountRQ;
						break;
					case ID_MENSAJE_DEPOSITO:
						// TODO LUIS VALDEBENITO
						break;
					case ID_MENSAJE_INFOCLIENTE:
						InfoClienteRQ infoRQ = new InfoClienteRQ();
						infoRQ.build(cuerpo);
						this.cuerpo = infoRQ;
						break;
					default:
						result = false;
					}
				} else {
					result = false;
				}

			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;

	}

}
