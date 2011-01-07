package prixma.csv.example;

import prixma.csv.datamapper.CsvDataConverter;
import prixma.csv.datamapper.CsvFile;
import prixma.csv.datamapper.CsvFileRow;

public class ClientConverter implements CsvDataConverter<Client> {

	@Override
	public Client convert(CsvFileRow row) {
		
		Client client = new Client();
			
		client.setName(row.get("Name"));
		client.setAge(row.getInt("Age"));
		
		return client;
		
	}
	
	public boolean canHandle(CsvFile file) {
		return file.containsHeaders("Name", "Age");
	}


}
