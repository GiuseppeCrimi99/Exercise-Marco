package com.example.accessingdatamysql;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.Pokemon;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
	Iterable <Pokemon> findByName (String name);//ricerca per nome
	Iterable <Pokemon> findByNameAndTipo (String name,String tipo);//ricerca per nome e tipo
	
}