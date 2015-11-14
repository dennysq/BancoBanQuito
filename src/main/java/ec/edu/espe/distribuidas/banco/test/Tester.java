package ec.edu.espe.distribuidas.banco.test;

import ec.edu.espe.distribuidas.banco.MensajeRQ;
import ec.edu.espe.distribuidas.banco.consultas.CuentaClienteRQ;
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
		dr.setValor(1234567.12f);
		dr.setTipoDocumentoDepositante("CEDUL");
		dr.setValorDocumentoDepositante("0604133546");
		mensajeRq = new MensajeRQ("12345678", "DEPOCLIE01");
		mensajeRq.setCuerpo(dr);
		System.out.println(mensajeRq.asTexto());
		System.out.println("==================================================================");
		// sha1Hex
		// md2md5
		// DigestUtil
		InfoClienteRS test=new InfoClienteRS();
		test.build("BAD123456789CEDUL|0604133546|Dennys|Quiroz|Armenia 1||0983015478|dennys@gmail.com|1993-12-12");
		System.out.println(test);
		

	}

}
