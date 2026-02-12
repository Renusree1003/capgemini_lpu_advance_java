package com.prac;

public class Employee {

		private int id;
		private String name;
		private int age;
		private String branch;
		public Employee(int id, String name, int age, String branch) {
			
			this.id = id;
			this.name = name;
			this.age = age;
			this.branch = branch;
		}
		public boolean isValidAge() {
			if(age>17) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean isValidName() {
			for(int i=0;i<= name.length();i++) {
				if(Character.isDigit(name.charAt(i))) {
					return false;
				} else if(!(Character.isLetter(name.charAt(i)))) {
					return false;
				}
				
				
			}
			return true;
		}
		

	}

