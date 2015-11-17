package ec.edu.espe.distribuidas.banco.transacciones;

import org.apache.commons.lang3.StringUtils;

import ec.edu.espe.distribuidas.banco.Cuerpo;
import ec.edu.espe.distribuidas.banco.util.MyStringUtils;

public class RetiroRS implements Cuerpo {
	// TODO Luis Valdebenito
	private String resultado;
	private String saldoActual;
	
	public RetiroRS() {
		
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(String saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	public RetiroRS(String resultado, String saldoActual) {

		this.resultado = resultado;
		this.saldoActual = saldoActual;
	}

	public boolean validate(String input) {
		
		return input.length() >= 3 && input.length() <= 12;
	}

	public void build(String input) {
		if (this.validate(input)) {
			try{
				if (input.length() < 12) {
					input = StringUtils.rightPad(input, 12, " ");
				}
				String values[] = MyStringUtils.splitByFixedLengths(input, new int[] { 2, 10 });
				this.resultado = values[0];
				if (resultado.equals("00")){
					setSaldoActual(values[1]);
				}
				
			} catch(Exception e){
				e.printStackTrace();
			}
			this.resultado = input;
		}
		

	}

	@Override
	public String asTexto() {
		
		return resultado + saldoActual;
	}

}
