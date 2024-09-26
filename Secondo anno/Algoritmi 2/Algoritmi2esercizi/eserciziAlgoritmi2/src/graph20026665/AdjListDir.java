package graph20026665;

import java.util.NoSuchElementException;
import java.util.Set;

import upo.graph.base.Graph;
import upo.graph.base.VisitForest;

public class AdjListDir implements Graph {

	@Override
	public void addEdge(String arg0, String arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addVertex(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Set<String>> connectedComponents() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsEdge(String arg0, String arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsVertex(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> getAdjacent(String arg0) throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitForest getBFSTree(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getVertexLabel(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdjacent(String arg0, String arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCyclic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDAG() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return 0;
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

}
