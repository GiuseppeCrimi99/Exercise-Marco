package com.example.accessingdatamysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/**
 * Questa classe rappresenta un pokemon nel sistema.
 * 
 * Ogni istanza di questa classe rappresenta un pokemon con un ID univoco generato automaticamente,
 * un nome un tipo e hp
 * 
 * Questa classe è stata annotata con @Entity per indicare a Hibernate di creare una tabella
 * nel database relazionale corrispondente a questa classe.
 * 
 * @author Giuseppe Crimi
 */
@Entity // This tells Hibernate to make a table out of this class
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String tipo;
	
	private long hp;

	public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo= tipo;
	}
}