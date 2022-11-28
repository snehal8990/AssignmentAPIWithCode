package com.APITest.Employee;



public class POJOEmployeeClass {
	private String name;
	private String email;
	private String salary;
	private String married;
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public static void ToString(POJOEmployeeClass obj ) {
		System.out.println("Employee Email ID : "+obj.getEmail());
		System.out.println("EMployee Name : "+obj.getName());
		System.out.println("EMployee id : "+obj.getId());
		System.out.println("Employee Salary :"+obj.getSalary());
		System.out.println("Employee Marrital Status : "+obj.getMarried());
		
	}
	
}
