package prixma.csv.converter;

import prixma.csv.datamapper.CsvFile;
import prixma.csv.datamapper.CsvFileRow;

/**
 * Convert a row to an object
 * 
 * @author William Pivotto
 */
public interface CsvDataConverter<T> {
	
	public T convert(CsvFileRow row);
	
	public boolean canHandle(CsvFile file);

}
