package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import ast.NodeProgram;
import eccezioni.SyntacticException;
import parser.Parser;
import scanner.Scanner;
import visitor.CodeGeneratorVisitor;
import visitor.TypeCheckingVisitor;

class TestCodeGeneratorVisitor {

	@Test
	void test_Codice1() {
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestCodeGeneratorVisitor/Codice1.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			nP.accept(new CodeGeneratorVisitor());
			System.out.println(nP.getCodice());
			assertEquals(nP.getCodice(),"1.0 6 5 k / 0 k sb 0 k lb p P 1 6 / 0 k sa 0 k la p P");
			
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test_Codice2() {
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestCodeGeneratorVisitor/Codice2.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			nP.accept(new CodeGeneratorVisitor());
			System.out.println(nP.getCodice());
			assertEquals(nP.getCodice(),"100 sa 0 k 60.4356 sb 0 k la sb 0 k lb p P 1 6 / 0 k sa 0 k la p P");
			
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test_Codice3() {
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestCodeGeneratorVisitor/Codice3.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			nP.accept(new CodeGeneratorVisitor());
			System.out.println(nP.getCodice());
			assertEquals(nP.getCodice(),"100 50 - 0 k sa 0 k 60.4356 la 5 k + 0 k sb 0 k la sb 0 k lb p P 1 6 / 0 k sa 0 k la p P");
			
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test_Codice4Error() {
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestCodeGeneratorVisitor/Codice4Error.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			nP.accept(new CodeGeneratorVisitor());
			System.out.println(nP.getCodice());
			assertEquals(nP.getCodice(),"");
			
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test_Codice5() {
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestCodeGeneratorVisitor/Codice5.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			nP.accept(new CodeGeneratorVisitor());
			System.out.println(nP.getCodice());
			assertEquals(nP.getCodice(),"5 sa 0 k 4 sb 0 k la 3.2 lb 5 k / 0 k 5 k - 0 k sb 0 k lb p P");
			
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test_Codice6() {
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestCodeGeneratorVisitor/Codice6.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			nP.accept(new CodeGeneratorVisitor());
			System.out.println(nP.getCodice());
			assertEquals(nP.getCodice(),"5 sa 0 k 3.2 la 5 k / 0 k sa 0 k la p P");
			
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test_Codice7() {
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestCodeGeneratorVisitor/Codice7.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			nP.accept(new CodeGeneratorVisitor());
			System.out.println(nP.getCodice());
			assertEquals(nP.getCodice(),"100 50 - 0 k sa 0 k 36.735 la 5 k + 0 k sb 0 k la sb 0 k lb p P 3 7 / 0 k sa 0 k la p P");
			
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
		
	}
}
