package com.example.tdd.intro_tdd;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	
	@Test
	public void calcuatorShouldSum() {
		Calcolatrice c = new Calcolatrice();
		assertEquals(4,c.somma(2, 2));
	}
	
	@Test
	/**
	 *  Con questo metodo sono riusciuto a far passare il test perchè il metodo della sottrazione mi ritorna 0
	 */
	public void calculatorShouldSubtraction() {  
		Calcolatrice c1 = new Calcolatrice();
		assertEquals(0,c1.sottrazione(2,2));		
	}
	
	@Test
	/**
	 * Con questo metodo non sono riuscito a far passare il test perchè il metodo della sottrazione ritorna 0 e lui si aspetta 1
	 */
	public void calculatorShouldSubtraction1() {
		Calcolatrice c2 = new Calcolatrice();
		assertEquals(1,c2.sottrazione(2,1));
	}
	
	@Test
	public void calculatorShouldMultiplication() { //il test non passa perchè si aspetta 2 ma il metodo ritorna 0 
		Calcolatrice c3 = new Calcolatrice();		
		assertEquals(2,c3.moltiplicazione(2, 1));
	}
	
	@Test
	public void calculatorShouldMultiplication2() {
		Calcolatrice c4= new Calcolatrice();
		assertEquals(0,c4.moltiplicazione(2, 0));
	}
	
	@Test
	public void calculatorShouldDivide() {
		Calcolatrice c5 = new Calcolatrice();
		assertEquals(2,c5.divisione(2, 1));
	}
}
