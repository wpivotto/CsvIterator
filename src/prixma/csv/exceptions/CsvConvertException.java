package prixma.csv.exceptions;

/**
 * @author William Pivotto
 */
public class CsvConvertException extends RuntimeException {

	private static final long serialVersionUID = 3524198830137657155L;

	public CsvConvertException(String message) {
		super(message);
	}

	public CsvConvertException(Throwable e) {
		super(e);
		this.setStackTrace(e.getStackTrace());
	}

}
