package com.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
	
	@Test
	public void testGetTypeOfCustomer() {
		UserDao userdao = new UserDao();
		UserService userService = new UserService(userdao);
		String actualRes = userService.typeOfUser(1);
		assertEquals("regular user",actualRes);
	}
	
	@Test
	public void testDoubleAddition() {
		//step 1:to create fake object
		Calculator calmock=mock(Calculator.class);
		//step 2:what mock object should return
		when(calmock.add(5, 5)).thenReturn(20);
		//step 3: give the fake object reference
		MathService service = new MathService(calmock);
		int res = service.doubleAddition(5, 5);
		assertEquals(-1,res);
		
		
		
		
		
	}

}
