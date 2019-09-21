package com.sonnesen.dailycodingproblems.dcp1;

import java.security.InvalidParameterException;

public class BuscadorSoma {

	public boolean buscaSoma(int[] lista, int soma) {

		if (lista.length < 2)
			throw new InvalidParameterException("Lista deve conter pelo menos dois números");

		for (int i = 0; i < lista.length; i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i] + lista[j] == soma)
					return true;
			}
		}
		
		return false;
	}

}
