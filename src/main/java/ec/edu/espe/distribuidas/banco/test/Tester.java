package ec.edu.espe.distribuidas.banco.test;

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
		MensajeRQ mensajeRq = new MensajeRQ("12345678", "AUTENTIC01");
		mensajeRq.setCuerpo(arq);
		System.out.println(mensajeRq.asTexto());
		System.out.println("==================================================================");

		InfoClienteRQ icr = new InfoClienteRQ();
		icr.setTipoDocumento("CEDUL");
		icr.setValor("0604133546");
		mensajeRq = new MensajeRQ("12345678", "CLIBUSSIMP");
		mensajeRq.setCuerpo(icr);
		System.out.println(mensajeRq.asTexto());
		System.out.println("==================================================================");

		CuentaClienteRQ ccr = new CuentaClienteRQ();
		ccr.setCodigoCliente("000001111");
		mensajeRq = new MensajeRQ("12345678", "CUENCLIE01");
		mensajeRq.setCuerpo(ccr);
		System.out.println(mensajeRq.asTexto());
		System.out.println("==================================================================");

		DepositoRQ dr = new DepositoRQ();
		dr.setNumeroCuenta("000001111");
		dr.setTipoCuenta("AH");
		dr.setValor("1234567.12");
		dr.setTipoDocumentoDepositante("CEDUL");
		dr.setValorDocumentoDepositante("0604133546");
		mensajeRq = new MensajeRQ("12345678", "TRADEPOSIT");
		mensajeRq.setCuerpo(dr);
		System.out.println(mensajeRq.asTexto());
		System.out.println("===============================================================================================================");
		// sha1Hex
		// md2md5
		// DigestUtil
		MensajeRS mensajeRs = new MensajeRS("12345678", "CLIBUSSIMP");
		InfoClienteRS test = new InfoClienteRS();
		test.build("OKO123456789CEDUL|0604133546|Dennys|Quiroz|Armenia 1||0983015478|dennys@gmail.com|1993-12-12");
		mensajeRs.setCuerpo(test);
		System.out.println(mensajeRs.asTexto());
		System.out.println("===============================================================================================================");
		mensajeRs = new MensajeRS("12345678", "CLIBUSCUEN");
		CuentaClienteRS test2 = new CuentaClienteRS();
		test2.build("OKO123456789030001|AH||20151101122010|0002|CO|2412,12|20151101122010|0003|AH|300,12|20151101122010");
		mensajeRs.setCuerpo(test2);
		System.out.println(mensajeRs.asTexto());
		System.out.println(test2);
		
		
		

	}

}
