package lu.cronos._08_reactive_streams;

import java.util.Arrays;
import java.util.List;

class Employee {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Employee(int i, String s) {
		this.id = i;
		this.name = s;
	}
	
	public Employee() {
	}
	
	@Override
	public String toString() {
		return "[id="+id+",name="+name+"]";
	}
}

public class EmployeeHelper {

	public static List<Employee> getAllEmployees() {

		return Arrays.asList(new Employee(1, "Julien"), 
				new Employee(2, "Eric"), 
				new Employee(3, "Lisa"),
				new Employee(4, "Emma"), 
				new Employee(5, "Valentin"));
	}
}
