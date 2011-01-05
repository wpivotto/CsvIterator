package prixma.csv.datamapper;

import java.io.IOException;

import prixma.csv.exceptions.CsvConvertException;

import com.csvreader.CsvReader;

public class CsvFileRow {
	
	private final CsvReader reader;

	public CsvFileRow(CsvReader reader) {
		this.reader = reader;
	}
	
	public String get(String column){
		return read(column);
	}
	
	public int getInt(String column){
		return Integer.valueOf(read(column));
	}
	
	public boolean getBool(String column){
		return Boolean.valueOf(read(column));
	}
	
	private String read(String column){
		try {
			return reader.get(column);
		} catch (IOException e) {
			throw new CsvConvertException(e);
		}
	}
	
	

}
