package ec.edu.espe.distribuidas.banco;

public interface Cuerpo {
public static final char FIELD_SEPARATOR_CHAR='|';
	public String asTexto();

	public boolean validate(String input);

	public void build(String input);
	
}
