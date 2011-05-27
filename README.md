## Create your model

	public class Client {
	
		private String name;
		private int age;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
			
	}

## Create your converter

	public class ClientConverter implements CsvDataConverter<Client> {
	
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

## Now you can iterate over an csv file, like this

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



