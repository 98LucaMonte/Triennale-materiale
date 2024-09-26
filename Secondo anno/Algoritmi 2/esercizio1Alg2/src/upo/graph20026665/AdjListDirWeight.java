package upo.graph20026665;
import java.util.*;

import upo.graph.base.VisitForest;
import upo.graph.base.VisitForest.Color;
import upo.graph.base.VisitForest.VisitType;
import upo.graph.base.WeightedGraph;

/**
* @author Luca Monteleone 20026665
* @version 2.0
* @see upo.graph.base.WeightedGraph
*/

public class AdjListDirWeight implements WeightedGraph{
	
	protected ArrayList<Vertice> nodi;
	protected HashMap<Integer,HashMap<String,Double>> grafo;
	protected Integer numArchi;
	
	protected AdjListDirWeight() {
		this.nodi = new ArrayList<Vertice>();
		this.grafo = new HashMap<Integer,HashMap<String,Double>>();
		this.numArchi = 0;
	}
	
	@Override
	public boolean equals(Object o) {
		
		/*Compara this con o per uguaglianza. Restituisce true se i due oggetti 
		 *rappresentano due grafi semanticamente uguali, quindi con lo stesso numero 
		 *di vertici, gli stessi indici e gli stessi archi. Restituisce false altrimenti.
		*/
		AdjListDirWeight grafo = null;
		if(o instanceof AdjListDirWeight) {
			grafo = (AdjListDirWeight) o;
		}
		else {
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
		
		//controlla i pesi dei vari archi in questo caso nel
		//caso dell'AdjListDir non è necessario controllare i pesi degli archi
		//questa parte non è presente per i grafi non pesati poichè tutti gli 
		//archi hanno lo steso peso.
		for(int i=0;i<this.size();i++) {
			vertexAdjacent1 = this.getAdjacent(this.nodi.get(i).getNome());
			vertexAdjacent2 = this.getAdjacent(grafo.nodi.get(i).getNome());
			for(String s: vertexAdjacent1) {
				if(this.getEdgeWeight(this.nodi.get(i).getNome(),s) != grafo.getEdgeWeight(grafo.nodi.get(i).getNome(), s)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	@Override
	public String toString() {

		String grafoStampato = "";
		HashMap<String,Double> map = null;
		Double peso = null;
		System.out.println("CIAO");
		for(Vertice v: this.nodi) {
			grafoStampato  += v.getNome();
			grafoStampato  += ":  ";
			map = this.grafo.get(this.getVertexIndex(v.getNome()));
			for(String s : map.keySet()) {
				peso = map.get(s);
				grafoStampato  += "["+ s + "=" + peso +"]-->";				
			}
			grafoStampato  += "null \n";
		}
		
		return grafoStampato ;
	}
	
	@Override
	public void addEdge(String arg0, String arg1) throws IllegalArgumentException {
		
		int error = 0;
		
		try {
			if(this.containsVertex(arg0) == false || this.containsVertex(arg1) == false || arg0 == null || arg1 == null) {
				error = 1;
				throw new IllegalArgumentException();
			}
			
			if(arg0.equalsIgnoreCase(arg1)) {
				error = 2;
				throw new IllegalArgumentException();
			}
			
			if(this.containsEdge(arg0, arg1) == true) {
				error = 3;
				throw new IllegalArgumentException();
			}
			else {
				HashMap<String, Double> map = this.grafo.get(this.getVertexIndex(arg0));
				map.put(arg1,defaultEdgeWeight);
				this.grafo.put(this.getVertexIndex(arg0), map);
				this.numArchi++;
			}
		
		}
		catch(IllegalArgumentException e) {
		
			if(error == 1)
				System.out.println("Nel Grafo non sono presenti entrambi i nodi");
			if(error == 2)
				System.out.println("Non è possibile creare un cappio ovvero un arco che collega un vertice con se stesso");
			if(error == 3)
				System.out.println("Nel Grafo è già presente l'arco");
		
		}
		
	}
	
	@Override
	public int addVertex(String arg0) {
		
		/* se il vertice non è presente lo aggiungo 
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
			HashMap<String,Double> map = new HashMap<>();
			this.grafo.put(this.getVertexIndex(arg0), map);
		}
		
		return this.getVertexIndex(arg0);
	}

	@Override
	public Set<Set<String>> connectedComponents() throws UnsupportedOperationException {
		
		try {
			if(this.isDirected()) {
				throw new UnsupportedOperationException();
			}
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Operazione non supportata poichè il grafo è diretto.");
		}
		
		return null;
	}

	@Override
	public boolean containsEdge(String arg0, String arg1) throws IllegalArgumentException {

		try {
		
			if(this.size() == 0) {
				System.out.println("Il grafo non contiene vertici e di conseguenza non contiene archi");
				return false;
			}
		
			if(this.numArchi == 0) {
				return false;
			}
			
			if(arg0 == null || arg1 == null) {
				System.out.println("I nomi dei vertici passati non sono validi");
				throw new IllegalArgumentException();
			}
			
			if(this.containsVertex(arg0) == false) {
				System.out.println("Non esiste il vertice "+ arg0 +" perciò non esiste neanche l'arco tra "+ arg0 +"e" + arg1);
				throw new IllegalArgumentException();
			}
		
			if(this.containsVertex(arg1) == false) {
				System.out.println("Non esiste il vertice "+ arg1 +" perciò non esiste neanche l'arco tra "+ arg0 +"e" + arg1);
				throw new IllegalArgumentException();
			}
			
			if(this.isAdjacent(arg1, arg0) == true) {
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
			
			/*Al set di stringhe aggiungo il nome di tutti i vertici adiacenti al vertice
			 * passato al metodo(al metodo passo solo il nome del vertice).
			 */
			Set<String> set = new HashSet<>();
			HashMap<String,Double> map;
			
			for(Vertice nomeVertice : this.nodi) {
				if(nomeVertice.getNome() == arg0) {
					map = this.grafo.get(this.getVertexIndex(nomeVertice.getNome()));
					if(map!=null) {
						for(String s : map.keySet()) {
							set.add(s);
						}
						break;
					}
				}
			}
			
			return set;
		}
		catch(NoSuchElementException e) {
			System.out.println("Il vertice di nome "+ arg0 + " non appartiene al grafo");
			return null;
		}
		
	}
	
	private VisitForest visitaGenerica(VisitForest visita,String sorgente) {
		
		VisitForest.VisitType typeVisit = visita.visitType;
		LinkedList<String> frangia = new LinkedList<>();
		int timer = 0;
		
		/* PROBLEMA AGGIORNAMENTO DEL TIMER per visitaDFSTOT
		 * NOTA BENE : questo ciclo è molto importante poichè serve per 
		 * individuare il tempo di fine visita di un vertice per la visita 
		 * effettuata in precedenza. Siccome questa visitaDFS deve essere una 
		 * visita che va in tutti i nodi devo ritrovare a che punto si era fermato 
		 * il timer nella precedente visita. 
		*/
		if(typeVisit.equals(VisitForest.VisitType.DFS_TOT)) {
			for(Vertice v: this.nodi) {
				if(visita.getEndTime(v.getNome()) > timer) {
					timer = visita.getEndTime(v.getNome()) + 1;
				}
			}
			visita.setStartTime(sorgente, timer);
			timer++;
		}
		
		
		//inizializza per BFS
		if(typeVisit.equals(VisitForest.VisitType.BFS)) {
			for(Vertice v: this.nodi) {
				visita.setColor(v.getNome(), Color.WHITE);
				visita.setDistance(v.getNome(), -1);
				visita.setParent(v.getNome(), null);
			}
			visita.setDistance(sorgente,0);
		}
		//inizializza per DFS e DFS_TOT
		else if(typeVisit.equals(VisitForest.VisitType.DFS)) {
			for(Vertice v: this.nodi) {
				visita.setColor(v.getNome(), Color.WHITE);
				visita.setParent(v.getNome(), null);
				visita.setStartTime(v.getNome(), -1);
				visita.setEndTime(v.getNome(), -1);
			}
			visita.setStartTime(sorgente, timer);
			timer++;
		}
		
		visita.setColor(sorgente, Color.GRAY);
		frangia.add(sorgente);
		Set<String> setAdjacent = null;
		boolean adjacentTrovato = false;
		
		while(frangia.isEmpty() == false) {
			
			setAdjacent = this.getAdjacent(frangia.getFirst());
			adjacentTrovato = false;
			
			for(String vertex :setAdjacent) {
				if(visita.getColor(vertex) == Color.WHITE) {
					visita.setColor(vertex, Color.GRAY);
					visita.setParent(vertex, frangia.getFirst());
					if(typeVisit.equals(VisitForest.VisitType.BFS)) {
						visita.setDistance(vertex, 1 + visita.getDistance(frangia.getFirst()));
						frangia.addLast(vertex);
					}
					else if(typeVisit.equals(VisitForest.VisitType.DFS) || typeVisit.equals(VisitForest.VisitType.DFS_TOT)) {
						adjacentTrovato = true;
						visita.setStartTime(vertex, timer);
						timer++;
						frangia.addFirst(vertex);
						break;
					}
				}
			}
			if(adjacentTrovato == false && (typeVisit.equals(VisitForest.VisitType.DFS_TOT) || typeVisit.equals(VisitForest.VisitType.DFS))) {
				visita.setColor(frangia.getFirst(), Color.BLACK);
				visita.setEndTime(frangia.getFirst(), timer);
				timer++;
				frangia.remove();
			}
			else if(typeVisit.equals(VisitForest.VisitType.BFS)) {
				visita.setColor(frangia.getFirst(), Color.BLACK);
				frangia.remove();
			}
		
		}
		
		return visita;
		
	}
	
	@Override
	public VisitForest getBFSTree(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		
		VisitForest visitaBFS = new VisitForest(this,VisitType.BFS);
		
		try {
			
			if(this.containsVertex(arg0) == false) {
				throw new IllegalArgumentException();
			}
			
			if(this.getClass().equals(AdjListDirWeight.class)){
				throw new UnsupportedOperationException();
			}
			
			visitaBFS = visitaGenerica(visitaBFS,arg0);
			
			return visitaBFS;
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Operazione non supportata per i grafi pesati");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Il vertice "+ arg0 +" non è contenuto nel grafo");
		}
		
		return null;
	}
	
	@Override
	public VisitForest getDFSTOTForest(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		
		VisitForest visitaDFSTOT = new VisitForest(this,VisitForest.VisitType.DFS_TOT);
		
		try {
			if(this.containsVertex(arg0) == false) {
				throw new IllegalArgumentException();
			}
			
			for(Vertice v:this.nodi) {
				visitaDFSTOT.setColor(v.getNome(), Color.WHITE);
				visitaDFSTOT.setStartTime(v.getNome(), -1);
				visitaDFSTOT.setEndTime(v.getNome(), -1);
			}
			
			visitaDFSTOT = visitaGenerica(visitaDFSTOT,arg0);
			
			for(Vertice u:this.nodi) {
				if(visitaDFSTOT.getColor(u.getNome()) == Color.WHITE) {
					visitaDFSTOT = visitaGenerica(visitaDFSTOT,u.getNome());
				}
			}
			
			return visitaDFSTOT;
			
		}catch(IllegalArgumentException e) {
			System.out.println("Il vertice "+ arg0 +" non è contenuto nel grafo");
		}
		
		return null;
	}
	
	@Override
	public VisitForest getDFSTOTForest(String[] arg0) throws UnsupportedOperationException, IllegalArgumentException {
		
		VisitForest visitaDFSTOT = new VisitForest(this,VisitForest.VisitType.DFS_TOT);
		
		try {
			
			//controllo se tutti i nomi dei vertici passati 
			//fanno parte del grafo
			for(int i=0;i<arg0.length;i++) {
				if(this.containsVertex(arg0[i]) == false) {
					throw new IllegalArgumentException(arg0[i]);
				}
			}
			
			for(String nomeVertice: arg0) {
				visitaDFSTOT.setColor(nomeVertice, Color.WHITE);
				visitaDFSTOT.setStartTime(nomeVertice, -1);
				visitaDFSTOT.setEndTime(nomeVertice, -1);
			}
			
			for(String nomeVertice: arg0) {
				if(visitaDFSTOT.getColor(nomeVertice) == Color.WHITE) {
					visitaDFSTOT = visitaGenerica(visitaDFSTOT,nomeVertice);
				}
			}
			
			return visitaDFSTOT;
			
		}
		catch(IllegalArgumentException e){
			System.out.println("Il vertice "+e+" non appartiene al grafo");
		}
		
		return null;
	}
	
	@Override
	public VisitForest getDFSTree(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		
		try {
			
			if(this.containsVertex(arg0) == false) {
				throw new IllegalArgumentException();
			}
			
			VisitForest visitaDFS = new VisitForest(this,VisitType.DFS);
			
			visitaDFS = visitaGenerica(visitaDFS,arg0);
			
			return visitaDFS;
			
		}
		catch(IllegalArgumentException e) {
			System.out.println("Il vertice "+ arg0 +" non è contenuto nel grafo");
		}
		
		return null;
		
	}
	
	@Override
	public int getVertexIndex(String arg0) {
		
		try {
			if(arg0 == null) {
				return -1;
			}
		
			/* Ricorda l'indexOf vuole un oggetto dello stesso tipo di oggetti che contiene  
			 * quell'array altrimenti se per esempio li avessi passato una stringa come parametro 
			 * mi ritornerebbe sempre -1 come valore.
			 */
			for(Vertice v1 : this.nodi) {
				if(v1.getNome().equalsIgnoreCase(arg0)) {
					return this.nodi.indexOf(v1);
				}
			}
		}	
		catch(NullPointerException e) {
			
		}
		
		return -1;
	}

	@Override
	public String getVertexLabel(Integer arg0) {
		
		//ricorda è lazy quindi metti per primo il check del vertice se è null
		if(arg0 == null || arg0 >= this.size() || arg0 < 0)
			return null;
		
		if(this.nodi.get(arg0) != null) 
			return this.nodi.get(arg0).getNome();
		else
			return null;
	}
	
	//String targetVertex == arg0, String sourceVertex == arg1
	@Override
	public boolean isAdjacent(String arg0, String arg1) throws IllegalArgumentException {
		
		try {
			if(this.containsVertex(arg0) == false) {
				System.out.println("Il vertice di nome "+arg0+" non è presente nel grafo");
				throw new IllegalArgumentException();
			}
			
			if(this.containsVertex(arg1) == false) {
				System.out.println("Il vertice di nome "+arg1+" non è presente nel grafo");
				throw new IllegalArgumentException();
			}
			
			Set<String> setAdjacent = this.getAdjacent(arg1);
			boolean trovato = false;
			
			for(String s: setAdjacent) {
				if(s.equalsIgnoreCase(arg0)) {
					trovato  = true;
					break;
				}		
			}
			
			return trovato;
		}
		catch(IllegalArgumentException e) {
			return false;
		}
		
	}
	
	@Override
	public boolean isCyclic() {
		
		if(this.size() == 0 || this.numArchi == 0 || this.numArchi == 1) {
			return false;
		}
		
		//inizializzazione
		Color colori[] = new VisitForest.Color[this.size()];
        int predecessori[] = new int[this.size()];
        for (int index = 0;index < this.size();index++) {
        	colori[index] = Color.WHITE;
        	predecessori[index] = -1;
        }
        //fase di ricerca di un ciclo
        for (Vertice v : this.nodi) {
            if(colori[this.nodi.indexOf(v)] == Color.WHITE && visitaRicCiclo(v, colori, predecessori)) {
                return true;
            }
        }
        
        return false;
	}
	
	private boolean visitaRicCiclo(Vertice v, Color colori[], int predecessori[]) {
        
		colori[this.nodi.indexOf(v)] = Color.GRAY;
		Set<String> nodiAdiacenti = this.getAdjacent(v.getNome());
		
		/*Se il vertice in questione non ha nessun arco 
		 *e quindi nessun nodo adiacente si colora subito di nero
		*/
		if(nodiAdiacenti.isEmpty()) {
			colori[this.nodi.indexOf(v)] = Color.BLACK;
		}
		else {
			for(String s : nodiAdiacenti){
            
				if(colori[getVertexIndex(s)] == Color.WHITE){
				
					predecessori[getVertexIndex(s)] = this.nodi.indexOf(v);
					for(Vertice vr : this.nodi){
						if(vr.getNome() == s){
							if(visitaRicCiclo(vr, colori, predecessori)) {
								return true;
							}
						}
					}    
				}
				else if(colori[getVertexIndex(s)] == Color.GRAY){
					return true;
				}
			}
			colori[this.nodi.indexOf(v)] = Color.BLACK;
		}
		
        return false;
    }

	@Override
	public boolean isDAG() {
		
		if(this.isCyclic() == false)
			return true;
		else
			return false;
	}
	
	/*
	 *ritorna true poichè il grafo è orientato 
	*/
	@Override
	public boolean isDirected() {
		return true;
	}

	@Override
	public void removeEdge(String arg0, String arg1) throws IllegalArgumentException, NoSuchElementException {
		
		try {
			if(this.containsVertex(arg0) == false || this.containsVertex(arg1) == false) {
				throw new IllegalArgumentException();
			}
			if(this.containsEdge(arg0, arg1) == false) {
				throw new NoSuchElementException();
			}
			
			HashMap<String,Double> map = this.grafo.get(this.getVertexIndex(arg0));
			
			for(String nomeVerticeArrivo : map.keySet()) {
				if(nomeVerticeArrivo.equalsIgnoreCase(arg1)) {
					map.remove(arg1);
					this.numArchi--;
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

	@Override
	public void removeVertex(String arg0) throws NoSuchElementException {
		
		try {
			if(this.containsVertex(arg0) == false) {
				throw new NoSuchElementException();
			}
			
			if(arg0 == null) {
				throw new NoSuchElementException();
			}
			
			if(this.numArchi == 0 || this.size() == 1) {
				this.nodi.remove(this.getVertexIndex(arg0));
				return;
			}
			
			//in questo modo elimino tutti gli archi uscenti dal vertice da eliminare
			Set<String> vertexAdjacent = this.getAdjacent(arg0);
			//in questo caso forse non posso richiamare la removeEdge
			//poichè al ritorno dalla chiamata di funzione removeEdge
			//la map è stata modificata e viene lanciata un eccezione (ConcurrentModificationException) 
			//che non riesco a gestire, in questo caso l'arco da eliminare 
			//lo devo cancellare senza la funzione removeEdge facendo un 
			//semplice assegnamento a null ed andando a decrementare il numero di archi
			if(vertexAdjacent != null) {
				for(String nomeVerticeArrivo:vertexAdjacent) {
					this.removeEdge(arg0, nomeVerticeArrivo);
				}
			}
			
			//in questo modo elimino tutti gli archi entranti nel vertice da eliminare 
			for(Vertice v : this.nodi) {
				if(v.getNome().equalsIgnoreCase(arg0) == false) {
					if(this.containsEdge(v.getNome(), arg0)) {
						this.removeEdge(v.getNome(), arg0);
					}
				}	
			}
			
			//aggiorno la HASHMAP contente tutte le liste di adiacenza e i relativi
			//vertici presenti all'interno del grafo
			//ricorda hai fatto la copia del vecchio array attraverso il 
			//ciclo for poichè tramite assegnamento non era sufficiente
			ArrayList<Vertice> arrayVertexOld = new ArrayList<>();
			for(Vertice v: this.nodi) {
				arrayVertexOld.add(v);	
			}
			HashMap<Integer,HashMap<String,Double>> grafoAggiornato = new HashMap<Integer,HashMap<String,Double>>();
			this.nodi.remove(this.getVertexIndex(arg0));
			
			//indice della lista dei vertici aggiornata quindi senza il vertice che ho eliminato
			int index = 0,indexOldArray = 0;
			HashMap<String, Double> map;
			
			for(Vertice v : arrayVertexOld) {
				if(this.nodi.get(index).getNome() == v.getNome()) {
					map = this.grafo.get(indexOldArray);
					grafoAggiornato.put(index,map);
					index++;
				}
				indexOldArray++;
			}
			
			this.grafo.clear();
			this.grafo = grafoAggiornato;
			
		}
		catch(NoSuchElementException e) {
			if(arg0 == null) {
				System.out.println("Il vertice passato non è valido");
			}
			else {
				System.out.println("Il vertice "+arg0+" indicato non esiste nel grafo");
			}
		}
		
	}

	@Override
	public int size() {
		return this.nodi.size();
	}

	@Override
	public Set<Set<String>> stronglyConnectedComponents() throws UnsupportedOperationException {
		
		try {
			if(this.isDirected()==false) {
				throw new UnsupportedOperationException();
			}
			
			//visito tutti i vertici con DFS e costruisco
			//una lista di vertici in ordine decrescente 
			//seguendo i tempi di fine visita
			
			VisitForest visita = new VisitForest(this,VisitForest.VisitType.DFS);	
			String [] ord = new String[this.size()];
			Set<Set<String>> result = null;
			
			for(Vertice v: this.nodi) {
				if(visita.getColor(v.getNome()) == Color.WHITE) {
					visita = this.getDFSTOTForest(v.getNome());
				}
			}
			
			ord = vertexArraySortedByEndOfVisitTimes(visita);
			
			//costruisco il grafo trasposto
			AdjListDirWeight grafoTrasposto = null;
			grafoTrasposto = buildTransposedGraph(this);
			
			/*Visito il grafo trasposto con l'algoritmo visita tutti i vertici DFS
			 *seguendo l'ordine dei vertici dato dall'array di nomi di vertici
			 *trovato nel primo passo 
			*/
			result = visitaGrafoTraspostoDFS(grafoTrasposto,ord);
			
			return result;
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Operazione non supportata poichè il grafo non è diretto.");
		}
		
		return null;
		
	}
	
	private Set<Set<String>> visitaGrafoTraspostoDFS(AdjListDirWeight grafoTrasposto,String [] ord){
		
		Set<Set<String>> setCfc = new HashSet<Set<String>>();
		VisitForest visitaDFS = new VisitForest(this,VisitType.DFS);
		LinkedList<String> frangia = new LinkedList<>();
		Set<String> setAdjacent = null;
		boolean adjacentTrovato = false;
				
		for(String v: ord) {
			visitaDFS.setColor(v, Color.WHITE);
		}
		
		for(String s: ord) {
				
			if(visitaDFS.getColor(s) == Color.WHITE) {
				
				//ricorda hai messo qui il set<String> cfc poichè ogni volta che lo 
				//aggiungevi a result dopo che andavi a fare ulteriori aggiunte venivano
				//modificati i set precedentemente aggiunti invece, andando a creare 
				//un nuovo oggetto ogni volta non vengono perse le nuove aggiunte
				Set<String> cfc = new HashSet<>();
				visitaDFS.setColor(s, Color.GRAY);
				frangia.addFirst(s);
				cfc.add(frangia.getFirst());
				
				while(frangia.isEmpty() == false) {
			
					setAdjacent = grafoTrasposto.getAdjacent(frangia.getFirst());
					adjacentTrovato = false;
				
					for(String vertex: setAdjacent) {
						if(visitaDFS.getColor(vertex) == Color.WHITE) {
							adjacentTrovato = true;
							visitaDFS.setColor(vertex, Color.GRAY);
							frangia.addFirst(vertex);
							cfc.add(frangia.getFirst());
							break;
						}
					}
					if(adjacentTrovato == false) {
						visitaDFS.setColor(frangia.getFirst(), Color.BLACK);
						frangia.remove();
					}
				}	
				
				setCfc.add(cfc);
			}
		}
		
		return setCfc;
	}
	
	private AdjListDirWeight buildTransposedGraph(AdjListDirWeight grafoPartenza) {
		
		AdjListDirWeight grafoTrasposto = new AdjListDirWeight();
		
		for(Vertice v:grafoPartenza.nodi) {
			grafoTrasposto.addVertex(v.getNome());
		}
		
		Set<String> setAdjacent = null;
		for(Vertice v: grafoPartenza.nodi) {
			setAdjacent = grafoPartenza.getAdjacent(v.getNome());
			for(String nomeVertice : setAdjacent) {
				grafoTrasposto.addEdge(nomeVertice, v.getNome());
			}
		}
		
		return grafoTrasposto;
	}

	@Override
	public String[] topologicalSort() throws UnsupportedOperationException {
		/*/L'ordinamento topologico parte dal primo Vertice che si trova 
		 *all'interno dell'array che contiene tutti i vertici presenti nel grafo
		 */
		try {
			if(this.isCyclic()) {
				throw new UnsupportedOperationException();
			}
			
			VisitForest visita; //new VisitForest(this,VisitForest.VisitType.DFS_TOT);	
			String [] ord = new String[this.size()];
			
			/*Valutare se mantenere il ciclo for oppure 
			*se inserire la riga di codice non commentata
			*for(Vertice v: this.nodi) {
			*	if(visita.getColor(v.getNome()) == Color.WHITE) {
			*		visita = this.getDFSTOTForest(v.getNome());
			*	}
			*}*/
			visita = this.getDFSTOTForest(this.nodi.get(0).getNome());
			
			ord = vertexArraySortedByEndOfVisitTimes(visita);
			
			return ord;
			
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Operazione non supportata poichè il grafo non è un DAG.");
		}
		
		return null;
	}
	
	private String[] vertexArraySortedByEndOfVisitTimes(VisitForest visita) {
		
		String [] ord = new String[this.size()];
		Integer [] arrayDFS = new Integer[this.size()];//contiene i tempi di fine visita dei vertici
		Integer [] arrayOrdinato = new Integer[this.size()];//contiene i tempi di fine visita dei verticiOrdinati
		
		//l'array riordinato deve ritonare il nome dei vertici riordinati
		//in ordine decrescente secondo il loro tempo di fine visita che viene ricavato 
		//dalla precedente chiamata alla funzione che esegue una visita in profondità
		//per tutti i vertici presenti nel grafo
		
		for(int i=0;i<this.size();i++) {
			arrayDFS[i] = visita.getEndTime(this.nodi.get(i).getNome());
			arrayOrdinato[i] = visita.getEndTime(this.nodi.get(i).getNome());
		}
		
		Arrays.sort(arrayOrdinato,Collections.reverseOrder());
		
		for(int i=0;i<this.size();i++) {
			for(int j=0;j<this.size();j++) {
				if(arrayOrdinato[i] == arrayDFS[j]) {
					ord[i] = this.getVertexLabel(j);
					break;
				}
			}
		}
		
		return ord;
	}

	//seconda esercitazione
	@Override
	public WeightedGraph getBellmanFordShortestPaths(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		
		WeightedGraph graphBellmanFord = null;
		
		try {
			
			if(this.containsVertex(arg0)==false) {
				throw new IllegalArgumentException();
			}
			
			//inizializzazione
	        String [] predecessori = new String[this.size()];
	        double [] distanze = new double[this.size()];
	        for (int index = 0;index < this.size();index++) {
	        	predecessori[index] = null;
	        	distanze[index] = Double.MAX_VALUE;
	        }  
	        
	        //setto distanza della sorgente da se stessa a 0
	        distanze[this.getVertexIndex(arg0)] = 0;
	        
	        //visitaBellmanFord
	        HashMap<String,Double> mapArchi = null;
	        for(int j = 0; j< this.size();j++) {
	        	for(int i = 0;i < this.size();i++) {
	        		//visito in nodi nell'ordine in cui li ho inseriti
	        		String nomeVerticePartenza = this.nodi.get(i).getNome();
	        		//vado a prendere la Hashmap in cui sono contenuti tutti gli archi che partono dal nodo chiamato nomeVerticePartenza
	        		mapArchi = this.grafo.get(this.getVertexIndex(nomeVerticePartenza));
	        		if(mapArchi != null) {
	        			for(String nomeVerticeArrivo: mapArchi.keySet()) {
	        				if(distanze[this.getVertexIndex(nomeVerticeArrivo)] > distanze[this.getVertexIndex(nomeVerticePartenza)] + this.getEdgeWeight(nomeVerticePartenza, nomeVerticeArrivo)) {
	        					predecessori[this.getVertexIndex(nomeVerticeArrivo)] = nomeVerticePartenza;
	        					distanze[this.getVertexIndex(nomeVerticeArrivo)] = distanze[this.getVertexIndex(nomeVerticePartenza)] + this.getEdgeWeight(nomeVerticePartenza, nomeVerticeArrivo);
	        				}
	        			}
	        		}
	        	}
			}
	        //implemento il nuovo grafo trovato con la visita di BellmanFord
	        graphBellmanFord = grafoBellmanFord(predecessori,distanze);
	        
	        for(int i=0;i<graphBellmanFord.size();i++) {
	        	System.out.println(i+" "+this.nodi.get(i).getNome()+" distanza "+distanze[i]+" predecessore "+predecessori[i]);
	        }
	        
		}
		catch(IllegalArgumentException e) {
			System.out.println("Il vertice non è presente nel grafo");
		}
		
		return graphBellmanFord;
	}
	
	private WeightedGraph grafoBellmanFord(String[] predecessori, double[] distanze) {
		
		WeightedGraph graphBellmanFord = new AdjListDirWeight();
		
		//creo tutti i nodi del grafo
		for(Vertice v: this.nodi) {
			graphBellmanFord.addVertex(v.getNome());
		}
		
		//aggiungo tutti gli archi
		int i = 0;
		for(String s: predecessori) {
			if(s != null) {
				graphBellmanFord.addEdge(s, graphBellmanFord.getVertexLabel(i));
				graphBellmanFord.setEdgeWeight(s, graphBellmanFord.getVertexLabel(i), distanze[i]);
			}
			i++;
		}
		
		
		return graphBellmanFord;
	}

	//seconda esercitazione
	@Override
	public WeightedGraph getDijkstraShortestPaths(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		
		try {
			throw new UnsupportedOperationException();
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Operazione non supportata");
		}
		
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
			
			HashMap<String,Double> map = this.grafo.get(this.getVertexIndex(arg0));
			for(String nomeVerticeArrivo : map.keySet()) {
				if(nomeVerticeArrivo.equalsIgnoreCase(arg1)) {
					return map.get(arg1);
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
	
	//seconda esercitazione
	@Override
	public WeightedGraph getFloydWarshallShortestPaths() throws UnsupportedOperationException {
		
		try {
			throw new UnsupportedOperationException();
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Operazione non supportata");
		}
		
		return null;
	}
	
	//seconda esercitazione
	@Override
	public WeightedGraph getKruskalMST() throws UnsupportedOperationException {
		
		try {
			throw new UnsupportedOperationException();
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Operazione non supportata");
		}
		
		return null;
	}
	
	//seconda esercitazione
	@Override
	public WeightedGraph getPrimMST(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		
		try {
			throw new UnsupportedOperationException();
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Operazione non supportata");
		}
		
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
			
			HashMap<String,Double> map = this.grafo.get(this.getVertexIndex(arg0));
			for(String nomeVerticeArrivo : map.keySet()) {
				if(nomeVerticeArrivo.equalsIgnoreCase(arg1)) {
					map.put(arg1, arg2);
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
