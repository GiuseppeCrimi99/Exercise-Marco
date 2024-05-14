package com.example.introTddParte2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.example.introTddParte2.KuksaSauna;

/**
 * Unit test for simple App.
 */
public class AppTest {
// test per vedere se kuksa si trova effettivamnte al numero 3
	@Test
	public void shouldReturnKuksaAtIndex3() {
		KuksaSauna ks = new KuksaSauna();
		ArrayList<String> lista = ks.genera(3);
		assertEquals("Kuksa!", lista.get(2));
	}

// test per vedere se sauna si trova effettivamnte al numero 5
	@Test
	public void shouldReturnSaunaAtIndex5() {
		KuksaSauna ks = new KuksaSauna();
		ArrayList<String> lista = ks.genera(5);
		assertEquals("Sauna!", lista.get(4));
	}

// test per vedere se all'indice 15 è presente Kuksa!Sauna!
	@Test
	public void shouldReturnKuksaSaunaAt15() {
		KuksaSauna ks = new KuksaSauna();
		ArrayList<String> lista = ks.genera(15);
		assertEquals("Kuksa!Sauna!", lista.get(14));
	}

// test per vedere se all'indice 30 è presente Kuksa!Sauna!
	@Test
	public void shouldReturnKuksaSaunaAt30() {
		KuksaSauna ks = new KuksaSauna();
		ArrayList<String> lista = ks.genera(30);
		assertEquals("Kuksa!Sauna!", lista.get(29));
	}

// test per controllare se, in un numero non divisibile sia per 3 che per 5, ci
// sia l'indice della riga
	@Test
	public void shouldReturn1() {
		KuksaSauna ks = new KuksaSauna();
		ArrayList<String> lista = ks.genera(1);
		assertEquals("1", lista.get(0));
	}

// test per vedere se ci sono 4 kuksa all'interno dei primi 12 elementi
	@Test
	public void shouldReturn4Kuksas() {
		KuksaSauna ks = new KuksaSauna();
		ArrayList<String> lista = ks.genera(12);
		int contatore = 0;
		for (String string : lista) {
			if (string.equals("Kuksa!"))
				contatore++;
		}
		assertEquals(4, contatore);
	}

// test per vedere se ci sono 2 sauna all'interno dei primi 12 elementi
	@Test
	public void shouldReturn2Saunas() {
		KuksaSauna ks = new KuksaSauna();
		ArrayList<String> lista = ks.genera(12);
		int contatore = 0;
		for (String string : lista) {
			if (string.equals("Sauna!"))
				contatore++;
		}
		assertEquals(2, contatore);
	}

}