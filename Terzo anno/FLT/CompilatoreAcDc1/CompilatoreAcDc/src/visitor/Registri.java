package visitor;

import java.util.ArrayList;
import java.util.Arrays;
/**Questa classe gestisce i registri che vengono associati alle variabili dichiarate nel codice sorgente.  
 * @author Luca Monteleone
 * */
public class Registri {
	
	private static ArrayList<Character> listRegister; 
	
	/**
	 * Metodo usato per creare e inizializzare una nuova lista di registri.
	 * @author Luca Monteleone
	 * */
	public static void init() {
		listRegister = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
	}
	
	/**
	 * Questo metodo rimuove un registro dalla lista dei registri che sono a disposizione
	 * per le variabili del codice sorgente preso in esame. 
	 * @author Luca Monteleone
	 * @return char che rappresenta il registro che viene assegnato ad una variabile
	 * */
	public static char newRegister() {
		char c = listRegister.get(0);
		listRegister.remove(0);
		return c;
	}
	
	
	/**
	 * Questo metodo mi indica il numero di registri disponibili 
	 * per le variabili del codice sorgente preso in esame. 
	 * @author Luca Monteleone
	 * @return int che mi indica il numero di registri a disposizione
	 * */
	public static int size() {
		return (listRegister.size());	
	}
	
}
