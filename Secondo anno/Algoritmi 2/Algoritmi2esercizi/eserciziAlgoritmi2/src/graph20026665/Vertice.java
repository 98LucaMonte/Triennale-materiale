package graph20026665;
import upo.graph.base.VisitForest;

public class Vertice {
	
	protected String nome;
	protected VisitForest tipo;
	
	protected Vertice(String nome) {
		this.nome = nome;
	}

	protected String getNome() {
		return this.nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}
	
}
