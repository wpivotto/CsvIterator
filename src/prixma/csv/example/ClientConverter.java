package prixma.csv.example;

import java.util.Arrays;
import java.util.List;

import prixma.csv.datamapper.CsvDataConverter;
import prixma.csv.datamapper.CsvFileRow;

public class ClientConverter implements CsvDataConverter<Client> {

	@Override
	public Client convert(CsvFileRow row) {
		
		Client client = new Client();
			
		client.setName(row.get("Name"));
		client.setAge(row.getInt("Age"));
		
		return client;
		
	}

	@Override
	public boolean canHandle(List<String> headers) {
		return headers.containsAll(Arrays.asList("Name", "Age"));
	}

}
