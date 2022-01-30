package com.Estacionamento.Estacionamento.Controller;

import java.util.List;
import java.util.Optional;

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

//Este é o controlador da arquitetura MVC, aqui se situam os endpoints e os métodos consumidos no front-end
//Porém ele não é o unico, também poderia existir um Service, na qual também seria utilizado no front end.

@RestController
@RequestMapping("/Client")		//Estes são os endpoints na qual me referi a cima.
@CrossOrigin("*")
public class ClientController {

	
	@Autowired	//injeção do repositorio ClientRepository
	ClientRepository repository;

	
	//Método para atualizar dados do cliente
	@PutMapping("/UpdateClient")		//Método Put e seu devido endPoint
	ResponseEntity<ClientModel> UpdateClient(@RequestBody ClientModel Client) {
		if (repository.existsById(Client.getIdClient())) {
			return ResponseEntity.status(200).body(repository.save(Client));
		} else {
			return ResponseEntity.status(304).build();
		}
	}

	//Método para criar um novo cliente
	@PostMapping("/Save")			//Método Post e seu devido endPoint
	ResponseEntity<ClientModel> Save(@RequestBody ClientModel Cliente) {
		return ResponseEntity.status(201).body(repository.save(Cliente));
	}

	
	//Método para listar todos os clientes
	@GetMapping("/ListAllClients")	//Método Get e seu devido endPoint
	ResponseEntity<List<ClientModel>> ListAllClients() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	
	//Método para encontrar cliente pelo ID
	@GetMapping("/FindClientById/{ID}")		//Método Get e seu devido endPoint
	ResponseEntity<Optional<ClientModel>> FindById(@PathVariable(value = "ID")Long ID){
		return ResponseEntity.status(200).body(repository.findById(ID));
	}
	
	//Método para encontrar cliente pelo nome
	@GetMapping("/SearchAClient/{Name}")		//Método Get e seu devido endPoint
	ResponseEntity<List<ClientModel>> SearchByName(@PathVariable(value = "Name") String Name) {
		return ResponseEntity.status(200).body(repository.findAllByNameContainingIgnoreCase(Name));
	}

	//Método para excluir um cliente pelo ID
	@DeleteMapping("/Delete/{ID}")				//Método Delete e seu devido endPoint
	void Delete(@PathVariable(value = "ID") Long ID) {
		repository.deleteById(ID);
	}
	
}
