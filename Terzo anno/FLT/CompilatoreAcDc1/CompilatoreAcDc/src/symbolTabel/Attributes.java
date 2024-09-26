package symbolTabel;

import ast.LangType;
/**
 * @author Luca Monteleone
 * Questa classe indica il LangType e il registro usati dalla variabile.
 * */
public class Attributes {
	
	private LangType type;
	private char registro;
	
	/**Costruttore dell'Attributes a cui viene assegnato il LangType.
	 * @author Luca Monteleone
	 * @param type ovvero il LangType che viene assegnato all'Attributes
	 * */
	public Attributes(LangType type) {
		this.type = type;
	}
	/** Getter che ritorna il LangType associato all'Attributes
	 * @author Luca Monteleone
	 * @return ritorna il LangType associato all'Attributes
	 * */
	public LangType getType() {
		return type;
	}
	/** Getter che ritorna il char associato al registro 
	 * @author Luca Monteleone
	 * @return ritorna il char associato all'Attributes
	 * */
	public char getRegistro() {
		return registro;
	}
	/** Setter che assegna il registro associato all'Attributo
	 * @author Luca Monteleone
	 * @param  registro ovvero il char che rappresenta il registro associato 
	 * */
	public void setRegistro(char registro) {
		this.registro = registro;
	}
	/** Metodo che ritorna la stringa che rappresenta l'Attributes
	 * @author Luca Monteleone
	 * @return stringa che rappresenta l'Attributes
	 * */
	@Override
	public String toString() {
		return "Attributes [type=" + type + "]";
	}
	
}
