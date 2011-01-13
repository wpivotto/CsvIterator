package prixma.csv.example;


import java.util.Iterator;

import prixma.csv.datamapper.CsvIterator;

public class ClientProcessor {
	
	public static void main(String[] args){
		
		print(new CsvIterator<Client>("./clients.CSV", new ClientConverter()));
		print(new CsvIterator<Client>("./clients.CSV", Client.class));
	
	}
	
	public static void print(Iterator<Client> iterator) {
		
		while (iterator.hasNext()) {
			
			Client client = iterator.next();
			System.out.println(client.getName());
			
		}
		
	}

}
