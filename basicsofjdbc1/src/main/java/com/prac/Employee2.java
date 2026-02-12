package com.prac;
import java.time.LocalDate;
public class Employee2 {
	private int id;
	private String name;
	private double salary;
	private int age;
	private LocalDate dateOfJoining;
	private String branch;
	public Employee2(int id, String name, double salary, int age, LocalDate dateOfJoining, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.dateOfJoining = dateOfJoining;
		this.branch = branch;
	}
	
	public int getAge() {
		return age;
	}

}
