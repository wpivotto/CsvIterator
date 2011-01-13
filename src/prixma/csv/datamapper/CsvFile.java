package prixma.csv.datamapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import prixma.csv.exceptions.CsvConvertException;
import prixma.csv.exceptions.CsvReadException;

import com.csvreader.CsvReader;

/**
 * @author William Pivotto
 */
public class CsvFile {
	
	private CsvReader reader;
	private List<String> headers;
	
	public CsvFile(File file){
		
		try {
			
			reader = new CsvReader(new FileInputStream(file), Charset.defaultCharset());
			reader.setSafetySwitch(true);
			reader.setSkipEmptyRecords(true);
			//reader.setDelimiter(delimiter);
			readHeaders();
			
			
		} catch (FileNotFoundException e) {
			throw new CsvReadException("Arquivo nao encontrado");
		} catch (IOException e) {
			throw new CsvReadException(e);
		}
	}
	
	private void readHeaders() throws IOException{

		reader.readHeaders();
		headers = new ArrayList<String>();
		
		for(String header : reader.getHeaders()){
			headers.add(header);
		}
		
	}
	
	public boolean EOF(){
		
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
	
	public CsvFileRow nextRow(){
		return new CsvFileRow(this);
	}
	
	public boolean hasDelimiter(char delimiter){
		return false;
	}

	public boolean containsHeaders(String ...columns){
		return containsHeaders(Arrays.asList(columns));
	}
	
	public boolean containsHeaders(List<String> columns){
		return headers.containsAll(columns);
	}
	
	
	
	
	public String read(String column){
		try {
			return reader.get(column);
		} catch (IOException e) {
			throw new CsvConvertException(e);
		}
	}
	

}
