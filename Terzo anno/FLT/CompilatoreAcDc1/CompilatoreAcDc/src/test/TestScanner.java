package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import eccezioni.LexicalException;
import scanner.Scanner;
import token.Token;
import token.TokenType;

class TestScanner {
	
	@Test
	void testAggiuntivoNumeriErratto() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testAggiuntivoNumeriErratto.txt");
			
			Throwable e1 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e1.getMessage(),"Il Token non è valido perchè lo zero come prima cifra non può essere seguito da numeri o da lettere\n");
			Throwable e2 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e2.getMessage(),"Il Token non è valido perchè lo zero come prima cifra non può essere seguito da numeri o da lettere\n");
			assertEquals("<ID,r:1,bc>",sc1.nextToken().toString());
			Throwable e3 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e3.getMessage(),"Il Token non è valido perchè lo zero come prima cifra non può essere seguito da numeri o da lettere\n");
			Throwable e4 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e4.getMessage(),"Il Token non è valido perchè lo zero come prima cifra non può essere seguito da numeri o da lettere\n");
			assertEquals("<INT,r:1,99>",sc1.nextToken().toString());
			Throwable e5 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e5.getMessage(),"Il Token non è valido per i caratteri numerici perché ci sono 0 decimali\n");
			Throwable e6 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e6.getMessage(),"Il Token non è valido per i caratteri numerici perché ci sono 6 decimali\n");
			Throwable e7 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e7.getMessage(),"Il carattere . letto in riga 2 non può essere ripetuto per i caratteri numerici\n");
			Throwable e8 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e8.getMessage(),"Il carattere b letto in riga 3 non è valido per i caratteri numerici\n");
			Throwable e9 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e9.getMessage(),"Il carattere b letto in riga 3 non è valido per i caratteri numerici\n");
			assertEquals("<ID,r:3,cd>",sc1.nextToken().toString());
			Throwable e10 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e10.getMessage(),"Il carattere a letto in riga 3 non è valido per i caratteri numerici\n");
			assertEquals("<INT,r:3,123>",sc1.nextToken().toString());
			Throwable e11 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e11.getMessage(),"Il carattere a letto in riga 5 non è valido per i caratteri numerici\n");
			Throwable e12 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e12.getMessage(),"Il carattere a letto in riga 5 non è valido per i caratteri numerici\n");
			assertEquals("<ID,r:5,bc>",sc1.nextToken().toString());
			Throwable e13 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e13.getMessage(),"Il Token non è valido per i caratteri numerici perché ci sono 0 decimali\n");
			Throwable e14 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e14.getMessage(),"Il Token non è valido per i caratteri numerici perché ci sono 6 decimali\n");
			Throwable e15 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e15.getMessage(),"Il carattere b letto in riga 7 non è valido per i caratteri numerici\n");
			Throwable e16 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e16.getMessage(),"Il carattere b letto in riga 7 non è valido per i caratteri numerici\n");
			assertEquals("<ID,r:7,cd>",sc1.nextToken().toString());
			Throwable e17 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e17.getMessage(),"Il carattere a letto in riga 7 non è valido per i caratteri numerici\n");
			assertEquals("<INT,r:7,123>",sc1.nextToken().toString());
			Throwable e18 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e18.getMessage(),"Il carattere . in riga 9 non è legale per l'inizio di un Token\n");
			assertEquals("<INT,r:9,123>",sc1.nextToken().toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testAggiuntivoNumeriCorretto() {
		
		try {
			
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testAggiuntivoNumeriCorretti.txt");
			assertEquals("<INT,r:2,110>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:3,110.1>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:3,110.12>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:3,112.123>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:3,112.1242>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:3,121.12345>",sc1.nextToken().toString());
			assertEquals("<INT,r:5,0>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:5,0.1>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:6,0.12>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:6,0.123>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:7,0.1242>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:7,0.12345>",sc1.nextToken().toString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testAggiuntivoIDErratto() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testAggiuntivoIDErratto.txt");
			Throwable e1 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e1.getMessage(),"Il carattere 1 letto in riga 2 non è valido per i caratteri letterali\n");
			Throwable e2 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e2.getMessage(),"Il carattere v letto in riga 2 non è valido per i caratteri numerici\n");
			assertEquals("<ID,r:2,ar>",sc1.nextToken().toString());
			Throwable e3 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e3.getMessage(),"Il carattere 1 letto in riga 3 non è valido per i caratteri letterali\n");
			Throwable e4 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e4.getMessage(),"Il carattere . in riga 4 non è legale per l'inizio di un Token\n");
			assertEquals("<ID,r:4,var>",sc1.nextToken().toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testAggiuntivoIDCorretto() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testAggiuntivoIDCorretto.txt");
			assertEquals("<TYINT,r:1>",sc1.nextToken().toString());
			assertEquals("<ID,r:1,var>",sc1.nextToken().toString());
			assertEquals("<ID,r:1,intvar>",sc1.nextToken().toString());
			assertEquals("<TYFLOAT,r:2>",sc1.nextToken().toString());
			assertEquals("<ID,r:2,var>",sc1.nextToken().toString());
			assertEquals("<ID,r:2,floatvar>",sc1.nextToken().toString());
			assertEquals("<PRINT,r:3>",sc1.nextToken().toString());
			assertEquals("<ID,r:3,ciao>",sc1.nextToken().toString());
			assertEquals("<ID,r:3,printciao>",sc1.nextToken().toString());
			assertEquals("<ID,r:4,var>",sc1.nextToken().toString());
			Throwable e = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e.getMessage(),"Il carattere . in riga 4 non è legale per l'inizio di un Token\n");
			assertEquals("<ID,r:4,var>",sc1.nextToken().toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testEOF() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testEOF.txt");
			assertEquals("<EOF,r:3>",sc1.nextToken().toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testErroriIdNumbers() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/erroriIdNumbers.txt"); 
			Throwable e = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e.getMessage(),"Il carattere a letto in riga 1 non è valido per i caratteri numerici\n");
			assertEquals("<ID,r:1,sd>",sc1.nextToken().toString());
			Throwable e1 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e1.getMessage(),"Il carattere . in riga 2 non è legale per l'inizio di un Token\n");
			assertEquals("<INT,r:2,123>",sc1.nextToken().toString());
			assertEquals("<ID,r:3,asd>",sc1.nextToken().toString());
			Throwable e2 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e2.getMessage(),"Il carattere . in riga 3 non è legale per l'inizio di un Token\n");
			assertEquals("<INT,r:3,123>",sc1.nextToken().toString());
			Throwable e3 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e3.getMessage(),"Il carattere a letto in riga 4 non è valido per i caratteri numerici\n");
			assertEquals("<ID,r:4,sd>",sc1.nextToken().toString());
			Throwable e4 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e4.getMessage(),"Il carattere 6 letto in riga 5 non è valido per i caratteri letterali\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testFLOAT() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testFLOAT.txt"); 
			Throwable e = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e.getMessage(),"Il Token non è valido perchè lo zero come prima cifra non può essere seguito da numeri o da lettere\n");
			assertEquals("<FLOAT,r:1,8.895>", sc1.nextToken().toString());
			Throwable e1 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e1.getMessage(),"Il Token non è valido per i caratteri numerici perché ci sono 0 decimali\n");
			Throwable e2 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e2.getMessage(),"Il Token non è valido per i caratteri numerici perché ci sono 8 decimali\n");
			assertEquals("<FLOAT,r:7,99.89>", sc1.nextToken().toString());
			assertEquals("<FLOAT,r:9,5.0>", sc1.nextToken().toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
	}
		
	@Test
	void testID() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testID.txt"); 
			assertEquals("<ID,r:1,jskjdsfhkjdshkf>",sc1.nextToken().toString());
			assertEquals("<ID,r:2,printl>",sc1.nextToken().toString());
			assertEquals("<ID,r:4,hhhjj>",sc1.nextToken().toString());
			Throwable e = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e.getMessage(),"Il carattere 2 letto in riga 6 non è valido per i caratteri letterali\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testINT() {
	
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testINT.txt"); 
			assertEquals("<INT,r:2,698>",sc1.nextToken().toString());
			Throwable e = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e.getMessage(),"Il carattere a letto in riga 3 non è valido per i caratteri numerici\n");
			assertEquals("<INT,r:4,231>",sc1.nextToken().toString());
			Throwable e1 = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e1.getMessage(),"Il carattere a letto in riga 5 non è valido per i caratteri numerici\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	void testKeywords() {

		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testKeywords.txt"); 
			assertEquals("<PRINT,r:2>",sc1.nextToken().toString());
			assertEquals("<TYFLOAT,r:2>",sc1.nextToken().toString());
			assertEquals("<TYINT,r:5>",sc1.nextToken().toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testOperators()  {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testOperators.txt"); 
			assertEquals("<PLUS,r:1>",sc1.nextToken().toString());
			assertEquals("<MINUS,r:2>",sc1.nextToken().toString());
			assertEquals("<TIMES,r:2>",sc1.nextToken().toString());
			assertEquals("<DIV,r:3>",sc1.nextToken().toString());
			assertEquals("<ASSIGN,r:8>",sc1.nextToken().toString());
			assertEquals("<SEMI,r:10>",sc1.nextToken().toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testScanld() {
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testScanId.txt"); 
			assertEquals("<TYINT,r:1>",sc1.nextToken().toString());
			assertEquals("<TYFLOAT,r:2>",sc1.nextToken().toString());
			assertEquals("<PRINT,r:3>",sc1.nextToken().toString());
			assertEquals("<ID,r:4,nome>",sc1.nextToken().toString());
			assertEquals("<ID,r:5,intnome>",sc1.nextToken().toString());
			assertEquals("<TYINT,r:6>",sc1.nextToken().toString());
			assertEquals("<ID,r:6,nome>",sc1.nextToken().toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
		
	}
	 
	@Test
	void testGenerale(){
		
		try {
			Scanner sc1 = new Scanner("./src/test/data/testScanner/testGenerale.txt"); 
			assertEquals("<TYINT,r:1>",sc1.nextToken().toString());
			assertEquals("<ID,r:1,temp>",sc1.nextToken().toString());
			assertEquals("<SEMI,r:1>",sc1.nextToken().toString());
			assertEquals("<ID,r:2,temp>",sc1.nextToken().toString());
			assertEquals("<ASSIGN,r:2>",sc1.nextToken().toString());
			Throwable e = assertThrows(LexicalException.class, () -> sc1.nextToken());
			assertEquals(e.getMessage(),"Il Token non è valido per i caratteri numerici perché ci sono 0 decimali\n");
			assertEquals("<SEMI,r:2>",sc1.nextToken().toString());
			assertEquals("<TYFLOAT,r:4>",sc1.nextToken().toString());
			assertEquals("<ID,r:4,b>",sc1.nextToken().toString());
			assertEquals("<SEMI,r:4>",sc1.nextToken().toString());
			assertEquals("<ID,r:5,b>",sc1.nextToken().toString());
			assertEquals("<ASSIGN,r:5>",sc1.nextToken().toString());
			assertEquals("<ID,r:5,temp>",sc1.nextToken().toString());
			assertEquals("<PLUS,r:5>",sc1.nextToken().toString());
			assertEquals("<FLOAT,r:5,3.2>",sc1.nextToken().toString());
			assertEquals("<SEMI,r:5>",sc1.nextToken().toString());
			assertEquals("<PRINT,r:6>",sc1.nextToken().toString());
			assertEquals("<ID,r:6,b>",sc1.nextToken().toString());
			assertEquals("<SEMI,r:6>",sc1.nextToken().toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (LexicalException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void peekToken () {
		
		try {
			Scanner s = new Scanner("./src/test/data/testScanner/testGenerale.txt");
			assertEquals(s.peekToken().getType(), TokenType.TYINT );
			assertEquals(s.nextToken().getType(), TokenType.TYINT );
			assertEquals(s.peekToken().getType(), TokenType.ID );
			assertEquals(s.peekToken().getType(), TokenType.ID );
			Token t = s.nextToken();
			assertEquals(t.getType(), TokenType.ID);
			assertEquals(t.getRiga(), 1);
			assertEquals(t.getVal(), "temp");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (LexicalException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
