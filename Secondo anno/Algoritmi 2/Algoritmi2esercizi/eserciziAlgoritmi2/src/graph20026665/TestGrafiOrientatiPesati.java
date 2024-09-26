package graph20026665;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestGrafiOrientatiPesati {
	
	AdjListDirWeight graphDirWeight;
	
	@BeforeEach
	void setUp() throws Exception {
		this.graphDirWeight = new AdjListDirWeight();
	}
	
	@Test
	void aggiungiVertice() {
		
		String nomeVertice = "A";
		String nomeVertice1 = "B";
	
		this.graphDirWeight.addVertex(nomeVertice);
		Assertions.assertEquals(1, this.graphDirWeight.size());
		Assertions.assertTrue(this.graphDirWeight.containsVertex(nomeVertice));
		Assertions.assertFalse(this.graphDirWeight.containsVertex(nomeVertice1));
		
		this.graphDirWeight.addVertex(null);
		Assertions.assertEquals(1, this.graphDirWeight.size());
		Assertions.assertFalse(this.graphDirWeight.containsVertex(null));
		
		this.graphDirWeight.addVertex(nomeVertice);
		Assertions.assertEquals(1, this.graphDirWeight.size());
		
		this.graphDirWeight.addVertex(nomeVertice1);
		Assertions.assertEquals(2, this.graphDirWeight.size());
		Assertions.assertTrue(this.graphDirWeight.containsVertex(nomeVertice1));
		Assertions.assertTrue(this.graphDirWeight.containsVertex(nomeVertice));
	}
	
	@Test
	void checkVertice() {
		
		String nomeVertice = "A";
		String nomeVertice1 = "B";
	
		this.graphDirWeight.addVertex(nomeVertice);
		Assertions.assertTrue(this.graphDirWeight.containsVertex(nomeVertice));
		Assertions.assertFalse(this.graphDirWeight.containsVertex(nomeVertice1));
		this.graphDirWeight.addVertex(null);
		Assertions.assertFalse(this.graphDirWeight.containsVertex(null));
	}
	
	@Test
	void aggiungiArco() {
		
		String nomeVertice = "A";
		String nomeVertice1 = "B";
		
		this.graphDirWeight.addVertex(nomeVertice);
		this.graphDirWeight.addVertex(nomeVertice1);
		this.graphDirWeight.addEdge(nomeVertice, nomeVertice1);
		Assertions.assertTrue(this.graphDirWeight.containsEdge(nomeVertice,nomeVertice1));
	
		Assertions.assertThrows(IllegalArgumentException.class, ()-> this.graphDirWeight.addEdge(null, null));	
	}
	
}
