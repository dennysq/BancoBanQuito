package ec.edu.espe.distribuidas.banco.test;

import org.apache.commons.codec.digest.DigestUtils;

import ec.edu.espe.distribuidas.banco.Mensaje;
import ec.edu.espe.distribuidas.banco.MensajeRQ;
import ec.edu.espe.distribuidas.banco.MensajeRS;
import ec.edu.espe.distribuidas.banco.consultas.CuentaClienteRQ;
import ec.edu.espe.distribuidas.banco.consultas.CuentaClienteRS;
import ec.edu.espe.distribuidas.banco.consultas.InfoClienteRQ;
import ec.edu.espe.distribuidas.banco.consultas.InfoClienteRS;
import ec.edu.espe.distribuidas.banco.seguridad.AutenticacionRQ;
import ec.edu.espe.distribuidas.banco.transacciones.DepositoRQ;

public class Tester {

	public static void main(String[] args) {
		AutenticacionRQ arq = new AutenticacionRQ();
		arq.setUsuario("hendrix");
		arq.setClave("1234");
		MensajeRQ mensajeRq = new MensajeRQ("12345678", Mensaje.ID_MENSAJE_AUTENTICACION);
		mensajeRq.setCuerpo(arq);
		System.out.println(mensajeRq.asTexto());
		System.out.println("==================================================================");

		InfoClienteRQ icr = new InfoClienteRQ();
		icr.setTipoDocumento("CEDUL");
		icr.setValor("0604133546");
		mensajeRq = new MensajeRQ("12345678", Mensaje.ID_MENSAJE_INFOCLIENTE);
		mensajeRq.setCuerpo(icr);
		System.out.println(mensajeRq.asTexto());
		System.out.println("==================================================================");

		CuentaClienteRQ ccr = new CuentaClienteRQ();
		ccr.setCodigoCliente("000001111");
		mensajeRq = new MensajeRQ("12345678", Mensaje.ID_MENSAJE_CUENTACLIENTE);
		mensajeRq.setCuerpo(ccr);
		System.out.println(mensajeRq.asTexto());
		System.out.println("==================================================================");

		DepositoRQ dr = new DepositoRQ();
		dr.setNumeroCuenta("000001111");
		dr.setTipoCuenta("AH");
		dr.setValor("1234567.12");
		dr.setTipoDocumentoDepositante("CEDUL");
		dr.setValorDocumentoDepositante("0604133546");
		mensajeRq = new MensajeRQ("12345678", Mensaje.ID_MENSAJE_DEPOSITO);
		mensajeRq.setCuerpo(dr);
		System.out.println(mensajeRq.asTexto());
		System.out.println(
				"===============================================================================================================");
		// sha1Hex
		// md2md5
		// DigestUtil
		MensajeRS mensajeRs = new MensajeRS("12345678", Mensaje.ID_MENSAJE_INFOCLIENTE);
		InfoClienteRS test = new InfoClienteRS();
		test.build("OKO123456789CEDUL|0604133546|Dennys|Quiroz|Armenia 1||0983015478|dennys@gmail.com|1993-12-12");
		mensajeRs.setCuerpo(test);
		System.out.println(mensajeRs.asTexto());
		System.out.println(
				"===============================================================================================================");
		System.out.println(">>>>Prueba cuerpo del mensaje Response para cuentas del cliente, idmensaje="
				+ Mensaje.ID_MENSAJE_CUENTACLIENTE);
		mensajeRs = new MensajeRS("12345678", Mensaje.ID_MENSAJE_CUENTACLIENTE);
		System.out.println(
				"Mensaje Entrante: OKO123456789030001|AH|102,12|20151101122010|0002|CO|2412,12|20151101122010|0003|AH|300,12|20151101122010");
		CuentaClienteRS cuentaClienteRS = new CuentaClienteRS();
		cuentaClienteRS.build(
				"OKO123456789030001|AH|102,12|20151101122010|0002|CO|2412,12|20151101122010|0003|AH|300,12|20151101122010");
		System.out.println("Mensaje construido: " + cuentaClienteRS.asTexto());
		mensajeRs.setCuerpo(cuentaClienteRS);
		System.out.println("Mensaje Response completo con cuerpo: " + mensajeRs.asTexto());
		// System.out.println(cuentaClienteRS);
		// System.out.println(mensajeRs.validateBobyHash());

		// validaciones de mensajes completos
		String message = "RS0000000000001234567820151115104210123CLIBUSCUEN00996fb6aaba394b3b6759160add3b53b070OKO123456789030001|AH||20151101122010|0002|CO|2412,12|20151101122010|0003|AH|300,12|20151101122010";

		System.out.println(
				">>>>Prueba Mensaje Response para cuentas del cliente, idmensaje=" + Mensaje.ID_MENSAJE_CUENTACLIENTE);
		message = "RS0000000000001234567820151116224010898CLIBUSCUEN00996fb6aaba394b3b6759160add3b53b070OKO123456789030001|AH||20151101122010|0002|CO|2412,12|20151101122010|0003|AH|300,12|20151101122010";
		MensajeRS m = new MensajeRS();
		System.out.println("Mensaje Entrante: " + message);
		if (m.build(message)) {

			System.out.println("Mensaje construido: " + m.asTexto());
			System.out.println("Hash Entrante:" + m.getCabecera().getVerificacion());
			System.out.println("Hash Generado del cuerpo:" + DigestUtils.md5Hex(m.getCuerpo().asTexto()));
			System.out.println("Hash correcto?: " + m.validateBobyHash());

		} else {
			System.out.println("Fallo la construcción del mensaje");
		}
	}

}
