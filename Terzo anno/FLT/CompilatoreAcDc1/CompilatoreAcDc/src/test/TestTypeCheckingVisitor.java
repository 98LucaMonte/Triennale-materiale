package test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import ast.*;
import eccezioni.SyntacticException;
import parser.Parser;
import scanner.Scanner;
import symbolTabel.SymbolTable;
import visitor.TypeCheckingVisitor;

class TestTypeCheckingVisitor {

	@Test
	void test_dicRipetute() {
		
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestTypeCheck/1_dicRipetute.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			assertEquals(SymbolTable.size(),1);
			assertEquals(nP.getDecSts().get(0).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(1).getResType(),TypeDescriptor.Error);
			
			assertEquals(nP.getResType(),TypeDescriptor.Error);
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test_3_IdNotDeclare() {
		
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestTypeCheck/3_IdNotDeclare.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			assertEquals(SymbolTable.size(),1);
			assertEquals(nP.getDecSts().get(0).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(1).getResType(),TypeDescriptor.Error);
			assertEquals(nP.getDecSts().get(2).getResType(),TypeDescriptor.Error);
			assertEquals(nP.getDecSts().get(3).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getResType(),TypeDescriptor.Error);
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void test_2_fileCorrect() {
		
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestTypeCheck/2_fileCorrect.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			assertEquals(SymbolTable.size(),1);
			assertEquals(nP.getDecSts().get(0).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(1).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getResType(),TypeDescriptor.Void);
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_errorAssignConvert() {
		
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestTypeCheck/errorAssignConvert.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			assertEquals(SymbolTable.size(),2);
			assertEquals(nP.getDecSts().get(0).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(1).getResType(),TypeDescriptor.Error);
			assertEquals(nP.getDecSts().get(2).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(3).getResType(),TypeDescriptor.Error);
			assertEquals(nP.getDecSts().get(4).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getResType(),TypeDescriptor.Error);
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_errorOp() {
		
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestTypeCheck/errorOp.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			assertEquals(SymbolTable.size(),1);
			assertEquals(nP.getDecSts().get(0).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(1).getResType(),TypeDescriptor.Error);
			assertEquals(nP.getDecSts().get(2).getResType(),TypeDescriptor.Error);
			assertEquals(nP.getResType(),TypeDescriptor.Error);
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_fileCorrect2() {
		
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestTypeCheck/fileCorrect2.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			assertEquals(SymbolTable.size(),2);
			assertEquals(nP.getDecSts().get(0).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(1).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(2).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(3).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(4).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(5).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getResType(),TypeDescriptor.Void);
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_testGenerale() {
		
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestTypeCheck/testGenerale.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			assertEquals(SymbolTable.size(),2);
			assertEquals(nP.getDecSts().get(0).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(1).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(2).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(3).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(4).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getResType(),TypeDescriptor.Void);
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_testGenerale2() {
		
		NodeProgram nP;
		try {
			nP = new Parser(new Scanner("./src/test/data/TestTypeCheck/testGenerale2.txt")).parse();
			nP.accept(new TypeCheckingVisitor());
			System.out.println(nP.toStringFormatted());
			assertEquals(SymbolTable.size(),2);
			assertEquals(nP.getDecSts().get(0).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(1).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(2).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(3).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(4).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(5).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getDecSts().get(6).getResType(),TypeDescriptor.Void);
			assertEquals(nP.getResType(),TypeDescriptor.Void);
		} catch (FileNotFoundException | SyntacticException e) {
			e.printStackTrace();
		}
	}
	
}
