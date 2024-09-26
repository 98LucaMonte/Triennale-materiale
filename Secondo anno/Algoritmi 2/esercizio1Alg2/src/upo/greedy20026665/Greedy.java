package upo.greedy20026665;

import java.util.ArrayList;
import java.util.Map;

public class Greedy {
	
	public Greedy() {
		
	}
	
	/** Calcola una codifica di Huffman per i caratteri contenuti nel vettore characters, date le frequenze 
	 * contenute in f. f[i] contiene la frequenza (in percentuale, 0<=f[i]<=100) del carattere characters[i] 
	 * nel testo per il quale si vuole calcolare la codifica.
	 * </br>CONSIGLIO: potete estendere o usare un vostro grafo non pesato non orientato per rappresentare la 
	 * foresta di Huffman.
	 * </br>CONSIGLIO2: potete implementate una PriorityQueue dall'interfaccia in upo.additionalstructures,
	 * oppure aggiungere al grafo del primo consiglio delle priorità.
	 * 
	 * @param characters i caratteri dell'alfabeto per i quali calcolare la codifica.
	 * @param f le frequenze dei caratteri in characters nel dato testo.
	 * @return una Map che mappa ciascun carattere in una stringa che rappresenta la sua codifica secondo 
	 * l'algoritmo visto a lezione.
	 */
	public static Map<Character,String> getHuffmanCodes(Character[] characters, int[] f) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	/** Trova il massimo insieme di intervalli disgiunti, tra tutti quelli identificati da [starting[i], ending[i]],
	 * (0<=i<=starting.length) utilizzando l'algoritmo Greedy. Il risultato contiene gli indici degli intervalli selezionati.
	 * Ad esempio, con starting=[2,5,6] ed ending=[5,7,8] il risultato sarà uguale a [0,2] perché il massimo insieme
	 * di intervalli disgiunti è {[2,5],[6,8]}.
	 * 
	 * @param starting il vettore dei tempi di inizio degli intervalli
	 * @param ending il vettore dei tempi di fine degli intervalli
	 * @return un vettore contenente gli indici del massimo insieme di intervalli disgiunti
	 * @throws Exception 
	 */
	public static Integer[] getMaxDisjointIntervals(Integer[] starting, Integer[] ending) throws Exception {
		
		if(starting.length != ending.length || starting.length == 0 || ending.length == 0) {
			throw new Exception("Errore nelle lunghezze dei vettori di tempi di inizio e di fine intervalli non sono idonee\n");
		}
		
		//costruisco la lista di intervalli ordinata per tempo di fine intervallo
		ArrayList<Intervallo> intervalliOrdinati = listaIntervalliOrdinati(starting,ending);
		
		//costruisco la soluzione formata dall'insieme di intervalli disgiunti
		Integer [] soluzione = new Integer[starting.length];
		int i = 0,j = 0;
		Intervallo tmp = null;
		for(Intervallo interval : intervalliOrdinati) {
			if(i == 0) {
				tmp = interval;
				soluzione[i] = j;
				i++;
			}
			else if(tmp.getFine() < interval.getInizio()) {
				tmp = interval;
				soluzione[i] = j;
				i++;
			}
			j++;
		}
		
		return soluzione;
	}
	
	private static ArrayList<Intervallo> listaIntervalliOrdinati(Integer [] starting,Integer [] ending){
		
		ArrayList<Intervallo> intervalli = new ArrayList<>();
		//creo un arrayList di intervalli
		for(int i = 0;i < starting.length;i++) {
			Intervallo interval = new Intervallo(starting[i],ending[i]);
			intervalli.add(interval);
		}
		
		//riordino l'array di intervalli per ordine di tempi di fine visita
		Intervallo tmp = null;
		ArrayList<Intervallo> intervalliOrdinati = new ArrayList<>();
		while(!intervalli.isEmpty()) {
			for(int i=0;i < intervalli.size();i++) {
				if(i==0) {
					tmp = intervalli.get(i);
				}
				else if(tmp.getFine() > intervalli.get(i).getFine()) {
					tmp = intervalli.get(i);
				}
			}
			intervalliOrdinati.add(tmp);
			intervalli.remove(tmp);
		}
		
		return intervalliOrdinati;
	}
	
	/** Trova lo scheduling massimale, utilizzando l'algoritmo di Moore, tra i job identificati dai vettori duration e deadline
	 * (duration[i] e deadline[i] sono, rispettivamente, la durata e la scadenza del job L_i). Il risultato contiene, nell'ordine
	 * selezionato dall'algoritmo, gli indici dei job nello scheduling massimale.
	 * 
	 * @param duration il vettore delle durate
	 * @param deadline il vettore delle scadenze
	 * @return un vettore contenente gli indici dei job in uno scheduling massimale
	 */
	public static Integer[] getMooreMaxJobs(Integer[] duration, Integer[] deadline) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
