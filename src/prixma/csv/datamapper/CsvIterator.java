package prixma.csv.datamapper;

import java.io.File;
import java.util.Iterator;

import prixma.csv.converter.GenericConverter;
import prixma.csv.exceptions.CsvFormatException;

/**
 * @author William Pivotto
 */
public class CsvIterator<T> implements Iterator<T> {
	
	private CsvFile file;
	private CsvDataConverter<T> converter;

	public CsvIterator(File file, CsvDataConverter<T> converter){
		this.file = new CsvFile(file);
		setConverter(converter);
	}
	
	public CsvIterator(String filename, CsvDataConverter<T> converter) {
		this(new File(filename), converter);
	}
	
	public CsvIterator(String filename, Class<T> type) {
		this(new File(filename), new GenericConverter<T>(type));
	}
	
	private void setConverter(CsvDataConverter<T> converter){
		
		if(converter.canHandle(this.file)){
			this.converter = converter;
		}
		else
			throw new CsvFormatException("Converter " + converter.getClass().getName() + " can't handle file");
		
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
