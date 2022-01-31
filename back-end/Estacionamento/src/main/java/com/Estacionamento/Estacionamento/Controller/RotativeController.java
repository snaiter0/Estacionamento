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

import com.Estacionamento.Estacionamento.Model.Rotative;
import com.Estacionamento.Estacionamento.Repository.RotativeRepository;

// Controlador Rotativo.

@RestController
@CrossOrigin("*") // Seria utilizado caso fosse necessário fazer relacionamento de dados.
@RequestMapping("/Rotative")
public class RotativeController {

	//Injeção do repositorio Rotativo.
	@Autowired RotativeRepository repository;
	
	// Método Save para cadastrar um novo Rotativo.
	@PostMapping("/Save")
	public ResponseEntity<Rotative> Save(@RequestBody Rotative rotative){
		return ResponseEntity.status(201).body(repository.save(rotative));
	}
	
	// Metodo Get para encontrar um rotativo.
	@GetMapping("/FindRotativeByID/{ID}")
	ResponseEntity<Optional<Rotative>> FindRotativeByID(@PathVariable(value = "ID")Long ID){
		return ResponseEntity.status(200).body(repository.findById(ID));
	}
	
	@GetMapping("/FindAllRotatives")
	ResponseEntity<List<Rotative>> FindAllRotatives(){	//Metodo Get para listar todos os rotativos
		return ResponseEntity.status(200).body(repository.findAll());
	}
	
	@PutMapping("/UpdateRotative")
	ResponseEntity<Rotative> ChangeRotative(@RequestBody Rotative rotative){ //Metodo Put para atualizar (encerrar) o rotativo
		return ResponseEntity.status(200).body(repository.save(rotative));
	}
	
	@DeleteMapping("/Delete/{ID}")
	public void Delete(@PathVariable(value = "ID")Long ID) {
		repository.deleteById(ID);
	}
}
