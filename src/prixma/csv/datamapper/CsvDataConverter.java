package prixma.csv.datamapper;

/**
 * Convert a row to an object
 * 
 * @author William Pivotto
 */
public interface CsvDataConverter<T> {
	
	public T convert(CsvFileRow row);
	
	public boolean canHandle(CsvFile file);

}
