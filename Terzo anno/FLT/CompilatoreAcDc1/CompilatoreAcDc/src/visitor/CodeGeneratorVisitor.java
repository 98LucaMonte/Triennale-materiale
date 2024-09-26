package visitor;

import java.util.*;
import ast.*;
import symbolTabel.SymbolTable;

/** Questa classe si occupa di generare la stringa di codice partendo dal AST. 
*@author Luca Monteleone 
**/
public class CodeGeneratorVisitor implements IVisitor{
	
	private HashMap<ast.LangOper,Character> operatori;
	
	/** Costruttore del CodeGeneratorVisitor in cui vengono inizializzati i registri che sono 
	 * a disposizione delle variabili dichiarate all'interno del codice sorgente e inoltre inizializza 
	 * un HashMap che conterrà gli operatori accettabili dal compilatore.  
	 * @author Luca Monteleone
	 * */
	public CodeGeneratorVisitor() {
		super();
		Registri.init();
		this.operatori = new HashMap<>();
		this.operatori.put(ast.LangOper.PLUS, '+');
		this.operatori.put(ast.LangOper.MINUS, '-');
		this.operatori.put(ast.LangOper.DIV, '/');
		this.operatori.put(ast.LangOper.TIMES, '*');
	}
	
	/**In tale metodo si va a settare il codice del NodeAssign andando prima a settare il codice
	 * del NodeId e del NodeExpr che si trovano all'interno del NodeAssign.
	 * @author Luca Monteleone
	 * @param node NodeAssign a cui assegnare la relativa stringa di codice
	 * */
	@Override
	public void visit(NodeAssign node) {
		node.getId().accept(this);
		node.getExpr().accept(this);
		node.setCodice(node.getExpr().getCodice()+" s"+node.getId().getCodice()+" 0 k");	
	}
	
	/**In tale metodo si va a settare il codice del NodeBinOp andando prima a settare il codice
	 * del NodeExpr a sinistra dell'operatore, del NodeExpr a destra dell'operatore 
	 * che si trovano all'interno del NodeBinOp. 
	 * Inoltre se uno dei due NodeExpr ha un TypeDescriptor di tipo float si inserisce 
	 * a priori il cast a float.
	 * @author Luca Monteleone
	 * @param node NodeBinOp a cui assegnare la relativa stringa di codice
	 * */
	@Override
	public void visit(NodeBinOp node) {
		
		String codice = "";
		Character operatore = this.operatori.get(node.getOp());
        node.getLeft().accept(this);
        node.getRight().accept(this);
        codice += node.getLeft().getCodice()+" "+node.getRight().getCodice();
        //Se uno dei due nodi è float allora setta la precisione a 5 k
        if(node.getLeft().getResType() == TypeDescriptor.Float || node.getRight().getResType() == TypeDescriptor.Float)
        	codice += " 5 k";
        
        node.setCodice(codice+" "+operatore+" 0 k");
	}
	
	/**In tale metodo si va a settare il codice del NodeConvert andando prima a settare il codice
	 * del NodeExpr che si trova all'interno del NodeConvert.
	 * @author Luca Monteleone
	 * @param node NodeConvert a cui assegnare la relativa stringa di codice.
	 * */
	@Override
	public void visit(NodeConvert node) {
		node.getExpr().accept(this);
		node.setCodice(node.getExpr().getCodice());
	}
	
	/**In tale metodo si va a settare il codice del NodeCost prendendo la stringa che rappresenta
	 * il valore associato a tale nodo. 
	 * @author Luca Monteleone
	 * @param node NodeCost a cui assegnare la relativa stringa di codice
	 * */
	@Override
	public void visit(NodeCost node) {
		node.setCodice(node.getValue());
	}
	
	/**In tale metodo si va a settare il codice del NodeDecl andando prima a settare il codice
	 * del NodeId che si trova all'interno del NodeDecl. 
	 * In caso oltre alla dichiarazione ci fosse anche l'inizializzazione si setta il codice 
	 * del NodeExpr e anche quest'ultimo si trova all'interno del NodeDecl.
	 * @author Luca Monteleone
	 * @param node NodeDecl a cui assegnare la relativa stringa di codice
	 * */
	@Override
	public void visit(NodeDecl node) {
		node.getId().getDefinitions().setRegistro(Registri.newRegister());
		if(node.getInit()!=null) {
			node.getId().accept(this);
			node.getInit().accept(this);
			node.setCodice(node.getInit().getCodice()+" s"+node.getId().getCodice()+ " 0 k");
		}
	}
	
	/**In tale metodo si va a settare il codice del NodeDeref andando prima a settare il codice
	 * del NodeId che si trova all'interno del NodeDecl. 
	 * @author Luca Monteleone
	 * @param node NodeDeref a cui assegnare la relativa stringa di codice
	 * */
	@Override
	public void visit(NodeDeref node) {
		node.getId().accept(this);
		node.setCodice("l" + node.getId().getCodice());
	}
	
	/**In tale metodo si va a settare il codice del NodeId andando a prendere 
	 * il char che rappresenta il nome del registro. 
	 * @author Luca Monteleone
	 * @param node NodeId a cui assegnare la relativa stringa di codice
	 * */
	@Override
	public void visit(NodeId node) {
		node.setCodice(""+node.getDefinitions().getRegistro());
	}
	
	/**In tale metodo si va a settare il codice del NodePrint andando prima a settare il codice
	 * del NodeId.
	 * @author Luca Monteleone
	 * @param node NodePrint a cui assegnare la relativa stringa di codice
	 * */
	@Override
	public void visit(NodePrint node) {
		node.getId().accept(this);
		node.setCodice("l"+node.getId().getCodice()+" p P");
	}
	
	/**In tale metodo si va a settare il codice del NodeProgram. 
	 * Se il NodeProgram durante l'analisi semantica si è visto che non era semanticamente corretto 
	 * oppure si vede che il numero di registri che si hanno a disposizione non sono sufficienti per 
	 * associare ad ogni variabili un relativo registro allora si restituisce come stringa di codice 
	 * la stringa vuota.  
	 * @author Luca Monteleone
	 * @param node NodeAssign a cui assegnare la relativa stringa di codice
	 * */
	@Override
	public void visit(NodeProgram node) {
		
		
		if(Registri.size() >= SymbolTable.size() && node.getResType() == TypeDescriptor.Void) {
			String codice = "";
			 
			for(NodeDecSt nodeSt: node.getDecSts()) {
				nodeSt.accept(this);
				if(nodeSt.getCodice() != null)
					codice += nodeSt.getCodice()+" ";
			}
		
			node.setCodice(codice.substring(0, codice.length()-1));
		}
		else {
			node.setCodice("");
		}
				
	}

}