package upo.greedy20026665;

public class Intervallo implements Comparable<Intervallo>{

	private int inizio;
	private int fine;
	
	public Intervallo(int inizio, int fine){
		if(inizio < 0 || fine < 0) {
			throw new IllegalArgumentException();
		}
		
		this.inizio = inizio;
		this.fine = fine;
	}

	public int getInizio() {
		return inizio;
	}

	public int getFine() {
		return fine;
	}

	@Override
	public String toString() {
		return "["+inizio + ","+ fine + "]";
	}

	@Override
	public int compareTo(Intervallo o) {
		 int r = getFine()-(o.getFine());
	     return r;
	}
	
}
