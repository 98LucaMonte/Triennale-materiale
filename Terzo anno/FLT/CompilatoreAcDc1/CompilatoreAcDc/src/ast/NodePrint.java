package ast;

import visitor.IVisitor;
/** 
 * Questa classe crea e gestisce i nodi per la stampa del valore delle variabili.
 * Tale classe estende la classe NodeStm.
 * @author Luca Monteleone
 * */
public class NodePrint extends NodeStm{
	
	private NodeId id;
	
	/** 
	 * Costruttore del NodePrint a cui viene assegnato il NodeId
	 * @author Luca Monteleone
	 * @param id il NodeId che viene assegnato al NodePrint
	 * */
	public NodePrint(NodeId id) {
		super();
		this.id = id;
	}
	/** 
	 * Getter che ritorna il NodeId associato al NodePrint
	 * @author Luca Monteleone
	 * @return ritorna il NodeId associato al NodePrint
	 * */
	public NodeId getId() {
		return id;
	}
	/** 
	 * Metodo che ritorna la stringa che rappresenta il NodePrint
	 * @author Luca Monteleone
	 * @return stringa che rappresenta il NodePrint
	 * */
	@Override
	public String toString() {
		return "NodePrint [id=" + this.id + "]";
	}
	/** 
	 * Metodo che va a richiamare il metodo visit del NodePrint
	 * @author Luca Monteleone
	 * @param visitor interfaccia IVisitor
	 * */
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

}
