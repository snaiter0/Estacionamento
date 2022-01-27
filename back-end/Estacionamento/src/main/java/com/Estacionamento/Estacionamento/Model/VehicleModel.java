package com.Estacionamento.Estacionamento.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleModel {
	@GeneratedValue(strategy = GenerationType.IDENTITY) @Id Long idVehicle;
	String modelo;
	String placa;
	String cor;
	

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


