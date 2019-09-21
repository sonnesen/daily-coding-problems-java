package com.sonnesen.dailycodingproblems.dcp2;

public class Calculadora {

	public int[] multiplica(int[] input) {
		int[] resultado = new int[input.length];
		
		for (int i = 0; i < input.length; i++) {
			int produto = 1;
			
			for (int j = 0; j < input.length; j++) {
				if (j == i) continue;
				produto *= input[j];
			}
			resultado[i] = produto;
		}
		
		return resultado;
	}

}
