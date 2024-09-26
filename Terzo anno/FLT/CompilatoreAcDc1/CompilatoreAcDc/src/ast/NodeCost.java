package ast;

import visitor.IVisitor;
/** 
 * Questa classe crea e gestisce i nodi che rappresentano un numero int o float.
 * Tale classe estende la classe NodeExpr.
 * @author Luca Monteleone
 * */
public class NodeCost extends NodeExpr{
	
	private String value;
	private LangType type;
	/** 
	 * Costruttore del NodeCost a cui viene assegnato la stringa che rappresenta il numero 
	 * int o float e il LangType che indica appunto se il numero è int o float
	 * @author Luca Monteleone
	 * @param value la stringa che viene assegnata al NodeCost
	 * @param type il LangType che viene assegnato al NodeCost
	 * */
	public NodeCost(String value, LangType type) {
		super();
		this.value = value;
		this.type = type;
	}
	/** 
	 * Getter che ritorna la stringa associata al NodeCost. La stringa rappresenta il numero.
	 * @author Luca Monteleone
	 * @return ritorna la stringa associata al NodeCost
	 * */
	public String getValue() {
		return value;
	}
	/** 
	 * Getter che ritorna il LangType associato al NodeCost
	 * @author Luca Monteleone
	 * @return ritorna il LangType associato al NodeCost
	 * */
	public LangType getType() {
		return type;
	}
	/**
	 * Metodo che ritorna la stringa che rappresenta il NodeCost
	 * @author Luca Monteleone
	 * @return stringa che rappresenta il NodeCost
	 * */
	@Override
	public String toString() {
		return "NodeCost [value=" + value + ", type=" + type + "]";
	}
	/**
	 * Metodo che va a richiamare il metodo visit del NodeCost
	 * @author Luca Monteleone
	 * @param visitor interfaccia IVisitor
	 * */
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
	
}
