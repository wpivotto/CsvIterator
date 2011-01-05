package prixma.csv.datamapper;


public interface CsvDataConverter<T> {
	
	public T convert(CsvFileRow row);
	
	public boolean canHandle(CsvFile file);

}
