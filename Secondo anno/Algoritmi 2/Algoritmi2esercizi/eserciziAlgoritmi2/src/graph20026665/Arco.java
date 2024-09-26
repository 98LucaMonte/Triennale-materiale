package graph20026665;

public class Arco {

	protected String nomeVerticePartenza;
	protected String nomeVerticeArrivo;
	protected Double peso;
	
	protected Arco(String nomeVerticePartenza, String nomeVerticeArrivo) {
		this.nomeVerticePartenza = nomeVerticePartenza;
		this.nomeVerticeArrivo = nomeVerticeArrivo;
	}

	protected String getNomeVerticePartenza() {
		return nomeVerticePartenza;
	}

	protected void setNomeVerticePartenza(String nomeVerticePartenza) {
		this.nomeVerticePartenza = nomeVerticePartenza;
	}

	protected String getNomeVerticeArrivo() {
		return nomeVerticeArrivo;
	}

	protected void setNomeVerticeArrivo(String nomeVerticeArrivo) {
		this.nomeVerticeArrivo = nomeVerticeArrivo;
	}

	protected Double getPeso() {
		return peso;
	}

	protected void setPeso(Double peso) {
		this.peso = peso;
	}

}
