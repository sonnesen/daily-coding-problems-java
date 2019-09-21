package com.sonnesen.dailycodingproblems.dcp2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	
	private Calculadora calculadora;
	
	@BeforeEach
	void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	@Test
	void multiplicaCincoNumerosTest() {
		int[] input = {1,2,3,4,5};
		int[] result = calculadora.multiplica(input);
		int[] expected = {120,60,40,30,24};
		assertArrayEquals(expected, result);
	}
	
	@Test
	void multiplicaTresNumerosTest() {
		int[] input = {3,2,1};
		int[] result = calculadora.multiplica(input);
		int[] expected = {2,3,6};
		assertArrayEquals(expected, result);
	}
	
	@Test
	void multiplicaDoisNumerosTest() {
		int[] input = {2,5};
		int[] result = calculadora.multiplica(input);
		int[] expected = {5,2};
		assertArrayEquals(expected, result);
	}

}
