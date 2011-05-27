package prixma.csv.datamapper;

import java.io.File;
import java.util.Iterator;

import prixma.csv.converter.CsvDataConverter;
import prixma.csv.converter.GenericConverter;

/**
 * @author William Pivotto
 */
public class CsvProcessor<T> implements Iterable<T> {
	
	private CsvIterator<T> iterator;

	public CsvProcessor(File file, CsvDataConverter<T> converter){
		this.iterator = new CsvIterator<T>(file, converter);
	}
	
	public CsvProcessor(String filename, CsvDataConverter<T> converter) {
		this(new File(filename), converter);
	}
	
	public CsvProcessor(String filename, Class<T> type) {
		this(new File(filename), new GenericConverter<T>(type));
	}

	@Override
	public Iterator<T> iterator() {
		return iterator;
	}

}
