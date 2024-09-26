package ast;

import visitor.IVisitor;
/** 
 * Questa classe crea e gestisce i nodi per la dichiarazione delle variabili.
 * Gestisce inoltre anche le possibili inizializzazioni associate alle dichiarazioni delle variabili.
 * Tale classe estende la classe NodeDecSt.
 * @author Luca Monteleone
 * */
public class NodeDecl extends NodeDecSt{
	
	private NodeId id;
	private LangType type;
	private NodeExpr init;
	/** 
	 * Costruttore del NodeDecl a cui viene assegnato il NodeId, il LangType e il NodeExpr
	 * @author Luca Monteleone
	 * @param id il NodeId che viene assegnato al NodeDecl
	 * @param type il LangType che viene asseganto al NodeDecl
	 * @param init il NodeExpr che viene assegnato al NodeDecl
	 * */
	public NodeDecl(NodeId id, LangType type, NodeExpr init) {
		super();
		this.id = id;
		this.type = type;
		this.init = init;
	}
	/** 
	 * Getter che ritorna il NodeId associato al NodeDecl
	 * @author Luca Monteleone
	 * @return ritorna il NodeId associato al NodeDecl
	 * */
	public NodeId getId() {
		return id;
	}
	/** 
	 * Getter che ritorna il LangType associato al NodeDecl
	 * @author Luca Monteleone
	 * @return ritorna il LangType associato al NodeDecl
	 * */
	public LangType getType() {
		return type;
	}
	/** 
	 * Getter che ritorna il NodeExpr associato al NodeDecl
	 * @author Luca Monteleone
	 * @return ritorna il NodeExpr associato al NodeDecl
	 * */
	public NodeExpr getInit() {
		return init;
	}
	/** 
	 * Metodo che ritorna la stringa che rappresenta il NodeDecl
	 * @author Luca Monteleone
	 * @return stringa che rappresenta il NodeDecl
	 * */
	@Override
	public String toString() {
		return "NodeDecl [id=" + id + ", type=" + type + ", init=" + init + "]";
	}
	/** 
	 * Metodo che va a richiamare il metodo visit del NodeDecl
	 * @author Luca Monteleone
	 * @param visitor interfaccia IVisitor
	 * */
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

}
