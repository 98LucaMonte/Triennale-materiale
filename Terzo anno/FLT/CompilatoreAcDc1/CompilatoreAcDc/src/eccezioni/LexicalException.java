package eccezioni;
/**
 * Classe che crea l'eccezione di tipo lessicale
 * @author Luca Monteleone
 * */
public class LexicalException extends Exception {
	
	private static final long serialVersionUID = 8400106441693957872L;
	/**
	 * Costruttore vuoto dell'eccezione sintattica
	 * @author Luca Monteleone
	 * */
	public LexicalException() {
		super();
	}
	/**
	 * Costruttore dell'eccezione lessicale in cui si indica il messaggio che deve stampare tale eccezione
	 * @author Luca Monteleone
	 * @param message stringa che l'eccezione deve stampare
	 * */
	public LexicalException(String message) {
        super(message);
    }
	/**
	 * Costruttore dell'eccezione lessicale in cui si indica il messaggio che deve stampare tale eccezione
	 * e la causa che ha fatto lanciare l'eccezione
	 * @author Luca Monteleone
	 * @param message stringa che l'eccezione deve stampare
	 * @param cause Throwable che mi indica un altro tipo di eccezione da rilanciare come eccezione lessicale
	 * */
    public LexicalException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
