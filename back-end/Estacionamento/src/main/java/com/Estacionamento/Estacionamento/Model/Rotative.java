package com.Estacionamento.Estacionamento.Model;

import java.sql.Date;
import java.text.DateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity		//Modelo dos atributos do Rotativo
public class Rotative {

	
			//Atributos do modelo
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Estabelece como Primary Key e AutoIncrement
	Long id;	
	@NotNull java.util.Date entrada;
	java.util.Date saida;
	
	
			//Get And Setters dos atributos.
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public java.util.Date getEntrada() {
		return entrada;
	}
	public void setEntrada(java.util.Date entrada) {
		this.entrada = entrada;
	}
	public java.util.Date getSaida() {
		return saida;
	}
	public void setSaida(java.util.Date saida) {
		this.saida = saida;
	}
	
}
