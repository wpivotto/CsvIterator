package prixma.csv.datamapper;


import java.util.List;

import com.csvreader.CsvReader;

public interface CsvDataConverter<T> {
	
	public T convertRow(CsvReader reader);
	
	public boolean canHandle(List<String> headers);

}
