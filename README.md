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

	public class ClientProcessor {
		
		public static void main(String[] args){
		
			Iterator<Client> iterator = new CsvIterator<Client>("./clients.CSV", new ClientConverter());
			print(iterator);
		
			iterator = new CsvIterator<Client>("./clients.CSV", Client.class); //generic converter
			print(iterator);
	
		}
	
		public static void print(Iterator<Client> iterator) {
		
			while (iterator.hasNext()) {
				Client client = iterator.next();
				System.out.println(client.getName());
			}
		}
	}



