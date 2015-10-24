package my;

import java.util.Date;

import my.annotations.ColumnMapping;
import my.annotations.EDataType;
import my.annotations.TableMapping;

@TableMapping(tableName="NEW_STUDENTS")
public class Student {
	
	@ColumnMapping(columnName="sudent_name")
	public String name = "";
	
	@ColumnMapping(columnName="student_age", dateType=EDataType.INT)
	public int age = 0;
	
	@ColumnMapping(columnName="student_graduation", dateType=EDataType.DATE)
	public Date graduation = new Date();
	
	@ColumnMapping(columnName="course")
	public String course = "";
	
	public Student(){
		
	};
	
	public Student(String name, int age, Date graduation) {
		super();
		this.name = name;
		this.age = age;
		this.graduation = graduation;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Date getGraduation() {
		return graduation;
	}
	
}
