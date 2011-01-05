package prixma.csv.datamapper;


import java.util.List;

public interface CsvDataConverter<T> {
	
	public T convert(CsvFileRow row);
	
	public boolean canHandle(List<String> headers);

}
