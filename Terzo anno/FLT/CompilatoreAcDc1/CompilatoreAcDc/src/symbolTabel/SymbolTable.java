package symbolTabel;

import java.util.HashMap;
import java.util.Map.Entry;
/**
 * Classe che rappresenta la tabella in cui sono contenute tutte le variabili dichiarate
 * all'interno del codice sorgente. Nella tabella vengono memorizzate il nome della variabile 
 * associandolo con i suoi attributi. 
 * * @author Luca Monteleone
 * */
public class SymbolTable {
	
	private static HashMap<String, Attributes> table;
	
	/**
	 * Metodo usato per creare una nuova SymbolTable
	 * @author Luca Monteleone
	 * */
	public static void init(){
		table = new HashMap<>();
	}
	
	/**
	 * Metodo usato per inserire un nuovo elemento all'interno della SymbolTable e ritorna true
	 * se tale elemento non è presente nella tabella mentre, non si aggiunge l'elemento 
	 * se tale elemento è già presente nella tabella e si ritorna false. 
	 * @author Luca Monteleone
	 * @param id ovvero la stringa che rappresenta il nome della variabile. 
	 * @param entry ovvero l'attributo da associare alla variabile.
	 * @return boolean che indica se l'elemento è stato aggiunto oppure no.
	 * */
	public static boolean enter(String id, Attributes entry) {
		
		if(lookup(id) == null) {
			table.put(id, entry);
			return true;
		}
		
		return false;
	}
	/**
	 * Metodo usato per verificare se un elemento è presente nella SymbolTable. 
	 * Se è presente ritorna l'attributo associato a tale elemento altrimenti ritorna null.
	 * @author Luca Monteleone
	 * @param id ovvero la stringa che rappresenta il nome della variabile. 
	 * @return Attributes associato al nome della variabile.
	 * */
	public static Attributes lookup(String id) {
		return table.get(id);
	}
	
	/** Metodo che ritorna la stringa che rappresenta la SymbolTable
	 * @author Luca Monteleone
	 * @return stringa che rappresenta la SymbolTable
	 * */
	public static String toStr() {
		
		String str = "SymbolTable\n[";
		
		for(Entry<String, Attributes> entry: table.entrySet()) {
			str += "\n"+entry;
		}
		str += "\n]";
		
		return str;
	}
	
	/**
	 * Metodo che ritorna il numero di elementi presenti nella SymbolTable
	 * @author Luca Monteleone
	 * @return intero che rappresenta il numero di identificatori presenti nella SymbolTable
	 * */
	public static int size() {
		return (table.size());	
	}
}