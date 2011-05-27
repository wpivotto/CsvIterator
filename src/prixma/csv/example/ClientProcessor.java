package prixma.csv.example;


import java.util.Iterator;

import prixma.csv.datamapper.CsvIterator;
import prixma.csv.datamapper.CsvProcessor;

public class ClientProcessor {
	
	public static void main(String[] args){
		
		CsvProcessor<Client> processor = new CsvProcessor<Client>("./clients.csv", new ClientConverter());
		
		for(Client client : processor){
			System.out.println(client.getName());
		}
		
		processor = new CsvProcessor<Client>("./clients.csv", Client.class);
		
		for(Client client : processor){
			System.out.println(client.getName());
		}
		
		Iterator<Client> iterator = new CsvIterator<Client>("./clients.csv", new ClientConverter());
		
		while (iterator.hasNext()) {
			Client client = iterator.next();
			System.out.println(client.getName());
		}
		
		iterator = new CsvIterator<Client>("./clients.CSV", Client.class);

		while (iterator.hasNext()) {
			Client client = iterator.next();
			System.out.println(client.getName());
		}
	
	}

}
