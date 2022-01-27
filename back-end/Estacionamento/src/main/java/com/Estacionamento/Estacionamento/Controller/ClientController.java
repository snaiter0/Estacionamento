package com.Estacionamento.Estacionamento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estacionamento.Estacionamento.Model.ClientModel;
import com.Estacionamento.Estacionamento.Repository.ClientRepository;

@RestController
@RequestMapping("/Client")
@CrossOrigin("*")
public class ClientController {

	@Autowired
	ClientRepository repository;

	@PutMapping("/UpdateClient")
	ResponseEntity<ClientModel> UpdateClient(@RequestBody ClientModel Client) {
		if (repository.existsById(Client.getIdClient())) {
			return ResponseEntity.status(200).body(repository.save(Client));
		} else {
			return ResponseEntity.status(304).build();
		}
	}

	@PostMapping("/Save")
	ResponseEntity<ClientModel> Save(@RequestBody ClientModel Cliente) {
		return ResponseEntity.status(201).body(repository.save(Cliente));
	}

	@GetMapping("/ListAllClients")
	ResponseEntity<List<ClientModel>> ListAllClients() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	@GetMapping("/SearchAClient/{Name}")
	ResponseEntity<List<ClientModel>> SearchByName(@PathVariable(value = "Name") String Name) {
		return ResponseEntity.status(200).body(repository.findAllByNameContainingIgnoreCase(Name));
	}

	@DeleteMapping("/Delete/{ID}")
	void Delete(@PathVariable(value = "ID") Long ID) {
		repository.deleteById(ID);
	}
	
}
