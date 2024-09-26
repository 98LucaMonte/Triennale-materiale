package visitor;
import ast.*;
import symbolTabel.*;
/** Questa classe esegue l'analisi semantica dell'AST del codice sorgente. 
*@author Luca Monteleone 
**/
public class TypeCheckingVisitor implements IVisitor {
	
	/** Costruttore del TypeCheckingVisitor in cui viene inizializzata la SymbolTable
	 * in cui inserire le variabili dichiarate all'interno del codice sorgente.  
	 * @author Luca Monteleone
	 * */
	public TypeCheckingVisitor() {
		//inizializzazione della symbolTable
		SymbolTable.init();
	}
	
	/**In tale metodo si va a controllare la correttezza della semantica del NodeAssign
	 * @author Luca Monteleone
	 * @param node NodeAssign su cui eseguire il controllo
	 * */
	@Override
	public void visit(NodeAssign node) {
		
		NodeId id = node.getId();
		NodeExpr expr = node.getExpr();
		id.accept(this);
		expr.accept(this);
		
		if(id.getResType() == TypeDescriptor.Error || expr.getResType() == TypeDescriptor.Error) {
			node.setResType(TypeDescriptor.Error);
		}
		else if(id.getResType() == TypeDescriptor.Int && expr.getResType() == TypeDescriptor.Int) {
			node.setResType(TypeDescriptor.Void);
		}
		else if(id.getResType() == TypeDescriptor.Int && expr.getResType() == TypeDescriptor.Float) {
			//il node sarà Error poichè vogliamo assegnare all'id un espressione float quando l'id è int
			node.setResType(TypeDescriptor.Error);
		}
		else if(id.getResType() == TypeDescriptor.Float && expr.getResType() == TypeDescriptor.Int) {
			//dobbiamo convertire expr da int a float, poichè l'id è float mentre l'espressione è int
			//il node sarà di tipo float
			node.setExpr(this.convert(expr));
			node.setResType(TypeDescriptor.Void);
		}
		else if(id.getResType() == TypeDescriptor.Float && expr.getResType() == TypeDescriptor.Float) {
			node.setResType(TypeDescriptor.Void);
		}
		
		
	}
	
	
	/**In tale metodo si va a controllare la correttezza della semantica del NodeAssign
	 * @author Luca Monteleone
	 * @param node NodeBinOp in cui eseguire il controllo
	 * */
	@Override
	public void visit(NodeBinOp node) {
		
		NodeExpr expr1 = node.getLeft();
		NodeExpr expr2 = node.getRight();
		expr1.accept(this);
		expr2.accept(this);
		
		if(expr1.getResType() == TypeDescriptor.Error || expr2.getResType() == TypeDescriptor.Error) {
			node.setResType(TypeDescriptor.Error); 
		}
		//controlla i tipi di expr1 e expr2
		else if( expr1.getResType().equals(expr2.getResType()) ){
			node.setResType(expr1.getResType());
		}
		//se uno dei due expr è int bisogna trasformare l'altro in float
		else if(expr1.getResType() == TypeDescriptor.Int && expr2.getResType() == TypeDescriptor.Float){
			//Devo convertire expr1 in Float verificare se è corretta la conversione
			NodeExpr exprConv1 = this.convert(expr1);
			node.setLeft(exprConv1);
			node.setResType(TypeDescriptor.Float);
		}
		else if(expr1.getResType() == TypeDescriptor.Float && expr2.getResType() == TypeDescriptor.Int){
			//Devo convertire expr2 in Float verificare se è corretta la conversione
			node.setRight(this.convert(expr2));
			node.setResType(TypeDescriptor.Float);
		}
		
		
	}

	private NodeExpr convert(NodeExpr node) {
		
		NodeExpr expr = new NodeConvert(node);
		expr.setResType(TypeDescriptor.Float);
		return expr;
		
	}
	
	/**In tale metodo si va a controllare la correttezza della semantica del NodeConvert
	 * @author Luca Monteleone
	 * @param node NodeConvert in cui eseguire il controllo
	 * */
	@Override
	public void visit(NodeConvert node) {
		
		NodeExpr expr = node.getExpr();
		expr.accept(this);
		if(expr.getResType() == TypeDescriptor.Error)
			node.setResType(TypeDescriptor.Error);
		else
			node.setResType(TypeDescriptor.Float);
	}
	
	/**In tale metodo si va a controllare la correttezza della semantica del NodeCost
	 * @author Luca Monteleone
	 * @param node NodeCost in cui eseguire il controllo
	 * */
	@Override
	public void visit(NodeCost node) {
		
		if(node.getType() == LangType.INTy) {
			node.setResType(TypeDescriptor.Int);
		}
		else if(node.getType() == LangType.FLOATy) {
			node.setResType(TypeDescriptor.Float);
		}
		else {
			node.setResType(TypeDescriptor.Error);
		}
			
	}
	
	/**In tale metodo si va a controllare la correttezza della semantica del NodeDecl
	 * @author Luca Monteleone
	 * @param node NodeDecl in cui eseguire il controllo
	 * */
	@Override
	public void visit(NodeDecl node) {
		
		NodeId id = node.getId();
		NodeExpr expr = node.getInit();
		
		if(SymbolTable.lookup(node.getId().getName()) == null) {
			if(expr != null)
				expr.accept(this);
			//la variabile non è stata ancora dichiarata viene allora aggiunta alla symbolTable	
			Attributes attr = new Attributes(node.getType());
			id.setDefinitions(attr);
			SymbolTable.enter(id.getName(), attr);
			node.setResType(TypeDescriptor.Void);
			
		}
		else { //la variabile è già stata dichiarata
			node.setResType(TypeDescriptor.Error);
		}
	}
	
	/**In tale metodo si va a controllare la correttezza della semantica del NodeDeref
	 * @author Luca Monteleone
	 * @param node NodeDeref in cui eseguire il controllo
	 * */
	@Override
	public void visit(NodeDeref node) {
		NodeId id = node.getId();
		id.accept(this);
		
		node.setResType(id.getResType());
		
	}
	
	/**In tale metodo si va a controllare la correttezza della semantica del NodeId
	 * @author Luca Monteleone
	 * @param node NodeId in cui eseguire il controllo
	 * */
	@Override
	public void visit(NodeId node) {
		
		//controllo se la variabile è presente nella symbolTable
		if(SymbolTable.lookup(node.getName()) == null) {
			node.setResType(TypeDescriptor.Error);
			//variabile non è stata dichiarata nella symbol table
		}
		else {
			//variabile è stata dichiarata nella symbol table
			//Quindi il tipo del node id deve essere di tipo int o float
			if(SymbolTable.lookup(node.getName()).getType() == LangType.INTy)
				node.setResType(TypeDescriptor.Int);
			
			if(SymbolTable.lookup(node.getName()).getType() == LangType.FLOATy)
				node.setResType(TypeDescriptor.Float);
			
			node.setDefinitions(SymbolTable.lookup(node.getName()));
		}
			
	}
	
	/**In tale metodo si va a controllare la correttezza della semantica del NodePrint
	 * @author Luca Monteleone
	 * @param node NodePrint in cui eseguire il controllo
	 * */
	@Override
	public void visit(NodePrint node) {
		
		NodeId id = node.getId();
		
		id.accept(this);
		
		if(id.getResType() == TypeDescriptor.Error) {
			node.setResType(TypeDescriptor.Error);
			//impossibile fare la stampa poiché la variabile non è stata dichiarata
		}
		else if(id.getResType() == TypeDescriptor.Int || id.getResType() == TypeDescriptor.Float){
			node.setResType(TypeDescriptor.Void);
			//la variabile è stata dichiarata quindi si può stampare
		}

	}
	
	/**In tale metodo si va a controllare la correttezza della semantica del NodeProgram
	 * @author Luca Monteleone
	 * @param node NodeProgram in cui eseguire il controllo
	 * */
	@Override
	public void visit(NodeProgram node) {
		
		node.setResType(TypeDescriptor.Void);
		
		for(NodeDecSt nodeAnalyze :node.getDecSts()) {
			nodeAnalyze.accept(this);	
			
			//Attenzione tutti i nodi presenti in NodeProgram devono essere TypeDescriptor.Void per
			//far si che anche il NodeProgram sia di tipo TypeDescriptor.Void
			if(nodeAnalyze.getResType() ==  TypeDescriptor.Error)
				node.setResType(TypeDescriptor.Error);
		}

	}

}
