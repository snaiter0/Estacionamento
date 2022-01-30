package com.Estacionamento.Estacionamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estacionamento.Estacionamento.Model.Rotative;

@Repository		//Interface que faz conexão com banco de dados MySQL através do Hibernate.
public interface RotativeRepository extends JpaRepository<Rotative, Long>{	//Estabelece o modelo e o tipo da primaryKey

}
