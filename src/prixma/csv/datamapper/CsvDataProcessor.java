package prixma.csv.datamapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

import prixma.csv.exceptions.CsvFormatException;

public class CsvDataProcessor<T> implements Iterator<T> {
	
	private CsvFile file;
	private CsvDataConverter<T> converter;

	public CsvDataProcessor(File file, CsvDataConverter<T> converter){
		
		this.file = new CsvFile(file);
		
		if(converter.canHandle(this.file)){
			this.converter = converter;
		}
		else
			throw new CsvFormatException("Converter " + converter.getClass().getName() + " can't handle file");
	}
	
	public CsvDataProcessor(String filename, CsvDataConverter<T> converter) throws FileNotFoundException{
		this(new File(filename), converter);
	}
	
	@Override
	public boolean hasNext() {
		return file.EOF();
	}

	@Override
	public T next() {
		return converter.convert(file.nextRow());
	}

	@Override
	public void remove() {
		throw new RuntimeException("Illegal Operation");
	}
	

	

}
