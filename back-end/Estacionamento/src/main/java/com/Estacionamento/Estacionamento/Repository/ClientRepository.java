package com.Estacionamento.Estacionamento.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estacionamento.Estacionamento.Model.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long>{
	
	public List<ClientModel> findAllByNameContainingIgnoreCase(String name);

}
