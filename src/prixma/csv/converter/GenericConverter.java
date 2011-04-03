package prixma.csv.converter;

import java.lang.reflect.Field;

import net.vidageek.mirror.dsl.Mirror;
import prixma.csv.datamapper.CsvFile;
import prixma.csv.datamapper.CsvFileRow;

public class GenericConverter<T> implements CsvDataConverter<T> {

	private final Class<T> type;
	
	public GenericConverter(Class<T> type){
		this.type = type;
	}
	
	@Override
	public T convert(CsvFileRow row) {
		
		T target = newInstance();
		
		for(String column : row.getHeaders()) {
			Field field = getField(column);
			setValue(target, field, row.get(column, field.getType()));
		}
	
		return target;
	}
	
	private T newInstance(){
		return new Mirror().on(type).invoke().constructor().withoutArgs();
	}
	
	private Field getField(String columnName){
		return new Mirror().on(type).reflect().field(columnName.toLowerCase()); 
	}
	
	public void setValue(T target, Field field, Object value){
	
		new Mirror().on(target).invoke().setterFor(field).withValue(value);
			
	}

	@Override
	public boolean canHandle(CsvFile file) {
		return true;
	}

}
