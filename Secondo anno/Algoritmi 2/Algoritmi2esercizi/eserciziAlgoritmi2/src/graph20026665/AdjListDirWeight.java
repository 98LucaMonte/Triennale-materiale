package graph20026665;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.*;
import upo.graph.base.VisitForest;
import upo.graph.base.WeightedGraph;

public class AdjListDirWeight implements WeightedGraph {
	
	private ArrayList<Vertice> nodi;
	private HashMap<Integer,LinkedList<Arco>> grafo;
	private Integer numArchi;// numero di archi
	
	protected AdjListDirWeight() {
		this.nodi = new ArrayList<Vertice>();
		this.grafo = new HashMap<Integer,LinkedList<Arco>>();
		this.numArchi = 0;
	}
	
	@Override
	public void addEdge(String arg0, String arg1) throws IllegalArgumentException {
		
		int error = 0;
		
		try {
			if(this.containsVertex(arg0) == false || this.containsVertex(arg1) == false || arg0 == null || arg1 == null) {
				error = 1;
				throw new IllegalArgumentException();
			}
		
			if(this.containsEdge(arg0, arg1) == true) {
				error = 2;
				throw new IllegalArgumentException();
			}
			else {
				Arco a1 = new Arco(arg0,arg1);
				LinkedList<Arco> list = this.grafo.get(this.getVertexIndex(arg0));
				list.add(a1);
				this.grafo.put(this.getVertexIndex(arg0), list);
				this.numArchi++;
			}
		
		}
		catch(IllegalArgumentException e) {
		
			if(error == 1)
				System.out.println("Nel Grafo non sono presenti entrambi i nodi");
			if(error == 2)
				System.out.println("Nel Grafo � gi� presente l'arco");
		
		}
		
	}

	@Override
	public int addVertex(String arg0) {
		
		/* se il vertice non � presente  lo aggiungo 
		 * in entrambi i casi restituisco l'indice dove si
		 * trova il vertice aggiunto o l'indice del vertice 
		 * che era gia presente nel grafo 
		*/
		if(arg0 == null) {
			return -1;
		}
		
		if(this.containsVertex(arg0) == false) {
			Vertice v1 = new Vertice(arg0);
			this.nodi.add(v1);
			LinkedList<Arco> list1 = new LinkedList<>();
			this.grafo.put(this.getVertexIndex(arg0), list1);
		}
		
		return this.getVertexIndex(arg0);
	}

	@Override
	public Set<Set<String>> connectedComponents() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsEdge(String arg0, String arg1) throws IllegalArgumentException {

		try {
		
			if(this.size() == 0) {
				System.out.println("Il grafo � vuoto");
				return false;
			}
		
			if(this.numArchi == 0) {
				System.out.println("Il grafo non contiene archi");
				return false;
			}
			
			if(arg0 == null || arg1 == null) {
				System.out.println("I nomi dei vertici passati non sono validi");
				throw new IllegalArgumentException();
			}
			
			if(this.containsVertex(arg0) == false) {
				System.out.println("Non esiste il vertice "+ arg0 +" perci� non esiste neanche l'arco tra "+ arg0 +"e" + arg1);
				throw new IllegalArgumentException();
			}
		
			if(this.containsVertex(arg1) == false) {
				System.out.println("Non esiste il vertice "+ arg1 +" perci� non esiste neanche l'arco tra "+ arg0 +"e" + arg1);
				throw new IllegalArgumentException();
			}
			
			if(this.isAdjacent(arg0, arg1) == true) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(IllegalArgumentException e) {
			return false;
		}
		
	}

	@Override
	public boolean containsVertex(String arg0) {
				
		if(this.getVertexIndex(arg0) == -1) {
			return false;
		}
		else { 
			return true;
		}
	}

	@Override
	public Set<String> getAdjacent(String arg0) throws NoSuchElementException {
		
		try {
			if(this.containsVertex(arg0) == false) {
				throw new NoSuchElementException();
			}
			
			/*Al set di stringhe aggiungo il nome di tutti i vertici a cui arriva il vertice di partenza
			 * infatti aggiungo il nome dei vertici di arrivo nel set.
			 */
			Set<String> set = new HashSet<>();
			for(Arco a: this.grafo.get(this.getVertexIndex(arg0))) {
				set.add(a.getNomeVerticeArrivo());
			}
			
			return set;
		}
		catch(NoSuchElementException e) {
			System.out.println("Il vertice di nome "+ arg0 + " non appartiene al grafo");
			return null;
		}
		
	}

	@Override
	public VisitForest getBFSTree(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		//applicabile solo ai grafi non pesati quindi qua non � applicabile
		try {
			if(true) {//poich� il nostro grafo � pesato
				throw new UnsupportedOperationException();
			}
			
			/*if(this.containsVertex(arg0) == false) {
				throw new IllegalArgumentException();
			}*/
			
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Il grafo � pesato perci� non � supporttata la visita in ampiezza");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Il vertice non � contenuto nel grafo");
		}
		
		return null;
	}

	@Override
	public VisitForest getDFSTOTForest(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitForest getDFSTOTForest(String[] arg0) throws UnsupportedOperationException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitForest getDFSTree(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getVertexIndex(String arg0) {
		
		/* Ricorda l'indexOf vuole un oggetto dello stesso tipo di oggetti che contiene  
		 * quell'array altrimenti se per esempio li avessi passato una stringa come parametro 
		 * mi ritornerebbe sempre -1 come valore.
		*/
		for(Vertice v1 : nodi) {
			if(v1.getNome().equalsIgnoreCase(arg0)) {
				return this.nodi.indexOf(v1);
			}
		}
		return -1;
	}

	@Override
	public String getVertexLabel(int arg0) {
		
		if(this.nodi.get(arg0)!= null) 
			return this.nodi.get(arg0).getNome();
		else
			return null;
	}

	@Override
	public boolean isAdjacent(String arg0, String arg1) throws IllegalArgumentException {
		
		try {
			if(this.containsVertex(arg0) == false) {
				System.out.println("Il vertice di nome "+arg0+" non � presente nel grafo");
				throw new IllegalArgumentException();
			}
			
			if(this.containsVertex(arg1) == false) {
				System.out.println("Il vertice di nome "+arg1+" non � presente nel grafo");
				throw new IllegalArgumentException();
			}
			
			/* Al suo interno ho tutti i vertici adiacenti al nodo arg0
			 * dopodich� itero all'interno del set dei vertici adiacenti
			 * � appena verifico che esiste un arco che ha il vertice di arrivo dello stesso
			 * nome di arg1 vuol dire che ho trovato l'arco che collega il nodo arg0 e il nodo arg1
			 * perci� i due vertici sono adiacenti
			*/
			Set<String> verticiAdiacenti = this.getAdjacent(arg0);
			
			for(String nomeVerticeArrivo : verticiAdiacenti) {
				if(nomeVerticeArrivo.equalsIgnoreCase(arg1)) {
					return true;
				}
			}
			
			return false;
			
		}
		catch(IllegalArgumentException e) {
			return false;
		}
		
	}
	
	public void inizializza() {
		
		int time = 0;
		Integer [] tempoInzioVisita = new Integer[this.size()];;
		Integer [] tempoFineVisita = new Integer[this.size()];;
		Integer [] predecessori = new Integer[this.size()];
		String  [] colori = new String[this.size()];
		
		for(int i=0;i<this.size();i++) {
			colori[i] = "BIANCO";
			predecessori[i] = null;
			tempoInzioVisita[i] = -1;// con -1 indico che questo vertice non l'ho visitato (in pratica l'infinito)
			tempoFineVisita[i] = -1;//con -1 indico che questo vertice non l'ho visitato (in pratica l'infinito)
		}
		
	}
	
	
	@Override
	public boolean isCyclic() {
		
		if(this.size() == 0 || this.numArchi == 0 || this.numArchi == 1) {
			return false;
		}
		
		inizializza();
		
		
		
		return false;
	}

	@Override
	public boolean isDAG() {
		
		if(this.size() == 0 || this.numArchi == 0 || this.numArchi == 1) {
			return false;
		}
		
		if(this.isCyclic() == false)
			return true;
		else
			return false;
	}
	
	/*
	 *ritorna true poich� il grafo � orientato 
	*/
	@Override
	public boolean isDirected() {
		return true;
	}

	@Override
	public void removeEdge(String arg0, String arg1) throws IllegalArgumentException, NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVertex(String arg0) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		return this.nodi.size();
	}

	@Override
	public Set<Set<String>> stronglyConnectedComponents() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] topologicalSort() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeightedGraph getBellmanFordShortestPaths(String arg0)
			throws UnsupportedOperationException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeightedGraph getDijkstraShortestPaths(String arg0)
			throws UnsupportedOperationException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getEdgeWeight(String arg0, String arg1) throws IllegalArgumentException, NoSuchElementException {
		
		try {
			if(this.containsVertex(arg0) == false || this.containsVertex(arg1) == false) {
				throw new NoSuchElementException();
			}
			
			if(this.containsEdge(arg0, arg1) == false) {
				throw new IllegalArgumentException();
			}
			
			/*Con l'istruzione this.grafo.get(this.getVertexIndex(arg0))
			 *prendo la LinkedList di archi associata al vertice arg0 e dopodich� itero
			 *all'interno di questa linkedlist con un arco a e appena trovo che il nome del vertice di arrivo
			 *e il nome del vertice di partenza concidono con il nome dei vertici che sono stati passati nel 
			 *metodo allora ritorno il peso dell'arco che collega i due vertici.
			*/
			
			for(Arco a: this.grafo.get(this.getVertexIndex(arg0))) {
				if(a.nomeVerticeArrivo.equalsIgnoreCase(arg1) == true && a.nomeVerticePartenza.equalsIgnoreCase(arg0) == true) {
					return a.getPeso();
				}
			}	
		
		}
		catch(IllegalArgumentException e) {
			System.out.println("Nel grafo non esistono entrambi i vertici indicati");
		}
		catch(NoSuchElementException e) {
			System.out.println("Nel grafo non esiste l'arco che va dal vertice "+ arg0 +" fino al vertice "+ arg1);
		}
		
		return -1;//ritorna -1 quando si verifica uno degli errori sopra indicato.
	}

	@Override
	public WeightedGraph getFloydWarshallShortestPaths() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeightedGraph getKruskalMST() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeightedGraph getPrimMST(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEdgeWeight(String arg0, String arg1, double arg2) throws IllegalArgumentException, NoSuchElementException {
		
		try {
			if(this.containsVertex(arg0) == false || this.containsVertex(arg1) == false) {
				throw new NoSuchElementException();
			}
			
			if(this.containsEdge(arg0, arg1) == false) {
				throw new IllegalArgumentException();
			}
			
			/*Con l'istruzione this.grafo.get(this.getVertexIndex(arg0))
			 *prendo la LinkedList di archi associata al vertice arg0 e dopodich� itero
			 *all'interno di questa linkedlist con un arco a e appena trovo che il nome del vertice di arrivo
			 *e il nome del vertice di partenza concidono con il nome dei vertici che sono stati passati nel 
			 *metodo allora imposto il peso dell'arco che collega i due vertici.
			*/
			
			for(Arco a: this.grafo.get(this.getVertexIndex(arg0))) {
				if(a.nomeVerticeArrivo.equalsIgnoreCase(arg1) == true && a.nomeVerticePartenza.equalsIgnoreCase(arg0) == true) {
					a.setPeso(arg2);
					break;
				}
			}	
		
		}
		catch(IllegalArgumentException e) {
			System.out.println("Nel grafo non esistono entrambi i vertici indicati");
		}
		catch(NoSuchElementException e) {
			System.out.println("Nel grafo non esiste l'arco che va dal vertice "+ arg0 +" fino al vertice "+ arg1);
		}
		
	}

}
