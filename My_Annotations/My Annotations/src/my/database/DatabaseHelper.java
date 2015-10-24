package my.database;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import my.annotations.ColumnMapping;
import my.annotations.TableMapping;

public class DatabaseHelper {
/**
 * 
 * INSERT INTO table (col1,col2) VALUES(?, ?)
 * 
 * @param o
 * @return
 * @throws IllegalArgumentException
 * @throws IllegalAccessException
 */
	public static String prepareInsertQuery(Object o) throws IllegalArgumentException, IllegalAccessException{
		
		if(!o.getClass().isAnnotationPresent(TableMapping.class)){
			throw new IllegalArgumentException("Invalid object type: annotation required!");
		}
		
		String table_name = o.getClass().getAnnotation(TableMapping.class).tableName();
		
		Field[] fields = o.getClass().getFields();
		
		List<String> columns = new ArrayList<String>();
		
		for(Field field: fields){
			if(field.isAnnotationPresent(ColumnMapping.class)){
				columns.add(field.getAnnotation(ColumnMapping.class).columnName());
			}
		}
		
		StringBuilder resultQuery = new StringBuilder(); 
		
		resultQuery.append("INSERT INTO ").append(table_name).append(" (");
		
		for(String column: columns){
			resultQuery.append(column).append(",");
		}
		
		resultQuery.deleteCharAt(resultQuery.lastIndexOf(","));
		
		resultQuery.append(") VALUES(");
		
		for(int i=0; i < columns.size(); i++){
			String appender = (i == (columns.size() - 1)) ? "?)" : "?,";
			resultQuery.append(appender);
		}
		
		return resultQuery.toString();
	}
	
}

