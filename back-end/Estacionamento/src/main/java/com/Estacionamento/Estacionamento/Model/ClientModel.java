package com.Estacionamento.Estacionamento.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity		//Modelo da ficha do cliente.
public class ClientModel {
	
	
	// Atributos do cliente
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) @Id //Estabelece como Primary Key e AutoIncrement
	Long idClient;
	@NotNull	//Estabelece que este campo não pode ser Nulo.
	String name;
	@NotNull	//Estabelece que este campo não pode ser Nulo.
	Long fone;


	
	// Get and Setters dos atributos do cliente.
	
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getFone() {
		return fone;
	}
	public void setFone(Long fone) {
		this.fone = fone;
	}
}
