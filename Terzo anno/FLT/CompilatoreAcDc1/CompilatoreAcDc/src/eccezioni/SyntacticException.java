package eccezioni;

/**
 * Classe che crea l'eccezione di tipo sintattica
 * @author Luca Monteleone
 * */
public class SyntacticException extends Exception {
	
	private static final long serialVersionUID = -6089065809782249026L;
	
	/**
	 * Costruttore vuoto dell'eccezione sintattica
	 * @author Luca Monteleone
	 * */
	public SyntacticException() {
		super();
	}
	/**
	 * Costruttore dell'eccezione sintattica in cui si indica il messaggio che deve stampare tale eccezione
	 * @author Luca Monteleone
	 * @param message stringa che l'eccezione deve stampare
	 * */
    public SyntacticException(String message) {
        super(message);
    }
    /**
	 * Costruttore dell'eccezione sintattica in cui si indica il messaggio che deve stampare tale eccezione
	 * e la causa che ha fatto lanciare l'eccezione
	 * @author Luca Monteleone
	 * @param message stringa che l'eccezione deve stampare
	 * @param cause Throwable che mi indica un altro tipo di eccezione da rilanciare come eccezione sintattica
	 * */
    public SyntacticException(String message, Throwable cause) {
        super(message, cause);
    }
}