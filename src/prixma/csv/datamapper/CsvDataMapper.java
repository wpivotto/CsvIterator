package prixma.csv.datamapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import prixma.csv.exceptions.CsvFormatException;
import prixma.csv.exceptions.CsvReadException;

import com.csvreader.CsvReader;

public class CsvDataMapper<T> implements Iterator<T> {
	
	private CsvReader reader;
	private CsvDataConverter<T> converter;
	private int count;

	public CsvDataMapper(InputStream input, CsvDataConverter<T> converter){
			this(input, ';', converter);
	}
	
	public CsvDataMapper(String filename, CsvDataConverter<T> converter) throws FileNotFoundException{
		this(new FileInputStream(filename), ';', converter);
}
	
	public CsvDataMapper(InputStream input, char delimiter, CsvDataConverter<T> converter){
		
		try {
			
			reader = new CsvReader(input, Charset.defaultCharset());
			reader.setSafetySwitch(true);
			reader.setSkipEmptyRecords(true);
			reader.setDelimiter(delimiter);
			reader.readHeaders();
			
			setConverter(converter);
			
		} catch (FileNotFoundException e) {
			throw new CsvReadException("Arquivo nao encontrado");
		} catch (IOException e) {
			throw new CsvReadException(e);
		}
	
	}
	
	
	public CsvDataConverter<T> getConverter() {
		return converter;
	}

	public void setConverter(CsvDataConverter<T> converter) throws IOException {
		
		List<String> headers = new ArrayList<String>();
		
		for(String header : reader.getHeaders()){
			headers.add(header);
		}
		
		if(converter.canHandle(headers))
			this.converter = converter;
		else
			throw new CsvFormatException("Converter " + converter.getClass().getName() + " can't handle file");
	}

	@Override
	public boolean hasNext() {
		try {
			if(!reader.readRecord()){
				reader.close();
				return false;
			}
			else 
				return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public T next() {
	
		count++;
		return converter.convert(new CsvFileRow(reader));
		
	}

	@Override
	public void remove() {
		throw new RuntimeException("Illegal Operation");
	}
	
	public int getCount(){
		return count;
	}

	

}
