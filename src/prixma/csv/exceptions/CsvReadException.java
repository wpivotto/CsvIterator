package prixma.csv.exceptions;


public class CsvReadException extends RuntimeException {

	private static final long serialVersionUID = -2549340448669717500L;

	public CsvReadException(String message) {
		super(message);
	}

	public CsvReadException(Throwable e) {
		super(e);
	}

}
