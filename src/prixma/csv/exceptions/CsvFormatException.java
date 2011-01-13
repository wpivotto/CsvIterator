package prixma.csv.exceptions;

/**
 * @author William Pivotto
 */
public class CsvFormatException extends RuntimeException {
	
	private static final long serialVersionUID = 7894564976724896118L;

	public CsvFormatException(String message) {
		super(message);
	}

}
