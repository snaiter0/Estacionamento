package com.Estacionamento.Estacionamento.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estacionamento.Estacionamento.Model.ClientModel;

@Repository			//Interface que faz conexão com banco de dados MySQL através do Hibernate.
public interface ClientRepository extends JpaRepository<ClientModel, Long>{	//Estabelece o modelo e o tipo da primaryKey
	
	public List<ClientModel> findAllByNameContainingIgnoreCase(String name);	//Criando método para listar
	//clientes pelo nome
}
