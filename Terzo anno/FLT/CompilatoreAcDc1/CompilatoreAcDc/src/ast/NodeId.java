package ast;

import symbolTabel.Attributes;
import visitor.IVisitor;
/** 
 * Questa classe crea e gestisce i nodi che contengono il nome di una variabile e gli attributi
 * tra cui il tipo della variabile e il registro che gli viene associato.
 * Tale classe estende la classe NodeAST.
 * @author Luca Monteleone
 * */
public class NodeId extends NodeAST{
	
	private String name;
	private Attributes definitions;
	
	/**  
	 * Costruttore del NodeId a cui viene assegnato la stringa che rappresenta il nome della variabile
	 * e l'attributo.
	 * @author Luca Monteleone
	 * @param name la stringa che viene assegnata al NodeId
	 * @param definitions l'attributo che viene assegnato al NodeId
	 * */
	public NodeId(String name,Attributes definitions) {
		super();
		this.name = name;
		this.definitions = definitions;
	}
	/** 
	 * Costruttore del NodeId a cui viene assegnato la stringa che rappresenta il nome della variabile
	 * @author Luca Monteleone
	 * @param name la stringa che viene assegnata al NodeId
	 * */
	public NodeId(String name) {
		super();
		this.name = name;
	}
	/** 
	 * Getter che ritorna la stringa associata al NodeId
	 * @author Luca Monteleone
	 * @return ritorna la stringa associata al NodeId
	 * */
	public String getName() {
		return this.name;
	}
	/** 
	 * Getter che ritorna l'attributo associata al NodeId
	 * @author Luca Monteleone
	 * @return ritorna l'attributo associata al NodeId
	 * */
	public Attributes getDefinitions() {
		return definitions;
	}
	/** 
	 * Setter che assegna l'attributo al NodeId
	 * @author Luca Monteleone
	 * @param  definitions l'attributo che viene assegnato al NodeId
	 * */
	public void setDefinitions(Attributes definitions) {
		this.definitions = definitions;
	}
	/** 
	 * Metodo che ritorna la stringa che rappresenta il NodeId
	 * @author Luca Monteleone
	 * @return stringa che rappresenta il NodeId
	 * */
	@Override
	public String toString() {
		return "NodeId [name=" + name + "]";
	}
	/** 
	 * Metodo che va a richiamare il metodo visit del NodeId
	 * @author Luca Monteleone
	 * @param visitor interfaccia IVisitor
	 * */
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
}
