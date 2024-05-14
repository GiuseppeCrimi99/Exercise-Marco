package com.example.introTddParte2;

import java.util.ArrayList;

public class KuksaSauna {
	public ArrayList<String> genera(int i) {
		ArrayList<String> listaDiFrasi = new ArrayList<>();

// adesso qui vanno le operazioni che mi permetteranno di fillare l'arrayList
		for (int k = 1; k <= i; k++) {
			String risultato = "";
// controlliamo che il resto sia zero per vedere se è divisibile per 3
			if (k % 3 == 0)
				risultato += "Kuksa!";

// controlliamo che il resto sia zero per vedere se è divisibile per 5
			if (k % 5 == 0)
				risultato += "Sauna!";

//se non è divisibile sia per 5 che per 3, allora stampiamo solo l'indice
			if (!(k % 5 == 0 || k % 3 == 0))
				risultato += k;

// aggiungo all'araryList
			listaDiFrasi.add(risultato);
		}

		return listaDiFrasi;
	}
}
