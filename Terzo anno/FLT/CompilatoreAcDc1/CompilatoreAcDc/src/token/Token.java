package token;

/** Questa classe crea e gestisce i Token usati durante l'analisi lessicale. 
 * @author Luca Monteleone
 * */
public class Token {

	private int riga;
	private TokenType tipo;
	private String val;
	
	/** Costruttore del Token a cui viene assegnato il TokenType che indica
	 * il tipo del Token e la riga in cui si trova il Token appena letto.
	 * @author Luca Monteleone
	 * @param tipo il TokeType che viene assegnato al Token
	 * @param riga l'int che viene assegnato al Token
	 * */
	public Token(TokenType tipo, int riga) {
		this.riga = riga;
		this.tipo = tipo;
	}
	
	/** Costruttore del Token a cui viene assegnato il TokenType che indica
	 * il tipo del Token, la riga in cui si trova il Token appena letto e la stringa 
	 * che rappresenta la stringa associata al Token.
	 * @author Luca Monteleone
	 * @param tipo il TokeType che viene assegnato al Token
	 * @param riga l'int che viene assegnato al Token
	 * @param val la stringa che viene assegnata al Token
	 * */
    public Token(TokenType tipo, int riga, String val) {
    	this.riga = riga;
		this.tipo = tipo;
		this.val = val;
    }
    /** Getter che ritorna la riga in cui si trova il Token
	 * @author Luca Monteleone
	 * @return ritorna la riga in cui si trova il Token
	 * */	
	public int getRiga() {
		return riga;
	}
	/** Getter che ritorna il TokenType che è stato assegnato al Token
	 * @author Luca Monteleone
	 * @return ritorna il TokenType che è stato assegnato al Token
	 * */
	public TokenType getType() {
		return tipo;
	}
	/** Getter che ritorna la stringa che rappresenta il valore che è stato assegnato al Token
	 * @author Luca Monteleone
	 * @return ritorna la stringa associata al Token
	 * */
 	public String getVal() {
		return val;
	}
 	/** Metodo che ritorna la stringa che rappresenta il Token
	 * @author Luca Monteleone
	 * @return stringa che rappresenta il Token
	 * */
	@Override
	public String toString() {
				
		if(this.tipo == TokenType.INT || this.tipo == TokenType.FLOAT || this.tipo == TokenType.ID)
			return "<"+this.tipo+",r:"+this.riga+","+this.val+">";
		else
			return "<"+this.tipo+",r:"+this.riga+">";
	}



}
