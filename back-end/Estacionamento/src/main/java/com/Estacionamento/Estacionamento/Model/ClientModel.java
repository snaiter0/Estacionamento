package com.Estacionamento.Estacionamento.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClientModel {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) @Id Long idClient;
	String name;
	Long fone;

	
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
