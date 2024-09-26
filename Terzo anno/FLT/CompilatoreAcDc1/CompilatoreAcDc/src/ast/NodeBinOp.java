package ast;

import visitor.IVisitor;
/** 
 * Questa classe crea e gestisce i nodi per l'assegnamento di un espressione ad una variabile.
 * Tale classe estende la classe NodeExpr.
 * @author Luca Monteleone
 * */
public class NodeBinOp extends NodeExpr{
	
	private LangOper op;
	private NodeExpr left;
	private NodeExpr right;
	
	/** 
	 * Costruttore del NodeBinOp a cui viene assegnato il LangOper, il NodeExpr left e il NodeExpr right.
	 * @author Luca Monteleone
	 * @param op il LangOper che indica il tipo di operazioni da eseguire
	 * @param left il NodeExpr che viene assegnato al NodeBinOp
	 * @param right il NodeExpr che viene assegnato al NodeBinOp 
	 * */
	public NodeBinOp(LangOper op, NodeExpr left, NodeExpr right) {
		super();
		this.op = op;
		this.left = left;
		this.right = right;
	}
	/**
	 * Getter che ritorna il LangOper del NodeBinOp
	 * @author Luca Monteleone
	 * @return ritorna il LangOper
	 * */
	public LangOper getOp() {
		return op;
	}
	/**
	 * Getter che ritorna il NodeExpr a sinistra dell'operatore di NodeBinOp
	 * @author Luca Monteleone
	 * @return ritorna il NodeExpr
	 * */
	public NodeExpr getLeft() {
		return left;
	}
	/**
	 * Getter che ritorna il NodeExpr a destra dell'operatore di NodeBinOp
	 * @author Luca Monteleone
	 * @return ritorna il NodeExpr
	 * */
	public NodeExpr getRight() {
		return right;
	}
	/** 
	 * Setter che assegna il LangOper al NodeBinOp
	 * @author Luca Monteleone
	 * @param  op il LangOper che viene assegnato al NodeBinOp
	 * */
	public void setOp(LangOper op) {
		this.op = op;
	}
	/** 
	 * Setter che assegna il NodeExpr a sinistra dell'operatore al NodeBinOp
	 * @author Luca Monteleone
	 * @param  left uno dei due NodeExpr che viene assegnato al NodeBinOp
	 * */
	public void setLeft(NodeExpr left) {
		this.left = left;
	}
	/** 
	 * Setter che assegna il NodeExpr a destra dell'operatore al NodeBinOp
	 * @author Luca Monteleone
	 * @param  right uno dei due NodeExpr che viene assegnato al NodeBinOp
	 * */
	public void setRight(NodeExpr right) {
		this.right = right;
	}
	/** 
	 * Metodo che ritorna la stringa che rappresenta il NodeBinOp
	 * @author Luca Monteleone
	 * @return stringa che rappresenta il NodeBinOp
	 * */
	@Override
	public String toString() {
		return "NodeBinOp [op=" + op + ", left=" + left + ", right=" + right + "]";
	}
	/** 
	 * Metodo che va a richiamare il metodo visit del NodeBinOp
	 * @author Luca Monteleone
	 * @param visitor interfaccia IVisitor
	 * */
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
}
