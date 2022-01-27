package com.Estacionamento.Estacionamento.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estacionamento.Estacionamento.Model.VehicleModel;
import com.Estacionamento.Estacionamento.Repository.VehicleRepository;

@RestController
@RequestMapping("/VehicleController")
@CrossOrigin("*")
public class VehicleController {

	@Autowired VehicleRepository repository;
	
	public ResponseEntity<VehicleModel> Register(@RequestBody VehicleModel VehicleClient){
		return ResponseEntity.status(200).body(repository.save(VehicleClient));
	}
	
	@DeleteMapping("/Delete/{ID}")
	public void Delete(@PathVariable(value = "ID")Long ID){
		repository.deleteById(ID);
	}
	
	
}
