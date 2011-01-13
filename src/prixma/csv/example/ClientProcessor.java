package prixma.csv.example;


import java.util.Iterator;

import prixma.csv.datamapper.CsvIterator;

public class ClientProcessor {
	
	public static void main(String[] args){
		
		//Iterator<Client> iterator = new CsvIterator<Client>("./clients.CSV", new ClientConverter());
		Iterator<Client> iterator = new CsvIterator<Client>("./clients.CSV", Client.class);
		
		while (iterator.hasNext()) {
			
			Client client = iterator.next();
			System.out.println(client.getName());
			
		}
	
	}

}
