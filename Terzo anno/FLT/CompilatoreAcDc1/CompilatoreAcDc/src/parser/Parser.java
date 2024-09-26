package parser;

import token.TokenType;
import java.io.IOException;
import java.util.*;

import ast.*;
import eccezioni.LexicalException;
import eccezioni.SyntacticException;
import scanner.Scanner;
import token.Token;
/** Il parser realizza l'analisi sintattica del codice sorgente 
 * e come risultato se l'analisi sintattica è corretta fornisce l'AST del codice sorgente
 * invece se non è corretta lancia un eccezione di tipo sintattica o di tipo lessicale a seconda
 * dell'errore trovato. 
 * @author Luca Monteleone
 * */
public class Parser {
	
	private Scanner scanner;
	
	/** Costruttore del Parser a cui viene assegnato lo scanner associato
	 * @author Luca Monteleone
	 * @param scanner lo scanner che viene assegnato al Parser
	 * */
	public Parser(Scanner scanner) {
		this.scanner=scanner;
	}
	
	/**Metodo che ritorna il NodeProgram che rappresenta l'AST 
	 * del codice sorgente in cui viene eseguita l'analisi sintattica.
	 * @author Luca Monteleone
	 * @exception SyntacticException Tale eccezione viene lanciata quando 
	 * si trova un carattere che non è gestibile dal nostro compilatore oppure quando non si 
	 * rispetta la sintassi. 
	 * @return NodeProgram che rappresenta l'ast del codice sorgente
	 * */
	public NodeProgram parse() throws SyntacticException {
		return this.parsePrg();
	}
	
	private NodeProgram parsePrg() throws SyntacticException{
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case TYFLOAT,TYINT,ID,PRINT,EOF:
				ArrayList<NodeDecSt> decSt1 = parseDSs();
				match(TokenType.EOF);
				return new NodeProgram(decSt1);
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}
		
	}
	
	private ArrayList<NodeDecSt> parseDSs() throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case TYFLOAT,TYINT:
				NodeDecl nodeDecl = parseDcl();
				ArrayList<NodeDecSt> decSt1 = parseDSs();
				decSt1.add(0, nodeDecl);
				return decSt1;
			case ID,PRINT:
				NodeStm nodeStm = parseStm();
				ArrayList<NodeDecSt> decSt2 = parseDSs();
				decSt2.add(0, nodeStm);
				return decSt2;
			case EOF:
				ArrayList<NodeDecSt> decSt = new ArrayList<>();
				return decSt;
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}
	}
	
	private NodeDecl parseDcl() throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case TYFLOAT,TYINT:
				LangType type = parseTy();
				Token tID = match(TokenType.ID);
				NodeExpr nodeExp = parseDclP();
				NodeId node = new NodeId(tID.getVal());
				return new NodeDecl(node,type,nodeExp);
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}
		
	}
	
	private LangType parseTy() throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case TYFLOAT:
				match(TokenType.TYFLOAT);
				return LangType.FLOATy;
			case TYINT:
				match(TokenType.TYINT);
				return LangType.INTy;
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}	
	}
	
	private NodeExpr parseDclP() throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case SEMI:
				match(TokenType.SEMI);
				return null;
			case ASSIGN:
				match(TokenType.ASSIGN);
				NodeExpr nodeExp = parseExp();
				match(TokenType.SEMI);
				return nodeExp;
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}
	}

	private NodeStm parseStm() throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case ID:
				Token tID1 = match(TokenType.ID);
				match(TokenType.ASSIGN);
				NodeExpr nodeExp = parseExp();
				match(TokenType.SEMI);
				NodeId node1 = new NodeId(tID1.getVal());
				return new NodeAssign(node1,nodeExp);
			case PRINT:	
				match(TokenType.PRINT);
				Token tID2 = match(TokenType.ID);
				match(TokenType.SEMI);
				NodeId node2 = new NodeId(tID2.getVal());
				return new NodePrint(node2);
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}
	}
	
	private NodeExpr parseExp() throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case INT,FLOAT,ID:	
				NodeExpr exp1 = parseTr();
				return parseExpP(exp1);
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}
		
	}
	
	private NodeExpr parseExpP(NodeExpr left) throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case PLUS:
				match(TokenType.PLUS);
				NodeExpr exp1 = parseTr();
				NodeBinOp node = new NodeBinOp(LangOper.PLUS,left,exp1);
				return parseExpP(node);
			case MINUS:	
				match(TokenType.MINUS);
				NodeExpr exp3 =parseTr();
				NodeBinOp node1 = new NodeBinOp(LangOper.MINUS,left,exp3);
				return parseExpP(node1);
			case SEMI:
				return left;
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}
	}
	
	private NodeExpr parseTr() throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case INT,FLOAT,ID:
				NodeExpr node = parseVal();
				return parseTrP(node);
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}	
	}
	
	private NodeExpr parseTrP(NodeExpr left) throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case TIMES:
				match(TokenType.TIMES);
				NodeExpr val1 = parseVal();
				NodeBinOp node = new NodeBinOp(LangOper.TIMES,left,val1);
				return parseTrP(node);
			case DIV:	
				match(TokenType.DIV);
				NodeExpr val2 = parseVal();
				NodeBinOp node1 = new NodeBinOp(LangOper.DIV,left,val2);
				return parseTrP(node1);
			case PLUS,MINUS,SEMI:
				return left;
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}
	}
	
	private NodeExpr parseVal() throws SyntacticException {
		
		Token tk = null;
		try {
			tk = this.scanner.peekToken();
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore lessicale\n",e);
		}
		
		switch (tk.getType()) {
			case INT:
				Token t = match(TokenType.INT);
				return new NodeCost(t.getVal(),LangType.INTy);
			case FLOAT:	
				Token t1 = match(TokenType.FLOAT);
				return new NodeCost(t1.getVal(),LangType.FLOATy);
			case ID:
				Token t2 = match(TokenType.ID);
				NodeId node = new NodeId(t2.getVal());
				return new NodeDeref(node);
			default:
				throw new SyntacticException("ErroreSintattico:Il token "+ tk.getType() +" alla riga "+ tk.getRiga() + " non è corretto\n");
		}
		
	}
	
	private Token match(TokenType type) throws SyntacticException {
		
		Token tk = null;
		
		try {
			tk = this.scanner.peekToken();
			if(type.equals(tk.getType())) {
				return this.scanner.nextToken();
			}
			else
				throw new SyntacticException("Errore il token trovato è di tipo "+tk.getType()+" ma il tipo che ci si aspettava era "+type+"\n");
		}
		catch(IOException | LexicalException e) {
			throw new SyntacticException("Errore Lessicale\n",e);
		}
	}
	
}
