package visitor;

import ast.*;
/**
 * Interfaccia in cui sono contenuti tutti i metodi usati per implementare nella classi
 * TypeCheckingVisitor e CodeGeneratorVisitor il pattern comportamentale visitor.
 * @author Luca Monteleone
 * */
public interface IVisitor {
	/** 
	 * Metodo visit per il NodeAssign
	 * @author Luca Monteleone
	 * @param node NodeAssign
	 * */
	public abstract void visit(NodeAssign node);
	/** 
	 * Metodo visit per il NodeBinOp
	 * @author Luca Monteleone
	 * @param node NodeBinOp
	 * */
	public abstract void visit(NodeBinOp node);
	/** 
	 * Metodo visit per il NodeConvert
	 * @author Luca Monteleone
	 * @param node NodeConvert
	 * */
	public abstract void visit(NodeConvert node);
	/** 
	 * Metodo visit per il NodeCost
	 * @author Luca Monteleone
	 * @param node NodeCost
	 * */
	public abstract void visit(NodeCost node);
	/** 
	 * Metodo visit per il NodeDecl
	 * @author Luca Monteleone
	 * @param node NodeDecl
	 * */
	public abstract void visit(NodeDecl node);
	/** 
	 * Metodo visit per il NodeDeref
	 * @author Luca Monteleone
	 * @param node NodeDeref
	 * */
	public abstract void visit(NodeDeref node);
	/** 
	 * Metodo visit per il NodeId
	 * @author Luca Monteleone
	 * @param node NodeId
	 * */
	public abstract void visit(NodeId node);
	/** 
	 * Metodo visit per il NodePrint
	 * @author Luca Monteleone
	 * @param node NodePrint
	 * */
	public abstract void visit(NodePrint node);
	/** 
	 * Metodo visit per il NodeProgram
	 * @author Luca Monteleone
	 * @param node NodeProgram
	 * */
	public abstract void visit(NodeProgram node);
	
}
