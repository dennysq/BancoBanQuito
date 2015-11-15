package ec.edu.espe.distribuidas.banco;

public interface Cuerpo {

	public String asTexto();

	public boolean validate(String input);

	public void build(String input);
	
}
