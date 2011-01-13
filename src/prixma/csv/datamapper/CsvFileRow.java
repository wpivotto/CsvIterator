package prixma.csv.datamapper;

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
	
	public int getInt(String column){
		return Integer.valueOf(file.read(column));
	}
	
	public boolean getBool(String column){
		return Boolean.valueOf(file.read(column));
	}
	
	
	
	

}
