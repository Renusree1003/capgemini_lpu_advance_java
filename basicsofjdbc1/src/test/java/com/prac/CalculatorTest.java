package com.prac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {	
	
	@Test
	public void addTest() {
	int res=Calculator.add(20,30);
}
	@Test
	public void reverseTest() {
		String actualres=Calculator.reverseString("data");
		assertEquals("atad",actualres);
	}
	
	@Test
	public void reverseTestNull() {
		String actualRes=Calculator.reverseString(null);
		assertEquals("llun",actualRes);
	}
	
	@Test
	public void testValidAge() {
		Employee e = new Employee(10, "allen",20,"cse");
		assertTrue(e.isValidAge());
	}
	
	@Test
	public void testValidName() {
		Employee e = new Employee(20, "renu", 20, "CSE");
		assertTrue(e.isValidName());
	}
	
}