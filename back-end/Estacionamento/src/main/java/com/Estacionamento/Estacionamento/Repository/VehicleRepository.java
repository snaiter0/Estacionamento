package com.Estacionamento.Estacionamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estacionamento.Estacionamento.Model.VehicleModel;

@Repository				//Interface que faz conexão com banco de dados MySQL através do Hibernate.

//Estabelece o modelo e o tipo da primary Key
public interface VehicleRepository extends JpaRepository<VehicleModel, Long>{	
	

}
