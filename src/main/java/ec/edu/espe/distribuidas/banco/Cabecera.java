package ec.edu.espe.distribuidas.banco;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Cabecera {
	private String tipoMensaje;
	private String originador;
	private String fecha;
	private String idMensaje;
	private String longitudCuerpo;
	private String verificacion;

	/**
	 * @param tipoMensaje
	 * @param originador
	 * @param idMensaje
	 */
	public Cabecera(String tipoMensaje, String originador, String idMensaje) {
		super();
		this.tipoMensaje = tipoMensaje;
		this.originador = StringUtils.leftPad(originador, 20,"0");;
		this.idMensaje = idMensaje;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		this.fecha = sdf.format(new Date());

	}

	public String getFecha() {
		return fecha;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public String getOriginador() {
		return originador;
	}

	public void setOriginador(String originador) {
		this.originador = StringUtils.leftPad(originador, 20,"0");
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getLongitudCuerpo() {
		return longitudCuerpo;
	}

	public void setLongitudCuerpo(String longitudCuerpo) {
		this.longitudCuerpo = StringUtils.leftPad(longitudCuerpo, 4, "0");
	}

	public String getVerificacion() {
		return verificacion;
	}

	public void setVerificacion(String verificacion) {
		this.verificacion = verificacion;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Cabecera [tipoMensaje=" + tipoMensaje + ", originador=" + originador + ", fecha=" + fecha
				+ ", idMensaje=" + idMensaje + ", longitudCuerpo=" + longitudCuerpo + ", verificacion=" + verificacion
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificacion == null) ? 0 : verificacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cabecera other = (Cabecera) obj;
		if (verificacion == null) {
			if (other.verificacion != null)
				return false;
		} else if (!verificacion.equals(other.verificacion))
			return false;
		return true;
	}

	public String asTexto() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.tipoMensaje);
		sb.append(this.originador);
		sb.append(this.fecha);
		sb.append(this.idMensaje);
		sb.append(this.getLongitudCuerpo());
		sb.append(this.getVerificacion());
		return sb.toString();

	}
	public String asTextoSinVerificacion() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.tipoMensaje);
		sb.append(this.originador);
		sb.append(this.fecha);
		sb.append(this.idMensaje);
		sb.append(this.getLongitudCuerpo());
		return sb.toString();
	}
	

}
