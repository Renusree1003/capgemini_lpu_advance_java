package com.mockito;

public class MathService {
	Calculator cal;
	MathService(Calculator cal){
		this.cal = cal;
	}
	public int doubleAddition(int a, int b) {
		//return 2*cal.add(a, b);
		return -1;
		
	}

}
