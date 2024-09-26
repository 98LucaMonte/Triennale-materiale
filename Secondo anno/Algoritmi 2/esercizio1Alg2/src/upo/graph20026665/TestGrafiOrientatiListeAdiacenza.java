package upo.graph20026665;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upo.graph.base.VisitForest;
import upo.graph.base.VisitForest.Color;
import upo.graph.base.WeightedGraph;

class TestGrafiOrientatiListeAdiacenza {

	AdjListDirWeight graphDirWeight;
	
	@BeforeEach
	void setUp() throws Exception {
		this.graphDirWeight = new AdjListDirWeight();
	}

	@Test
	void add_Contains_Vertex() {
		
		String nomeVertice = "A";
		String nomeVertice1 = "B";
		
		///controllo inserimento di un vertice
		this.graphDirWeight.addVertex(nomeVertice);
		Assertions.assertEquals(1, this.graphDirWeight.size());
		Assertions.assertTrue(this.graphDirWeight.containsVertex(nomeVertice));
		Assertions.assertFalse(this.graphDirWeight.containsVertex(nomeVertice1));
		
		//controllo inserimento di null
		this.graphDirWeight.addVertex(null);
		Assertions.assertEquals(1, this.graphDirWeight.size());
		Assertions.assertFalse(this.graphDirWeight.containsVertex(null));
		
		//controllo inserimento di un vertice già presente nel grafo
		this.graphDirWeight.addVertex(nomeVertice);
		Assertions.assertEquals(1, this.graphDirWeight.size());
		
		//controllo inserimento di un ulteriore vertice
		this.graphDirWeight.addVertex(nomeVertice1);
		Assertions.assertEquals(2, this.graphDirWeight.size());
		Assertions.assertTrue(this.graphDirWeight.containsVertex(nomeVertice1));
		Assertions.assertTrue(this.graphDirWeight.containsVertex(nomeVertice));
	}
	
	@Test
	void add_Contains_Edge() {
		
		String nomeVertice = "A";
		String nomeVertice1 = "B";
		
		//controllo se dopo creazione del grafo non sia presente qualche arco
		Assertions.assertFalse(this.graphDirWeight.containsEdge(nomeVertice,nomeVertice1));
		Assertions.assertTrue(0 == this.graphDirWeight.numArchi);
		
		
		this.graphDirWeight.addVertex(nomeVertice);
		this.graphDirWeight.addVertex(nomeVertice1);
		//controllo se esiste un arco che va da "A" verso "B"
		this.graphDirWeight.addEdge(nomeVertice, nomeVertice1);
		Assertions.assertTrue(this.graphDirWeight.containsEdge(nomeVertice,nomeVertice1));
		Assertions.assertFalse(this.graphDirWeight.containsEdge(nomeVertice1,nomeVertice));
		Assertions.assertTrue(1 == this.graphDirWeight.numArchi);
		
		//controllo se esiste un arco che va da "B" verso "A"
		this.graphDirWeight.addEdge(nomeVertice1, nomeVertice);
		Assertions.assertTrue(this.graphDirWeight.containsEdge(nomeVertice1,nomeVertice));
		Assertions.assertTrue(2 == this.graphDirWeight.numArchi);
		
		//controllo inserimento di un arco se vengono passati due vertici null
		this.graphDirWeight.addEdge(null, null);
		Assertions.assertTrue(2 == this.graphDirWeight.numArchi);
		
		//controllo inserimento di un arco già presente nel grafo
		this.graphDirWeight.addEdge(nomeVertice1, nomeVertice);
		Assertions.assertTrue(this.graphDirWeight.containsEdge(nomeVertice1,nomeVertice));
		Assertions.assertTrue(2 == this.graphDirWeight.numArchi);
	}
	
	@Test
	void check_Adjacent() {
		
		String nomeVerticePartenza = "A";
		String nomeVerticeArrivo = "B";
		
		//controllo se aggiungendo l'arco che va da "A" verso "B" vedo se "B" è adiacente ad "A"
		//primo parametro della isAdjacent è il vertice d'arrivo dell'arco 
		//il secondo è il vertice di partenza dell'arco

		this.graphDirWeight.addVertex(nomeVerticePartenza);
		this.graphDirWeight.addVertex(nomeVerticeArrivo);
		this.graphDirWeight.addEdge(nomeVerticePartenza, nomeVerticeArrivo);
		Assertions.assertFalse(this.graphDirWeight.isAdjacent(nomeVerticePartenza, nomeVerticeArrivo));
		Assertions.assertTrue(this.graphDirWeight.isAdjacent(nomeVerticeArrivo, nomeVerticePartenza));
		Assertions.assertFalse(this.graphDirWeight.isAdjacent(null, null));
	}

	@Test
	void check_Vertex_Adjacent() {
		
		String vertex1 = "A";
		String vertex2 = "B";
		String vertex3 = "C";
		String vertex4 = "D";
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		set1.add(vertex2);
		set1.add(vertex3);
		set2.add(vertex4);
		
		this.graphDirWeight.addVertex(vertex1);
		this.graphDirWeight.addVertex(vertex2);
		this.graphDirWeight.addVertex(vertex3);
		this.graphDirWeight.addVertex(vertex4);
		this.graphDirWeight.addEdge(vertex1, vertex2);
		this.graphDirWeight.addEdge(vertex1, vertex3);
		this.graphDirWeight.addEdge(vertex2, vertex4);
		this.graphDirWeight.addEdge(vertex3, vertex4);
		
		/*controllo che il set di vertici adiacenti siano i vertici adiacenti al vertice 
		 *che va a richiamare il metodo getAdjacent
		*/
		
		Set<String> setVertexAdjacent = this.graphDirWeight.getAdjacent(vertex1);
		Assertions.assertTrue(setVertexAdjacent.size() == 2);
		Assertions.assertEquals(set1, setVertexAdjacent);
		Set<String> setVertexAdjacent1 = this.graphDirWeight.getAdjacent(vertex2);
		Assertions.assertTrue(setVertexAdjacent1.size() == 1);
		Assertions.assertEquals(set2, setVertexAdjacent1);
		Set<String> setVertexAdjacent2 = this.graphDirWeight.getAdjacent(vertex3);
		Assertions.assertTrue(setVertexAdjacent2.size() == 1);
		Assertions.assertEquals(set2, setVertexAdjacent2);
		Set<String> setVertexAdjacent3 = this.graphDirWeight.getAdjacent(vertex4);
		Assertions.assertTrue(setVertexAdjacent3.size() == 0);
		
	}

	@Test
	void check_Index_Vertex(){
		
		String vertex = "A";
		String vertex1 = "B";
		String vertex2 = "C";
		String vertex3 = "D";
		
		this.graphDirWeight.addVertex(vertex);
		this.graphDirWeight.addVertex(vertex1);
		this.graphDirWeight.addVertex(vertex2);
		this.graphDirWeight.addVertex(vertex3);
		
		Assertions.assertTrue(this.graphDirWeight.getVertexIndex(vertex) == 0);
		Assertions.assertTrue(this.graphDirWeight.getVertexIndex(vertex1) == 1);
		Assertions.assertTrue(this.graphDirWeight.getVertexIndex(vertex2) == 2);
		Assertions.assertTrue(this.graphDirWeight.getVertexIndex(vertex3) == 3);
		Assertions.assertTrue(this.graphDirWeight.getVertexIndex(null) == -1);
		Assertions.assertTrue(this.graphDirWeight.getVertexIndex("VerticeAssente") == -1);
		
	}
	
	@Test
	void check_Label_Vertex() {
		
		String vertex = "A";
		String vertex1 = "B";
		String vertex2 = "C";
		String vertex3 = "D";
		
		this.graphDirWeight.addVertex(vertex);
		this.graphDirWeight.addVertex(vertex1);
		this.graphDirWeight.addVertex(vertex2);
		this.graphDirWeight.addVertex(vertex3);
		
		Assertions.assertTrue(this.graphDirWeight.getVertexLabel(0) == vertex);
		Assertions.assertTrue(this.graphDirWeight.getVertexLabel(1) == vertex1);
		Assertions.assertTrue(this.graphDirWeight.getVertexLabel(2) == vertex2);
		Assertions.assertTrue(this.graphDirWeight.getVertexLabel(3) == vertex3);
		
	}

	@Test
	void check_Set_Get_WeightEdge() {
		
		String vertex = "A";
		String vertex1 = "B";
		Double peso = 5.5, peso1 = 1.5;
		
		this.graphDirWeight.addVertex(vertex);
		this.graphDirWeight.addVertex(vertex1);
		
		this.graphDirWeight.addEdge(vertex, vertex1);
		Assertions.assertTrue(1.0 == this.graphDirWeight.getEdgeWeight(vertex, vertex1));
		this.graphDirWeight.setEdgeWeight(vertex, vertex1, peso);
		Assertions.assertTrue(peso == this.graphDirWeight.getEdgeWeight(vertex, vertex1));
		this.graphDirWeight.setEdgeWeight(vertex, vertex1, peso1);
		Assertions.assertTrue(peso1 == this.graphDirWeight.getEdgeWeight(vertex, vertex1));
		
		
		this.graphDirWeight.setEdgeWeight(vertex1, vertex, peso);
		Assertions.assertTrue(-1.0 == this.graphDirWeight.getEdgeWeight(vertex1, vertex));
		
		this.graphDirWeight.setEdgeWeight(null, null, peso);
		Assertions.assertTrue(-1.0 == this.graphDirWeight.getEdgeWeight(vertex1, vertex));
		
	}

	@Test
	void delete_Edge() {
		
		String vertex1 = "A";
		String vertex2 = "B";
		String vertex3 = "C";
		String vertex4 = "D";
		
		this.graphDirWeight.removeEdge(vertex1, vertex3);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 0);
		
		this.graphDirWeight.addVertex(vertex1);
		this.graphDirWeight.addVertex(vertex2);
		this.graphDirWeight.addVertex(vertex3);
		this.graphDirWeight.addVertex(vertex4);
		this.graphDirWeight.addEdge(vertex1, vertex2);
		this.graphDirWeight.addEdge(vertex1, vertex3);
		this.graphDirWeight.addEdge(vertex2, vertex4);
		this.graphDirWeight.addEdge(vertex3, vertex4);
		this.graphDirWeight.addEdge(vertex4, vertex1);
		
		this.graphDirWeight.removeEdge(vertex3, vertex1);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 5);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex1).size() == 2);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex2).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex3).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex4).size() == 1);
		
		this.graphDirWeight.removeEdge(vertex1, vertex3);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 4);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex1).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex2).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex3).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex4).size() == 1);
		Assertions.assertFalse(this.graphDirWeight.containsEdge(vertex1, vertex3));
		
		this.graphDirWeight.removeEdge(vertex1, vertex3);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 4);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex1).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex2).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex3).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex4).size() == 1);
		Assertions.assertFalse(this.graphDirWeight.containsEdge(vertex1, vertex3));
		
		this.graphDirWeight.removeEdge(null, null);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 4);
		
		this.graphDirWeight.removeEdge(vertex2, vertex4);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 3);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex1).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex2).size() == 0);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex3).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex4).size() == 1);
		Assertions.assertFalse(this.graphDirWeight.containsEdge(vertex2, vertex4));
	}

	@Test
	void check_isCyclic_orDAG() {
		
		String vertex = "A";
		String vertex1 = "B";
		String vertex2 = "C";
		String vertex3 = "D";
		
		this.graphDirWeight.addVertex(vertex);
		this.graphDirWeight.addVertex(vertex1);
		this.graphDirWeight.addVertex(vertex2);
		this.graphDirWeight.addVertex(vertex3);
		this.graphDirWeight.addEdge(vertex, vertex1);
		this.graphDirWeight.addEdge(vertex1, vertex2);
		this.graphDirWeight.addEdge(vertex, vertex3);
		
		Assertions.assertTrue(this.graphDirWeight.isDAG());
		Assertions.assertFalse(this.graphDirWeight.isCyclic());
		
		this.graphDirWeight.addEdge(vertex1, vertex);
		
		Assertions.assertFalse(this.graphDirWeight.isDAG());
		Assertions.assertTrue(this.graphDirWeight.isCyclic());
		Assertions.assertTrue(4 == this.graphDirWeight.numArchi);
		this.graphDirWeight.removeEdge(vertex1, vertex);
		Assertions.assertTrue(3 == this.graphDirWeight.numArchi);
		
	}
	
	@Test
	void delete_Vertex(){
		
		String vertex1 = "A";
		String vertex2 = "B";
		String vertex3 = "C";
		String vertex4 = "D";
		
		this.graphDirWeight.addVertex(vertex1);
		this.graphDirWeight.addVertex(vertex2);
		this.graphDirWeight.addVertex(vertex3);
		this.graphDirWeight.addVertex(vertex4);
		this.graphDirWeight.addEdge(vertex1, vertex2);
		this.graphDirWeight.addEdge(vertex1, vertex3);
		this.graphDirWeight.addEdge(vertex2, vertex4);
		this.graphDirWeight.addEdge(vertex3, vertex4);
		this.graphDirWeight.addEdge(vertex4, vertex1);
		
		this.graphDirWeight.removeVertex(vertex1);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 2);
		Assertions.assertTrue(this.graphDirWeight.size() == 3);
		Assertions.assertFalse(this.graphDirWeight.containsVertex(vertex1));
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex1) == null);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex2).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex3).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex4).size() == 0);
		
		this.graphDirWeight.removeVertex(vertex2);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 1);
		Assertions.assertTrue(this.graphDirWeight.size() == 2);
		Assertions.assertFalse(this.graphDirWeight.containsVertex(vertex2));
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex3).size() == 1);
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex4).size() == 0);
		
		this.graphDirWeight.removeVertex(vertex3);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 0);
		Assertions.assertTrue(this.graphDirWeight.size() == 1);
		Assertions.assertFalse(this.graphDirWeight.containsVertex(vertex3));
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex4).size() == 0);
	
		this.graphDirWeight.removeVertex(vertex4);
		Assertions.assertTrue(this.graphDirWeight.numArchi == 0);
		Assertions.assertTrue(this.graphDirWeight.size() == 0);
		Assertions.assertFalse(this.graphDirWeight.containsVertex(vertex4));
		Assertions.assertTrue(this.graphDirWeight.getAdjacent(vertex4) == null);
	}
	
	@Test
	void check_VisitaBFS() {
		
		String v1 = "A"; 
		String v2 = "B";
		String v3 = "C";
		String v4 = "D";
		Set<String> set = new HashSet<>();
		set.add(v1);
	
		AdjListDir graphDir = new AdjListDir();
		AdjListDirWeight graphDirWeight = new AdjListDirWeight();
		
		graphDirWeight.addVertex(v1);	
		graphDirWeight.addVertex(v2);
		graphDirWeight.addEdge(v1,v2);	
		
		VisitForest visitBFS,visitBFS1,visitBFS2,visitBFS3;
		visitBFS = graphDirWeight.getBFSTree(v1);
		Assertions.assertNull(visitBFS);
		
		graphDir.addVertex(v1);	
		graphDir.addVertex(v2);
		graphDir.addVertex(v3);
		graphDir.addVertex(v4);
		graphDir.addEdge(v1, v2);	
		graphDir.addEdge(v1, v3);	
		graphDir.addEdge(v2, v4);
		graphDir.addEdge(v3, v4);
		
		visitBFS = graphDir.getBFSTree(v1);
		
		Assertions.assertTrue(visitBFS.getColor(v1) == VisitForest.Color.BLACK);
		Assertions.assertTrue(visitBFS.getColor(v2) == VisitForest.Color.BLACK);
		Assertions.assertTrue(visitBFS.getColor(v3) == VisitForest.Color.BLACK);
		Assertions.assertTrue(visitBFS.getColor(v4) == VisitForest.Color.BLACK);
		Assertions.assertTrue(visitBFS.getDistance(v1) == 0);
		Assertions.assertTrue(visitBFS.getDistance(v2) == 1);
		Assertions.assertTrue(visitBFS.getDistance(v3) == 1);
		Assertions.assertTrue(visitBFS.getDistance(v4) == 2);
		//Assertions.assertTrue(visitBFS.getRoots().equals(set));
		
		Assertions.assertTrue(visitBFS.getPartent(v1) == null);
		Assertions.assertTrue(visitBFS.getPartent(v2) == v1);
		Assertions.assertTrue(visitBFS.getPartent(v3) == v1);
		Assertions.assertTrue(visitBFS.getPartent(v4) == v2);

		visitBFS1 = graphDir.getBFSTree(v2);
		
		Assertions.assertTrue(visitBFS1.getColor(v1) == VisitForest.Color.WHITE);
		Assertions.assertTrue(visitBFS1.getColor(v2) == VisitForest.Color.BLACK);
		Assertions.assertTrue(visitBFS1.getColor(v3) == VisitForest.Color.WHITE);
		Assertions.assertTrue(visitBFS1.getColor(v4) == VisitForest.Color.BLACK);
		Assertions.assertTrue(visitBFS1.getDistance(v1) == -1);
		Assertions.assertTrue(visitBFS1.getDistance(v2) == 0);
		Assertions.assertTrue(visitBFS1.getDistance(v3) == -1);
		Assertions.assertTrue(visitBFS1.getDistance(v4) == 1);
		//Assertions.assertTrue(visitBFS1.getRoots().equals(set));
		Assertions.assertTrue(visitBFS1.getPartent(v1) == null);
		Assertions.assertTrue(visitBFS1.getPartent(v2) == null);
		Assertions.assertTrue(visitBFS1.getPartent(v3) == null);
		Assertions.assertTrue(visitBFS1.getPartent(v4) == v2);
		
		visitBFS2 = graphDir.getBFSTree(v3);
		
		Assertions.assertTrue(visitBFS2.getColor(v1) == VisitForest.Color.WHITE);
		Assertions.assertTrue(visitBFS2.getColor(v2) == VisitForest.Color.WHITE);
		Assertions.assertTrue(visitBFS2.getColor(v3) == VisitForest.Color.BLACK);
		Assertions.assertTrue(visitBFS2.getColor(v4) == VisitForest.Color.BLACK);
		Assertions.assertTrue(visitBFS2.getDistance(v1) == -1);
		Assertions.assertTrue(visitBFS2.getDistance(v2) == -1);
		Assertions.assertTrue(visitBFS2.getDistance(v3) == 0);
		Assertions.assertTrue(visitBFS2.getDistance(v4) == 1);
		Assertions.assertTrue(visitBFS2.getPartent(v1) == null);
		Assertions.assertTrue(visitBFS2.getPartent(v2) == null);
		Assertions.assertTrue(visitBFS2.getPartent(v3) == null);
		Assertions.assertTrue(visitBFS2.getPartent(v4) == v3);
		
		visitBFS3 = graphDir.getBFSTree(v4);
		
		Assertions.assertTrue(visitBFS3.getColor(v1) == VisitForest.Color.WHITE);
		Assertions.assertTrue(visitBFS3.getColor(v2) == VisitForest.Color.WHITE);
		Assertions.assertTrue(visitBFS3.getColor(v3) == VisitForest.Color.WHITE);
		Assertions.assertTrue(visitBFS3.getColor(v4) == VisitForest.Color.BLACK);
		Assertions.assertTrue(visitBFS3.getDistance(v1) == -1);
		Assertions.assertTrue(visitBFS3.getDistance(v2) == -1);
		Assertions.assertTrue(visitBFS3.getDistance(v3) == -1);
		Assertions.assertTrue(visitBFS3.getDistance(v4) == 0);
		Assertions.assertTrue(visitBFS3.getPartent(v1) == null);
		Assertions.assertTrue(visitBFS3.getPartent(v2) == null);
		Assertions.assertTrue(visitBFS3.getPartent(v3) == null);
		Assertions.assertTrue(visitBFS3.getPartent(v4) == null);
	}
	
	@Test
	void check_VisitaDFS() {
		
		String v1 = "A"; 
		String v2 = "B";
		String v3 = "C";
		String v4 = "D";
		
		AdjListDirWeight graphDirWeight = new AdjListDirWeight();
		
		graphDirWeight.addVertex(v1);	
		graphDirWeight.addVertex(v2);
		graphDirWeight.addVertex(v3);	
		graphDirWeight.addVertex(v4);
		graphDirWeight.addEdge(v1,v2);
		graphDirWeight.addEdge(v1,v3);
		graphDirWeight.addEdge(v2,v4);
		graphDirWeight.addEdge(v3,v4);
		
		VisitForest visitDFS;
		visitDFS = graphDirWeight.getDFSTree(v1);
		
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == 7);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 1);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 4);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 5);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 6);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 2);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 3);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v3) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v4) == v2);
		
		visitDFS = graphDirWeight.getDFSTree(v2);
	
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.WHITE);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.WHITE);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == -1);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == -1);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 3);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == -1);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == -1);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 1);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 2);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == null);
		Assertions.assertTrue(visitDFS.getPartent(v3) == null);
		Assertions.assertTrue(visitDFS.getPartent(v4) == v2);
		
		visitDFS = graphDirWeight.getDFSTree(v3);
		
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.WHITE);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.WHITE);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == -1);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == -1);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == -1);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == -1);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 3);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 1);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 2);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == null);
		Assertions.assertTrue(visitDFS.getPartent(v3) == null);
		Assertions.assertTrue(visitDFS.getPartent(v4) == v3);
		
		visitDFS = graphDirWeight.getDFSTree(v4);
		
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.WHITE);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.WHITE);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.WHITE);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == -1);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == -1);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == -1);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == -1);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == -1);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == -1);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 1);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == null);
		Assertions.assertTrue(visitDFS.getPartent(v3) == null);
		Assertions.assertTrue(visitDFS.getPartent(v4) == null);
		
	}
	
	@Test
	void check_VisitaDFSTOT() {
		
		String v1 = "A"; 
		String v2 = "B";
		String v3 = "C";
		String v4 = "D";
		String v5 = "E";
		
		AdjListDirWeight graphDirWeight = new AdjListDirWeight();
		
		graphDirWeight.addVertex(v1);	
		graphDirWeight.addVertex(v2);
		graphDirWeight.addVertex(v3);	
		graphDirWeight.addVertex(v4);
		graphDirWeight.addVertex(v5);
		graphDirWeight.addEdge(v1,v2);
		graphDirWeight.addEdge(v1,v3);
		graphDirWeight.addEdge(v2,v4);
		graphDirWeight.addEdge(v3,v4);
		
		VisitForest visitDFS;
		visitDFS = graphDirWeight.getDFSTOTForest(v1);
		
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v5) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == 7);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 1);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 4);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 5);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 6);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 2);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 3);
		Assertions.assertTrue(visitDFS.getStartTime(v5) == 8);
		Assertions.assertTrue(visitDFS.getEndTime(v5) == 9);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v3) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v4) == v2);
		Assertions.assertTrue(visitDFS.getPartent(v5) == null);
		
		visitDFS = graphDirWeight.getDFSTOTForest(v2);
	
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == 4);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == 7);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 3);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 5);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 6);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 1);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 2);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == null);
		Assertions.assertTrue(visitDFS.getPartent(v3) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v4) == v2);
		
		visitDFS = graphDirWeight.getDFSTOTForest(v3);
		
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == 4);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == 7);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 5);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 6);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 3);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 1);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 2);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v3) == null);
		Assertions.assertTrue(visitDFS.getPartent(v4) == v3);
		
		visitDFS = graphDirWeight.getDFSTOTForest(v4);
		
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == 2);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == 7);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 3);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 4);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 5);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 6);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 1);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v3) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v4) == null);
		
	}
	
	@Test
	void checkTopologicalSort() {
		
		//grafo preso dalle slide sull'ordinamento topologico
		String s1 = "A";
		String s2 = "B";
		String s3 = "C";
		String s4 = "D";
		String s5 = "E";
		String s6 = "F";
		String [] result = {s6,s3,s5,s4,s1,s2};
		
		this.graphDirWeight.addVertex(s1);
		this.graphDirWeight.addVertex(s2);
		this.graphDirWeight.addVertex(s3);
		this.graphDirWeight.addVertex(s4);
		this.graphDirWeight.addVertex(s5);
		this.graphDirWeight.addVertex(s6);
		
		this.graphDirWeight.addEdge(s1, s2);
		this.graphDirWeight.addEdge(s3, s4);
		this.graphDirWeight.addEdge(s3, s5);
		this.graphDirWeight.addEdge(s6, s5);
		
		String [] ord = this.graphDirWeight.topologicalSort();
		for(int i=0;i<result.length;i++) {
			Assertions.assertTrue(ord[i] == result[i]);
		}
		
	}
		
	@Test
	void checkEquals() {
		
		String v1 = "A"; 
		String v2 = "B";
		String v3 = "C";
		String v4 = "D";
		
		AdjListDirWeight graph1 = new AdjListDirWeight();
		AdjListDirWeight graph2 = new AdjListDirWeight();
		AdjListDir graph3 = new AdjListDir();
		AdjListDir graph4 = new AdjListDir();
		
		graph1.addVertex(v1);	
		graph1.addVertex(v2);
		graph1.addVertex(v3);	
		graph1.addVertex(v4);
		graph1.addEdge(v1,v2);
		graph1.addEdge(v1,v3);
		graph1.addEdge(v2,v4);
		graph1.addEdge(v3,v4);
		graph1.setEdgeWeight(v3, v4, 5);
		
		graph2.addVertex(v1);	
		graph2.addVertex(v2);
		graph2.addVertex(v3);	
		graph2.addVertex(v4);
		graph2.addEdge(v1,v2);
		graph2.addEdge(v1,v3);
		graph2.addEdge(v2,v4);
		graph2.addEdge(v3,v4);
		graph2.setEdgeWeight(v3, v4, 5);
		
		Assertions.assertTrue(graph1.equals(graph2));
		
		graph2.removeEdge(v2, v4);
		
		Assertions.assertFalse(graph1.equals(graph2));
		
		graph2.addEdge(v2,v4);
		graph2.setEdgeWeight(v3, v4, 10);
		Assertions.assertFalse(graph1.equals(graph2));
		
		graph3.addVertex(v1);	
		graph3.addVertex(v2);
		graph3.addVertex(v3);	
		graph3.addVertex(v4);
		graph3.addEdge(v1,v2);
		graph3.addEdge(v1,v3);
		graph3.addEdge(v2,v4);
		graph3.addEdge(v3,v4);
		
		Assertions.assertFalse(graph3.equals(graph2));
		Assertions.assertFalse(graph1.equals(graph3));
		
		graph4.addVertex(v1);	
		graph4.addVertex(v2);
		graph4.addVertex(v3);	
		graph4.addVertex(v4);
		graph4.addEdge(v1,v2);
		graph4.addEdge(v1,v3);
		graph4.addEdge(v2,v4);
		graph4.addEdge(v3,v4);
		
		Assertions.assertTrue(graph3.equals(graph4));
		
		graph4.removeEdge(v3, v4);
		
		Assertions.assertFalse(graph3.equals(graph4));
		
	}
	
	@Test
	void check_VisitaDFSTOT_Array() {
		
		String v1 = "A"; 
		String v2 = "B";
		String v3 = "C";
		String v4 = "D";
		
		AdjListDirWeight graphDirWeight = new AdjListDirWeight();
		
		graphDirWeight.addVertex(v1);	
		graphDirWeight.addVertex(v2);
		graphDirWeight.addVertex(v3);	
		graphDirWeight.addVertex(v4);
		graphDirWeight.addEdge(v1,v2);
		graphDirWeight.addEdge(v1,v3);
		graphDirWeight.addEdge(v2,v4);
		graphDirWeight.addEdge(v3,v4);
		
		VisitForest visitDFS;
		String [] array1 = {v1,v2,v3,v4};
		visitDFS = graphDirWeight.getDFSTOTForest(array1);
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == 7);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 1);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 4);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 5);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 6);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 2);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 3);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v3) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v4) == v2);
		
		
		String [] array2 = {v2,v4,v3,v1};
		visitDFS = graphDirWeight.getDFSTOTForest(array2);
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == 6);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == 7);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 3);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 4);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 5);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 1);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 2);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == null);
		Assertions.assertTrue(visitDFS.getPartent(v3) == null);
		Assertions.assertTrue(visitDFS.getPartent(v4) == v2);
		
		
		String [] array3 = {v2,v4,v1,v3};
		visitDFS = graphDirWeight.getDFSTOTForest(array3);
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == 4);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == 7);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 3);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 5);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 6);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 1);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 2);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == null);
		Assertions.assertTrue(visitDFS.getPartent(v3) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v4) == v2);
		
		String [] array4 = {v4,v1,v2,v3};
		visitDFS = graphDirWeight.getDFSTOTForest(array4);
		Assertions.assertTrue(visitDFS.getColor(v1) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v2) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v3) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getColor(v4) == Color.BLACK);
		Assertions.assertTrue(visitDFS.getStartTime(v1) == 2);
		Assertions.assertTrue(visitDFS.getEndTime(v1) == 7);
		Assertions.assertTrue(visitDFS.getStartTime(v2) == 3);
		Assertions.assertTrue(visitDFS.getEndTime(v2) == 4);
		Assertions.assertTrue(visitDFS.getStartTime(v3) == 5);
		Assertions.assertTrue(visitDFS.getEndTime(v3) == 6);
		Assertions.assertTrue(visitDFS.getStartTime(v4) == 0);
		Assertions.assertTrue(visitDFS.getEndTime(v4) == 1);
		Assertions.assertTrue(visitDFS.getPartent(v1) == null);
		Assertions.assertTrue(visitDFS.getPartent(v2) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v3) == v1);
		Assertions.assertTrue(visitDFS.getPartent(v4) == null);
		
	}
	
	@Test
	void checkStronglyConnectedComponents() {
		
		String v1 = "A"; 
		String v2 = "B";
		String v3 = "C";
		String v4 = "D";
		String v5 = "E";
		String v6 = "F";
		
		AdjListDirWeight graphDirWeight = new AdjListDirWeight();
		
		graphDirWeight.addVertex(v1);	
		graphDirWeight.addVertex(v2);
		graphDirWeight.addVertex(v3);	
		graphDirWeight.addVertex(v4);
		graphDirWeight.addVertex(v5);	
		graphDirWeight.addVertex(v6);
		graphDirWeight.addEdge(v1,v4);
		graphDirWeight.addEdge(v4,v5);
		graphDirWeight.addEdge(v4,v2);
		graphDirWeight.addEdge(v2,v3);
		graphDirWeight.addEdge(v3,v4);
		graphDirWeight.addEdge(v5,v6);
		graphDirWeight.addEdge(v6,v5);
		
		Set<Set<String>> result = null;
		Set<Set<String>> cfc = new HashSet<Set<String>>();
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		Set<String> set3 = new HashSet<String>();
		
		set1.add(v1);
		cfc.add(set1);
		
		set2.add(v4);
		set2.add(v3);
		set2.add(v2);
		cfc.add(set2);
		
		set3.add(v5);
		set3.add(v6);
		cfc.add(set3);
		
		result = graphDirWeight.stronglyConnectedComponents();
		
		Assertions.assertTrue(result.equals(cfc));
		Assertions.assertTrue(result.size() == cfc.size());
	}
	
	@Test
	void checkBellmanFord() {
		
		String v1 = "A"; 
		String v2 = "B";
		String v3 = "C";
		String v4 = "D";
		String v5 = "E";
		
		AdjListDirWeight graphDirWeight = new AdjListDirWeight();
		
		graphDirWeight.addVertex(v1);	
		graphDirWeight.addVertex(v2);
		graphDirWeight.addVertex(v3);	
		graphDirWeight.addVertex(v4);
		graphDirWeight.addVertex(v5);	
		
		graphDirWeight.addEdge(v1,v3);
		graphDirWeight.addEdge(v1,v4);
		graphDirWeight.addEdge(v1,v5);
		graphDirWeight.addEdge(v3,v2);
		graphDirWeight.addEdge(v4,v5);
		graphDirWeight.addEdge(v4,v2);
		graphDirWeight.addEdge(v5,v3);
		
		graphDirWeight.setEdgeWeight(v1,v3,3);
		graphDirWeight.setEdgeWeight(v1,v4,5);
		graphDirWeight.setEdgeWeight(v1,v5,2);
		graphDirWeight.setEdgeWeight(v3,v2,1);
		graphDirWeight.setEdgeWeight(v4,v5,-6);
		graphDirWeight.setEdgeWeight(v4,v2,-3);
		graphDirWeight.setEdgeWeight(v5,v3,0);
		
		WeightedGraph grafoBellmanFord = graphDirWeight.getBellmanFordShortestPaths(v1);
		
		Assertions.assertTrue(grafoBellmanFord.getEdgeWeight(v3, v2) == 0);
		Assertions.assertTrue(grafoBellmanFord.getEdgeWeight(v5, v3) == -1);
		Assertions.assertEquals(grafoBellmanFord.getEdgeWeight(v1, v4),5);
		Assertions.assertTrue(grafoBellmanFord.getEdgeWeight(v4, v5) == -1);
		
	}

}
