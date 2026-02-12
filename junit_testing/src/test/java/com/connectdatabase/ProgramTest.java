package com.connectdatabase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ProgramTest {
	
	@ParameterizedTest
	@ValueSource(strings= {"tenet","radar","aba"})
	public void isPalindrome(String str) {
		Program p = new Program();
		assertTrue(p.isPalindrome(str));
	}
	
	
	@ParameterizedTest
	@ValueSource(ints= {10,9,3})
	public void isPositive(int a) {
		Program p = new Program();
		assertTrue(p.isPositive(a));
	}
	
	@ParameterizedTest
	@CsvSource({"1,2,3", "5,5,10","5,3,8"})
	public void addTest(int a, int b,int expectedResult) {
		Program p = new Program();
		int actualres = p.add(a, b);
		assertEquals(expectedResult,actualres);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/capgemini.csv",numLinesToSkip = 1)
	public void evenOrOddTest(String input,String expected) {
		EvenOrOdd eoo = new EvenOrOdd();
		String actualres=eoo.evenOrOdd(Integer.parseInt(input));
		assertEquals(expected,actualres);
	}

}
