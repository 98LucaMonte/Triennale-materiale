package upo.greedy20026665;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestGreedy {
	
	Greedy g;
	
	@BeforeEach
	void setUp() throws Exception {
		this.g = new Greedy();
	}
	
	@Test
	void testIntervalliDisgiunti() throws Exception {
		
		Integer [] starting = {2,5,6};
		Integer [] ending = {5,7,8};
		Integer [] solAspettata = {0,2};
		Integer [] sol;
		
		sol = Greedy.getMaxDisjointIntervals(starting, ending);
		for(int i=0;i<solAspettata.length;i++)
			Assertions.assertTrue(sol[i]==solAspettata[i]);
	}

}
