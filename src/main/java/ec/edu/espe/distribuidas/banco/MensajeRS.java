package ec.edu.espe.distribuidas.banco;

import ec.edu.espe.distribuidas.banco.consultas.CuentaClienteRS;
import ec.edu.espe.distribuidas.banco.consultas.InfoClienteRS;
import ec.edu.espe.distribuidas.banco.seguridad.AutenticacionRS;
import ec.edu.espe.distribuidas.banco.transacciones.DepositoRS;
import ec.edu.espe.distribuidas.banco.transacciones.RetiroRS;

public class MensajeRS extends Mensaje {
	public MensajeRS() {
	}

	public MensajeRS(String originador, String idMensaje) {
		this.cabecera = new Cabecera(Mensaje.TIPO_MENSAJE_RESPONSE, originador, idMensaje);
	}

	@Override
	public boolean build(String input) {
		boolean result = true;
		if (validate(input)) {
			this.cabecera = new Cabecera();

			if (this.cabecera.build(input.substring(0, Cabecera.HEADER_LENGTH))) {
				String cuerpo = input.substring(Cabecera.HEADER_LENGTH);

				if (this.cabecera.getTipoMensaje().equals(Mensaje.TIPO_MENSAJE_RESPONSE)) {
					switch (this.cabecera.getIdMensaje()) {
					case ID_MENSAJE_RETIRO:
						// TODO MARCO PALACIOS
						RetiroRS retRS = new RetiroRS();
						retRS.build(cuerpo);
						this.cuerpo = retRS;
						break;
					case ID_MENSAJE_AUTENTICACION:
						AutenticacionRS authRS = new AutenticacionRS();
						authRS.build(cuerpo);
						this.cuerpo = authRS;
						break;
					case ID_MENSAJE_CUENTACLIENTE:
						CuentaClienteRS accountRS = new CuentaClienteRS();
						accountRS.build(cuerpo);
						this.cuerpo = accountRS;
						break;
					case ID_MENSAJE_DEPOSITO:
						// TODO LUIS VALDEBENITO
						DepositoRS depRS = new DepositoRS();
						depRS.build(cuerpo);
						this.cuerpo = depRS;
						
						break;
					case ID_MENSAJE_INFOCLIENTE:
						InfoClienteRS infoRS = new InfoClienteRS();
						infoRS.build(cuerpo);
						this.cuerpo = infoRS;
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
