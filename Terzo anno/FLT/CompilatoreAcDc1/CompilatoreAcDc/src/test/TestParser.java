package test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import ast.NodeProgram;
import eccezioni.SyntacticException;
import parser.Parser;
import scanner.Scanner;

class TestParser {

	@Test
	void testParserCorretto() {
		
		try {
			Scanner sc1;
			NodeProgram node;
			sc1 = new Scanner("./src/test/data/testParser/testParserCorretto.txt");
			Parser p1 = new Parser(sc1);
			node = p1.parse();
			System.out.println(node.toStringFormatted());
			assertEquals(node.toString(),"NodeProgram [decSts=[NodeDecl [id=NodeId [name=c], type=INTy, init=NodeCost [value=10, type=INTy]], NodeDecl [id=NodeId [name=b], type=FLOATy, init=null], NodeDecl [id=NodeId [name=a], type=INTy, init=null], NodeAssign [id=NodeId [name=a], expr=NodeCost [value=5, type=INTy]], NodeAssign [id=NodeId [name=b], expr=NodeBinOp [op=PLUS, left=NodeDeref [id=NodeId [name=a]], right=NodeCost [value=3.2, type=FLOATy]]], NodePrint [id=NodeId [name=b]]]]");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testParserCorretto1() {
		
		try {
			Scanner sc1;
			NodeProgram node;
			sc1 = new Scanner("./src/test/data/testParser/testParserCorretto1.txt");
			Parser p1 = new Parser(sc1);
			node = p1.parse();
			System.out.println(node.toStringFormatted());
			assertEquals(node.toString(),"NodeProgram [decSts=[NodePrint [id=NodeId [name=stampa]], NodeDecl [id=NodeId [name=numberfloat], type=FLOATy, init=null], NodeDecl [id=NodeId [name=floati], type=INTy, init=null], NodeAssign [id=NodeId [name=a], expr=NodeBinOp [op=PLUS, left=NodeCost [value=5, type=INTy], right=NodeCost [value=3, type=INTy]]], NodeAssign [id=NodeId [name=b], expr=NodeBinOp [op=PLUS, left=NodeDeref [id=NodeId [name=a]], right=NodeCost [value=5, type=INTy]]]]]");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testParserCorretto2() {
		
		try {
			Scanner sc1;
			NodeProgram node;
			sc1 = new Scanner("./src/test/data/testParser/testParserCorretto2.txt");
			Parser p1 = new Parser(sc1);
			node = p1.parse();
			System.out.println(node.toStringFormatted());
			assertEquals(node.toString(),"NodeProgram [decSts=[NodeDecl [id=NodeId [name=num], type=INTy, init=null], NodeAssign [id=NodeId [name=num], expr=NodeCost [value=5, type=INTy]], NodeAssign [id=NodeId [name=num], expr=NodeDeref [id=NodeId [name=id]]], NodeAssign [id=NodeId [name=num], expr=NodeBinOp [op=PLUS, left=NodeDeref [id=NodeId [name=id]], right=NodeCost [value=5.0, type=FLOATy]]], NodeAssign [id=NodeId [name=num], expr=NodeBinOp [op=TIMES, left=NodeDeref [id=NodeId [name=id]], right=NodeCost [value=5, type=INTy]]], NodeAssign [id=NodeId [name=num], expr=NodeBinOp [op=TIMES, left=NodeDeref [id=NodeId [name=id]], right=NodeDeref [id=NodeId [name=id]]]], NodeAssign [id=NodeId [name=num], expr=NodeBinOp [op=MINUS, left=NodeBinOp [op=PLUS, left=NodeDeref [id=NodeId [name=id]], right=NodeCost [value=5, type=INTy]], right=NodeBinOp [op=DIV, left=NodeBinOp [op=TIMES, left=NodeCost [value=8, type=INTy], right=NodeCost [value=6.0, type=FLOATy]], right=NodeCost [value=2, type=INTy]]]], NodeAssign [id=NodeId [name=num], expr=NodeBinOp [op=PLUS, left=NodeBinOp [op=MINUS, left=NodeBinOp [op=TIMES, left=NodeDeref [id=NodeId [name=id]], right=NodeCost [value=5, type=INTy]], right=NodeBinOp [op=TIMES, left=NodeCost [value=8.0, type=FLOATy], right=NodeCost [value=6, type=INTy]]], right=NodeCost [value=2, type=INTy]]], NodePrint [id=NodeId [name=ok]]]]");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testParserCorretto3() {
		
		try {
			Scanner sc1;
			NodeProgram node;
			sc1 = new Scanner("./src/test/data/testParser/testParserCorretto3.txt");
			Parser p1 = new Parser(sc1);
			node = p1.parse();
			System.out.println(node.toStringFormatted());
			assertEquals(node.toString(),"NodeProgram [decSts=[NodeDecl [id=NodeId [name=temp], type=INTy, init=NodeBinOp [op=PLUS, left=NodeBinOp [op=MINUS, left=NodeCost [value=5, type=INTy], right=NodeBinOp [op=TIMES, left=NodeCost [value=7, type=INTy], right=NodeCost [value=6.0, type=FLOATy]]], right=NodeCost [value=2, type=INTy]]], NodeDecl [id=NodeId [name=y], type=FLOATy, init=NodeBinOp [op=PLUS, left=NodeDeref [id=NodeId [name=temp]], right=NodeCost [value=1, type=INTy]]], NodeAssign [id=NodeId [name=temp], expr=NodeBinOp [op=PLUS, left=NodeDeref [id=NodeId [name=y]], right=NodeBinOp [op=DIV, left=NodeBinOp [op=DIV, left=NodeCost [value=7, type=INTy], right=NodeDeref [id=NodeId [name=temp]]], right=NodeCost [value=4, type=INTy]]]], NodePrint [id=NodeId [name=temp]]]]");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testParserEcc_0() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testParser/testParserEcc_0.txt");
			Parser p1 = new Parser(sc1);
			Throwable e = assertThrows(SyntacticException.class,() -> p1.parse());
			assertEquals(e.getMessage(),"ErroreSintattico:Il token SEMI alla riga 1 non è corretto\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	@Test
	void testParserEcc_1() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testParser/testParserEcc_1.txt");
			Parser p1 = new Parser(sc1);
			Throwable e = assertThrows(SyntacticException.class,() -> p1.parse());
			assertEquals(e.getMessage(),"ErroreSintattico:Il token TIMES alla riga 2 non è corretto\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	void testParserEcc_2()  {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testParser/testParserEcc_2.txt");
			Parser p1 = new Parser(sc1);
			Throwable e = assertThrows(SyntacticException.class,() -> p1.parse());
			assertEquals(e.getMessage(),"ErroreSintattico:Il token INT alla riga 1 non è corretto\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	@Test
	void testParserEcc_3() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testParser/testParserEcc_3.txt");
			Parser p1 = new Parser(sc1);
			Throwable e = assertThrows(SyntacticException.class,() -> p1.parse());
			assertEquals(e.getMessage(),"Errore il token trovato è di tipo PLUS ma il tipo che ci si aspettava era ASSIGN\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	void testParserEcc_4() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testParser/testParserEcc_4.txt");
			Parser p1 = new Parser(sc1);
			Throwable e = assertThrows(SyntacticException.class,() -> p1.parse());
			assertEquals(e.getMessage(),"Errore il token trovato è di tipo INT ma il tipo che ci si aspettava era ID\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	void testParserEcc_5() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testParser/testParserEcc_5.txt");
			Parser p1 = new Parser(sc1);
			Throwable e = assertThrows(SyntacticException.class,() -> p1.parse());
			assertEquals(e.getMessage(),"Errore il token trovato è di tipo INT ma il tipo che ci si aspettava era ID\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
}
