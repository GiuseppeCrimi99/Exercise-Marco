package com.example.accessingdatamysql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/api") // This means URL's start with /demo (after Application path)

public class MainController {
	/**
	 * Questa classe funge da controller principale per gestire le richieste di rete
	 * e inizializzare il sistema. È responsabile per coordinare le operazioni di
	 * rete e l'inizializzazione dei componenti necessari per il corretto
	 * funzionamento dell'applicazione.
	 */
	@Autowired
	private PokemonRepository pokemonRepository;

	/**
	 * 
	 * @param nuovoPokemon Il nuovo pokemon da aggiungere all pokedex.
	 * @return Un messaggio che conferma l'aggiunta del pokemon.
	 */

	// aggiunge il pokemon al pokedex
//	@PostMapping(path = "/add")
//	public @ResponseBody String aggiungiPokemon(@RequestBody User nuovoPokemon) {
//		pokemonRepository.save(nuovoPokemon);
//		return "Pokemon aggiunto con successo!";
//	}
	@PostMapping(path="/add")
	public @ResponseBody String aggiungiPokemon(@RequestParam String name,@RequestParam String tipo,@RequestParam long hp) {
		Pokemon u = new Pokemon();
		u.setName(name);
		u.setTipo(tipo);
		u.setHp(hp);
		this.pokemonRepository.save(u);
		return "aggiunto";
	}
	
	// vedi tutti i pokemon
	@GetMapping(path = "/view")
	public @ResponseBody Iterable<Pokemon> visualizzaPokedex() {
		return pokemonRepository.findAll();
	}
/**
 * 
 * @param id              L'ID del pokemon da aggiornare.
 * @param name            Il nuovo nome da assegnare al pokemon.
 * @param numeroTelefono  Il nuovo tipo da assegnare al pokemon.
 * @return Un messaggio che conferma l'aggiornamento del pokemon.
 */
	// aggionra un pokemon
	@PutMapping(path = "/aggiorna")
	public @ResponseBody String aggiornaPokemon(@RequestParam Integer id, @RequestParam String name,
			@RequestParam String tipo,@RequestParam long hp) {
		Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
		if (pokemonOptional.isPresent()) {
			Pokemon p = pokemonOptional.get();
			p.setName(name);
			p.setTipo(tipo);
			p.setHp(hp);
			
			pokemonRepository.save(p);
			return "Pokemon aggiornato con successo!";
		} else {
			return "Pokemon non trovato!";
		}
	}
	/**
	 * 
	 * @param id ID del pokemon da eliminare
	 * @return un mesaggio che conferma l'eliminazione del pokemon
	 */
	// rimuove un pokemon
	@DeleteMapping("/delete")
	public String eliminaPokemon(@RequestParam Integer id) {
		Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
		if (pokemonOptional.isPresent()) {
			pokemonRepository.deleteById(id);
			return "Pokemon eliminato con successo!";
		} else {
			return "Pokemon non trovato!";
		}
	}
	// cerca un pokemon per nome
	@GetMapping("/cerca")
	public @ResponseBody Iterable<Pokemon> cercaPokemonPerNome(@RequestParam String name) {
		return pokemonRepository.findByName(name);
	}

	// cerca un pokemon per nome e tipo
	@GetMapping("/cercaPerNomeETipo")
	public @ResponseBody Iterable<Pokemon> cercaPokemonPerNomeETipo(@RequestParam String name,
			@RequestParam String tipo) {
		return pokemonRepository.findByNameAndTipo(name, tipo);
	}
	}
