package prixma.csv.datamapper;

import java.util.List;

/**
 * @author William Pivotto
 */
public class CsvFileRow {
	
	private final CsvFile file;
	
	public CsvFileRow(CsvFile file) {
		this.file = file;
	}
	
	public String get(String column){
		return file.read(column);
	}
	
	public Object get(String column, Class<?> type){
		
		String value = file.read(column);
		
		if(type.equals(String.class))
			return value;
		
		else if(type.equals(Float.class))
			return Float.valueOf(value);
		
		else if(type.equals(Integer.class))
			return Integer.valueOf(value);
		
		else if(type.equals(Long.class))
			return Long.valueOf(value);
		
		else if(type.equals(Boolean.class))
			return Boolean.valueOf(value);
		
		else if(type.equals(Double.class))
			return Double.valueOf(value);
		
		throw new IllegalArgumentException("Illegal Type " + type.getName());
		
		
	}
	
	public int getInt(String column){
		return Integer.valueOf(file.read(column));
	}
	
	public boolean getBool(String column){
		return Boolean.valueOf(file.read(column));
	}
	
	public List<String> getHeaders(){
		return this.file.getHeaders();
	}
	
	
	
	

}
