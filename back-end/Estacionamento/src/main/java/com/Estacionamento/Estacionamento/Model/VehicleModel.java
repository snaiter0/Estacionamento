package com.Estacionamento.Estacionamento.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity			//Modelo de Veiculo
public class VehicleModel {
	
	//Atributos do modelo de Veiculo.
	@GeneratedValue(strategy = GenerationType.IDENTITY) @Id //Estabelece como Primary Key e AutoIncrement
	Long idVehicle;
	@NotNull 	//Estabelece que este campo não pode ser Nulo.
	String modelo;
	@NotNull	//Estabelece que este campo não pode ser Nulo.
	String placa;
	@NotNull	//Estabelece que este campo não pode ser Nulo.
	String cor;
	

	//Get And Setters dos atributos do Veiculo
	public Long getIdVehicle() {
		return idVehicle;
	}
	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	
}


