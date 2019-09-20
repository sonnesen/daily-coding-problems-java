package com.sonnesen.dailycodingproblems.dcp1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sonnesen.dailycodignproblems.dcp1.BuscadorSoma;

class BuscadorSomaTest {

	private BuscadorSoma buscador;

	@BeforeEach
	void setUp() throws Exception {
		buscador = new BuscadorSoma();
	}

	@Test
	void deveLancarExcecaoTest() {
		int soma = 10;
		int[] lista = { 10 };
		assertThrows(InvalidParameterException.class, () -> buscador.buscaSoma(lista, soma));
	}

	@Test
	void naoDeveEncontrarSomaEmListaComApenasDoisNumerosTest() {
		int soma = 10;
		int[] lista = { 10, 7 };
		assertFalse(buscador.buscaSoma(lista, soma));
	}

	@Test
	void deveEncontrarSomaEmListaComApenasDoisNumerosTest() {
		int soma = 17;
		int[] lista = { 10, 7 };
		assertTrue(buscador.buscaSoma(lista, soma));
	}

	@Test
	void deveEncontrarSomaTest() {
		int soma = 17;
		int[] lista = { 10, 15, 3, 7 };
		assertTrue(buscador.buscaSoma(lista, soma));
	}

	@Test
	void naoDeveEncontrarSomaTest() {
		int soma = 15;
		int[] lista = { 10, 15, 3, 7 };
		assertFalse(buscador.buscaSoma(lista, soma));
	}

}
