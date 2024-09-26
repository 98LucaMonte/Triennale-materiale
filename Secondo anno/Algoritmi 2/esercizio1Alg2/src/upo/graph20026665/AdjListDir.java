package upo.graph20026665;

import java.util.NoSuchElementException;
import java.util.Set;

import upo.graph.base.Graph;

/**
 * @author Luca Monteleone 20026665
 * @version 2.0
 * @see upo.graph.base.Graph
 */

public class AdjListDir extends AdjListDirWeight implements Graph {

	protected AdjListDir() {
		super();
	}
	
	@Override
	public void setEdgeWeight(String arg0, String arg1, double arg2) throws IllegalArgumentException, NoSuchElementException {
		System.out.println("Siccome il grafo è non pesato il peso di un arco non può essere settato a pesi diversi da 1"); 
		super.setEdgeWeight(arg0, arg1, defaultEdgeWeight);		 
	}
	
	@Override
	public boolean equals(Object o) {
		
		/*Compara this con o per uguaglianza. Restituisce true se i due oggetti 
		 *rappresentano due grafi semanticamente uguali, quindi con lo stesso numero 
		 *di vertici, gli stessi indici e gli stessi archi. Restituisce false altrimenti.
		*/
		
		AdjListDir grafo = null;
		if(o instanceof AdjListDir) {
			grafo = (AdjListDir) o;
		}
		else {
			return false;
		}
		
		if(this.getClass().equals(AdjListDir.class) != grafo.getClass().equals(AdjListDir.class)){
			return false;
		}
		if(this.numArchi != grafo.numArchi || this.size() != grafo.size()) {
			return false;
		}
		for(int i=0; i<this.size() ;i++) {
			if(this.nodi.get(i).getNome() != grafo.nodi.get(i).getNome()) {
				return false;
			}
		}
		
		Set<String> vertexAdjacent1 = null;
		Set<String> vertexAdjacent2 = null;	
		
		for(int i=0;i<this.size();i++) {
			vertexAdjacent1 = this.getAdjacent(this.nodi.get(i).getNome());
			vertexAdjacent2 = this.getAdjacent(grafo.nodi.get(i).getNome());
			if(vertexAdjacent1.equals(vertexAdjacent2) == false) {
				return false;
			}
		}
		
		return true;
	}
	
}
