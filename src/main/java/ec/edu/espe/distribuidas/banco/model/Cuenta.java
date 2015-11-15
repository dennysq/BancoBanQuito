package ec.edu.espe.distribuidas.banco.model;

public class Cuenta {
	private String numeroCuenta;
	private String tipoCuenta;
	private String saldoActual;
	private String fechaYHoraUM;

	public Cuenta() {
		super();
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(String saldoActual) {
		this.saldoActual = saldoActual;
	}

	public String getFechaYHoraUM() {
		return fechaYHoraUM;
	}

	public void setFechaYHoraUM(String fechaYHoraUM) {
		this.fechaYHoraUM = fechaYHoraUM;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", tipoCuenta=" + tipoCuenta + ", saldoActual=" + saldoActual
				+ ", fechaYHoraUM=" + fechaYHoraUM + "]";
	}

}
