package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        // Recupera la lista dei Pokémon dall'API
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/api/view"; // chiamiamo l'api
        Pokemon[] pokemonArray = restTemplate.getForObject(apiUrl, Pokemon[].class);

        // Stampa la lista dei Pokémon
        System.out.println("Lista dei Pokémon:");
        for (Pokemon pokemon : pokemonArray) {
            System.out.println(pokemon.getName());
        }

        // Chiedi all'utente di scegliere un Pokémon
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il nome del Pokémon che desideri: ");
        String pokemonName = scanner.nextLine();

        // Cerca il Pokémon nella lista
        boolean pokemonFound = false;
        for (Pokemon pokemon : pokemonArray) {
            if (pokemon.getName().equalsIgnoreCase(pokemonName)) {
                System.out.println("Pokémon trovato:");
                System.out.println("ID: " + pokemon.getId());
                System.out.println("Nome: " + pokemon.getName());
                System.out.println("Tipo: " + pokemon.getTipo());
                System.out.println("HP: " + pokemon.getHp());
                pokemonFound = true;
                break;
            }
        }

        // Se il Pokémon non è stato trovato, stampa un messaggio
        if (!pokemonFound) {
            System.out.println("Pokémon non trovato.");
        }

        // Chiudi lo scanner
        scanner.close();
    }
}
