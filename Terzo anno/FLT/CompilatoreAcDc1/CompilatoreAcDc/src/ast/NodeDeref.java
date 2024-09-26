package ast;

import visitor.IVisitor;
/** 
 * Questa classe crea e gestisce i nodi che fanno riferimento ad una variabile che è stata già dichiarata.
 * Tale classe estende la classe NodeExpr.
 * @author Luca Monteleone
 * */
public class NodeDeref extends NodeExpr{
	
	private NodeId id;
	/** 
	 * Costruttore del NodeDeref a cui viene assegnato il NodeId
	 * @author Luca Monteleone
	 * @param id il NodeId che viene assegnato al NodeDeref
	 * */	
	public NodeDeref(NodeId id) {
		super();
		this.id = id;
	}
	/** 
	 * Getter che ritorna il NodeId associato al NodeDeref
	 * @author Luca Monteleone
	 * @return ritorna il NodeId associato al NodeDeref
	 * */
	public NodeId getId() {
		return id;
	}
	/** 
	 * Metodo che ritorna la stringa che rappresenta il NodeDeref
	 * @author Luca Monteleone
	 * @return stringa che rappresenta il NodeDeref
	 * */
	@Override
	public String toString() {
		return "NodeDeref [id=" + id + "]";
	}
	/** 
	 * Metodo che va a richiamare il metodo visit del NodeDeref
	 * @author Luca Monteleone
	 * @param visitor interfaccia IVisitor
	 * */
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
}
