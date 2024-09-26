package scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import eccezioni.LexicalException;
import token.*;
/** Lo scanner realizza l'analisi lessicale del codice sorgente 
 * e come risultato se l'analisi lessicale è corretta fornisce il token della parola appena letta
 * invece se non è corretta lancia un eccezione di tipo lessicale.
 * @author Luca Monteleone
 * */
public class Scanner {
	
	final char EOF = (char) -1; // int 65535
	private int riga;
	private PushbackReader buffer;
	//private String log;//per ora non ci serve

	// skpChars: insieme caratteri di skip (include EOF) e inizializzazione
	private ArrayList<Character> skpChars = new ArrayList<Character>(Arrays.asList(' ','\n','\r','\t',EOF));
	// letters: insieme lettere e inizializzazione
	private ArrayList<Character> letters = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
	// digits: cifre e inizializzazione
	private ArrayList<Character> digits = new ArrayList<Character>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
	
	// operatorsMap: mapping fra caratteri '+', '-', '*', '/', '=', ';' e il
	// TokenType corrispondente
	private HashMap<Character,TokenType> operatorsMap;
	// keyWordsMap: mapping fra le stringhe "print", "float", "int" e il
	// TokenType corrispondente
	private HashMap<String,TokenType> keyWordsMap;
	
	private Token currentToken;
	
	/** Costruttore dello scanner a cui viene assegnata la stringa 
	 * che rappresenta il nome del file in cui è contenuto il codice sorgente.
	 * @author Luca Monteleone
	 * @param fileName la stringa in cui è contenuto il nome del file in cui è contenuto il codice sorgente.
	 * @exception FileNotFoundException Tale eccezione viene lanciata quando il file non viene trovato.
	 * */
	public Scanner(String fileName) throws FileNotFoundException {

		this.buffer = new PushbackReader(new FileReader(fileName));
		if(this.buffer == null)
			throw new FileNotFoundException("Il file non è stato trovato");
		this.riga = 1;
		
		this.operatorsMap = new HashMap<Character,TokenType>();
		this.operatorsMap.put('=', TokenType.ASSIGN);
		this.operatorsMap.put('+', TokenType.PLUS);
		this.operatorsMap.put('-', TokenType.MINUS);
		this.operatorsMap.put('*', TokenType.TIMES);
		this.operatorsMap.put('/', TokenType.DIV);
		this.operatorsMap.put(';', TokenType.SEMI);
		
		this.keyWordsMap = new HashMap<String,TokenType>();
		this.keyWordsMap.put("print", TokenType.PRINT);
		this.keyWordsMap.put("float", TokenType.TYFLOAT);
		this.keyWordsMap.put("int", TokenType.TYINT);		
	}
	/** Metodo che ritorna il token della parola appena letta. Se è già stato letto un Token che non è stato 
	 * ancora consumato dal Parser tale metodo ritorna ancora il Token che non è stato ancora consumato
	 * altrimenti legge se il Token precedente è stato consumato allora si va a leggere il prossimo Token. 
	 * @author Luca Monteleone
	 * @exception LexicalException Tale eccezione viene lanciata quando si trova un carattere non accettabile.
	 * @exception IOException Tale eccezione si lancia quando la lettura di un carattere non va a buon fine.
	 * @return Token letto dal codice sorgente
	 * */
	public Token peekToken() throws LexicalException,IOException {
		
		if(this.currentToken == null)
			this.currentToken = this.nextToken();
		
		return this.currentToken;
	}
	/** Metodo che ritorna il token della parola appena letta.
	 * @author Luca Monteleone
	 * @exception LexicalException Tale eccezione viene lanciata quando si trova un carattere non accettabile.
	 * @return Token letto dal codice sorgente
	 * */
	public Token nextToken() throws LexicalException {
		
		/*
		*Se ho già fatto una peekToken ritorno currentToken
		*consumo il currentToken
		*/
		if(this.currentToken != null) {
			Token t = this.currentToken;
			this.currentToken = null;
			return t;
		}
		
		//nextChar contiene il prossimo carattere dell'input.
		char nextChar = 0;
		
		/*
		*Avanza nel buffer leggendo i carattere in skipChars
		*incrementando riga se leggi '\n'.
		*Se raggiungi la fine del file ritorna il Token EOF
		*/
		try {
			nextChar = peekChar();
			
			//stato 0 dell'automa
			while(this.skpChars.contains(nextChar)) {
				this.readChar();
				
				if(nextChar == EOF) {//si va dallo stato 0 allo stato 1
					return new Token(TokenType.EOF,this.riga);
				}
				if(nextChar == '\n') {//si rimane nello stato 0
					riga++;
				}
				nextChar = peekChar(); 
			}
		/*		
		*Se nextChar è un numero
		*si va dallo stato 0 allo stato 2	
		*scanNumber legge sia un intero che un float e ritorna il Token INUM o FNUM
		*i caratteri che leggete devono essere accumulati in una stringa
		*che verra' assegnata al campo valore del Token
		*/	
			if(this.digits.contains(nextChar))
				return scanNumber();
		
		
		 /*
		 *Se nextChar è una lettera
		 *si va dallo stato 0 allo stato 3	
		 *scanId legge tutte le lettere minuscole e ritorna un Token ID o
		 *il Token associato Parola Chiave (per generare i Token per le
		 *parole chiave usate l'HaskMap di corrispondenza
		 */	
			if(this.letters.contains(nextChar))
				return scanId();
			
		 /*
		 *Se nextChar è un'operatore
		 *ritorna il Token associato con l'operatore o il delimitatore
		 *si va dallo stato 0 allo stato 4
		 */
			if(this.operatorsMap.containsKey(nextChar)) {
				this.readChar();
				return new Token(this.operatorsMap.get(nextChar),this.riga);
			}
				
		/*
		*Altrimenti il carattere NON E' UN CARATTERE LEGALE 
		*quindi lo leggo con la READ e lancio eccezione
		*rimango nello stato 0 che non è finale 
		*per cui il carattere non appartiene al linguaggio	
		*/
			this.readChar();
			throw new LexicalException("Il carattere "+nextChar+" in riga "+this.riga+" non è legale per l'inizio di un Token\n");
		}
		catch(IOException e) {
			throw new LexicalException("Errore di lettura in riga "+ this.riga+"\n",e);
		}
	
	}
		
	private Token scanId() throws IOException,LexicalException {
		
		char nextChar = this.peekChar();
		String result = "";
		
		/*
		*Con questo while indico che se trovo una lettera rimango sempre nello stato 3
		*mentre se trovo un numero oppure un punto allora vado nello stato 8 che è lo 
		*stato d'errore. Se invece trovo un carattere di skpChars oppure un operatore 
		*la stringa finora letta è valida ma dopo inizierà un nuovo token. 
		*/
		while(this.letters.contains(nextChar)) {	
			
			result = result + nextChar;
			this.readChar();
			nextChar = this.peekChar();	
			
			/*
			*Se questo if è vero allora si passa dallo stato 3 allo stato 8 
			*/
			if(this.digits.contains(nextChar)) {
				this.readChar();
				throw new LexicalException("Il carattere "+nextChar+" letto in riga "+this.riga+" non è valido per i caratteri letterali\n");
			}
			/*
			*Se questo else if è vero si rimane nello stato 3 e si ritorna la stringa letta
			*andando fuori dal ciclo while e vedendo di quale tipo è la parola appena letta  
			*/
			else if(this.skpChars.contains(nextChar) || this.operatorsMap.containsKey(nextChar)|| nextChar == '.')
				break;
		}
		
		if(this.keyWordsMap.containsKey(result))
			return new Token(this.keyWordsMap.get(result),this.riga);
		else
			return new Token(TokenType.ID,this.riga,result);
	}
	
	private char readChar() throws IOException {
		try {
			return ((char) this.buffer.read());
		}
		catch(IOException e) {
			throw new IOException("Errore nella lettura del successivo carattere\n",e);
		}
	}
		
	/*
	*Legge un carattere con la read e poi torna indietro con la unread. 
	*Facendo così si legge il carattere e poi si torna indietro al carattere appena letto.
	*/
	private char peekChar() throws IOException {
		try {
			char c = (char) buffer.read();
			buffer.unread(c);
			return c;
		}
		catch(IOException e) {
			throw new IOException("Errore nel vedere qual è il successivo carattere\n",e);
		}
	}
	
	/*COMMENTI SUL FUNZIONAMENTO scanNumber
	 *Se il primo numero letto non è 0 allora passo dallo stato 0 allo stato 2
	 *e incomincio a leggere tutti i numeri che seguono il primo se c'è ne sono.
	 *mi riferisco a if(nextChar != '0')
	 *
	 *Dopo aver letto tutti i numeri verifico il prossimo carattere
	 *se è un punto allora il numero che sto leggendo potrebbe essere un float 
	 *(passo dallo stato 2 allo stato 5)
	 *se è una lettera allora il numero letto non è più valido
	 *(passo dallo stato 2 allo stato 8) 
	 *se è un operatore oppure un carattere di skpChars vuol dire che il numero
	 *è un intero 
	 *(rimango nello stato 2)
	 *mi riferisco alla parte del codice dentro a if(nextChar != '0')
	 *
	 *Se il primo numero è 0 allora passo dallo stato 0 allo stato 7
	 *e guardo che cos'è il prossimo carattere.
	 *mi rifersco al ramo else
	 *
	 *se dopo lo 0 c'è un numero o una lettera allora è un errore
	 *(si passa dallo stato 7 allo stato 8)
	 *se dopo lo 0 c'è un operatore o un skpChars allora abbiamo appena letto
	 *il numero 0
	 *(si rimane nello stato 7)
	 *se dopo lo 0 c'è il punto allora è possibile che il numero che stia 
	 *leggendo è un float. 
	 *mi riferisco alla parte del codice dentro al ramo else
	 *
	 *Se il carattere precedente era un punto il metodo continua perchè
	 *il numero che sto leggendo potrebbe essere un float.
	 *Continua a leggere il numero finchè non incontro 
	 *un carattere diverso dai numeri.  
	 *Se entro nel while passo dallo stato 5 allo stato 6 altrimenti 
	 *rimango nello stato 5 e sono in un caso di errore perchè vuol dire
	 *che il carattere successivo al punto non è un numero.
	 *mi riferisco alla porzione di codice dopo l'if then else in particolare al ciclo while
	 *
	 *Dopo aver letto tutti i numeri (se fossero stati presenti)
	 *verifico il prossimo carattere e se è un punto allora sono in un caso di errore
	 *poichè ci sono due punti in un numero. 
	 *(passo dallo stato 6 allo stato 8 se entro nel while)
	 *(oppure rimango nello stato 5 se non sono entrato nel while)
	 *se è una lettera allora il numero letto non è più valido
	 *(passo dallo stato 6 allo stato 8) 
	 *(oppure rimango nello stato 5 se non sono entrato nel while)
	 *se è un operatore oppure un carattere di skpChars vuol dire che il numero è un float
	 *(rimango nello stato 6)
	 *
	*/
	private Token scanNumber() throws IOException,LexicalException{
		
		char nextChar = this.peekChar();
		String result="";
		int conteggioDecimali = 0;
		
		if(nextChar != '0') {
			
			while(this.digits.contains(nextChar)) {
				result = result +nextChar;
				this.readChar();
				nextChar=this.peekChar();
			}
				
			if(nextChar == '.') {
				result = result +nextChar;
				this.readChar();
				nextChar=this.peekChar();
			}
			else if(this.letters.contains(nextChar)) {
				this.readChar();
				throw new LexicalException("Il carattere "+nextChar+" letto in riga "+this.riga+" non è valido per i caratteri numerici\n");
			}
			else if(this.operatorsMap.containsKey(nextChar) || this.skpChars.contains(nextChar)) {
				return new Token(TokenType.INT,this.riga,result);
			}
					
		}
		else {
						
			result = result+nextChar;
			this.readChar();
			if(this.digits.contains(this.peekChar()) || this.letters.contains(this.peekChar()) ) {
				this.readChar();
				throw new LexicalException("Il Token non è valido perchè lo zero come prima cifra non può essere seguito da numeri o da lettere\n");
			}
			else if(this.operatorsMap.containsKey(this.peekChar()) || this.skpChars.contains(this.peekChar())) {
				return new Token(TokenType.INT,this.riga,result);
			}
			else if(this.peekChar() == '.') {
				result = result+this.readChar();
				nextChar = this.peekChar();
			}
		}
		
		while(this.digits.contains(nextChar)) {
			result = result +nextChar;
			this.readChar();
			nextChar=this.peekChar();
			conteggioDecimali++;
		}
		
		if(nextChar == '.') {
			this.readChar();
			throw new LexicalException("Il carattere "+nextChar+" letto in riga "+this.riga+" non può essere ripetuto per i caratteri numerici\n");
		}
		else if(this.letters.contains(nextChar)) {
			this.readChar();
			throw new LexicalException("Il carattere "+nextChar+" letto in riga "+this.riga+" non è valido per i caratteri numerici\n");
		}
		else if(this.operatorsMap.containsKey(nextChar) || this.skpChars.contains(nextChar)) {
			if(conteggioDecimali>=1 && conteggioDecimali<=5)
				return new Token(TokenType.FLOAT,this.riga,result);
			else
				throw new LexicalException("Il Token non è valido per i caratteri numerici perché ci sono "+ conteggioDecimali+" decimali\n");
		}
		
		throw new LexicalException("Errore lessicale nella lettura di un numero\n");
	}
	
}
	