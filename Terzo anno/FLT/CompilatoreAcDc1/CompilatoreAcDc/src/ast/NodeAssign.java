package ast;

import visitor.IVisitor;

/** 
 * Questa classe crea e gestisce i nodi per l'assegnamento di un espressione ad una variabile.
 * Tale classe estende la classe NodeStm.
 * @author Luca Monteleone
 * */
public class NodeAssign extends NodeStm{
	
	private NodeId id;
	private NodeExpr expr;
	
	
	/**Costruttore del NodeAssign a cui viene assegnato il NodeId e il NodeExpr
	 * @author Luca Monteleone
	 * @param id il NodeId che viene assegnato al NodeAssign
	 * @param expr il NodeExpr che viene assegnato al NodeAssign
	 * */
	public NodeAssign(NodeId id, NodeExpr expr) {
		super();
		this.id = id;
		this.expr = expr;
	}
	
	/**
	 * Getter che ritorna il NodeId associato al NodeAssign
	 * @author Luca Monteleone
	 * @return ritorna il NodeId associato al NodeAssign
	 * */
	public NodeId getId() {
		return id;
	}
	/** 
	 * Getter che ritorna il NodeExpr associato al NodeAssign
	 * @author Luca Monteleone
	 * @return ritorna il NodeExpr associato al NodeAssign
	 * */
	public NodeExpr getExpr() {
		return expr;
	}
	/** 
	 * Setter che assegna il NodeId associato al NodeAssign
	 * @author Luca Monteleone
	 * @param  id il NodeId che viene assegnato al NodeAssign
	 * 
	 * */
	public void setId(NodeId id) {
		this.id = id;
	}
	/** 
	 * Setter che assegna il NodeId associato al NodeAssign
	 * @author Luca Monteleone
	 * @param  expr il NodeExpr che viene assegnato al NodeAssign
	 * 
	 * */
	public void setExpr(NodeExpr expr) {
		this.expr = expr;
	}
	/**
	 * Metodo che ritorna la stringa che rappresenta il NodeAssign
	 * @author Luca Monteleone
	 * @return stringa che rappresenta il NodeAssign
	 * */
	@Override
	public String toString() {
		return "NodeAssign [id=" + id + ", expr=" + expr + "]";
	}
	/** 
	 * Metodo che va a richiamare il metodo visit del NodeAssign
	 * @author Luca Monteleone
	 * @param visitor interfaccia IVisitor
	 * */
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
}
