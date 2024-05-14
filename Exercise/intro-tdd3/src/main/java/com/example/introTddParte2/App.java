package com.example.introTddParte2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

/*
 * START Questa applicazione deve fare queste cose: Alla ricezione di un numero
 * da 1 a 100, deve stampare tante righe quanto è il numero in input Il
 * contenuto delle righe cambia in base alla riga per ogni riga si deve stampare
 * il suo numero regola 1: se la riga è divisibile per 3, io voglio stampare
 * "Kuksa!" se la riga è divisibile per 5, io voglio stampare "Sauna!" se la
 * riga è divisibile sia per 3 che per 5, voglio stampare entrambe le stringhe
 * ("Kuksa!Sauna!")
 */
public class App {
//scanner per l'input
	private static Scanner consoleInput = new Scanner(System.in);

	public static void main(String[] args) {
		KuksaSauna ks = new KuksaSauna();
		// chiamo la lettura del numero
		System.out.println("Inserire il numero di righe su cui operare: ");
		int numeroRighe;

		// faccio un controllo sugli input tanto per perdere tempo
		boolean inputMismatch = true;
		do {
			numeroRighe = consoleInput.nextInt();
			if (numeroRighe <= 0 || numeroRighe > 100)
				System.out.println("Il numero da lei scelto non è corretto. Ne inserisca un altro:");
			else
				inputMismatch = false;
		} while (inputMismatch);

		// una volta inserito il numero, genero la mia lista tramite KuksaSauna ed il
		// suo metodo
		ArrayList<String> listaDiRighe = ks.genera(numeroRighe);

		// stampiamo con un foreach
		for (String string : listaDiRighe) {
			System.out.println(string);
		}

	}
}