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

import com.Estacionamento.Estacionamento.Model.VehicleModel;
import com.Estacionamento.Estacionamento.Repository.VehicleRepository;

//Controlador de Veiculo.

@RestController
@RequestMapping("/VehicleController") 			//EndPoint do controlador.
@CrossOrigin("*")
public class VehicleController {

												//Injeção do repositorio de veiculos.
	@Autowired VehicleRepository repository;
	
	
	@PostMapping("/Save")						//Metodo Post para registrar um novo carro.
	public ResponseEntity<VehicleModel> Register(@RequestBody VehicleModel VehicleClient){
		return ResponseEntity.status(200).body(repository.save(VehicleClient));
	}
	
	@PutMapping("/Update")						//Metodo Put para atualizar dados do carro.
	public ResponseEntity<VehicleModel> ChangeVehicle(@RequestBody VehicleModel Vehicle){
		return ResponseEntity.status(200).body(repository.save(Vehicle));
	}
	
	@DeleteMapping("/Delete/{ID}")				//Metodo Delete para deletar um carro.
	public void Delete(@PathVariable(value = "ID")Long ID){
		repository.deleteById(ID);
	}
	
	@GetMapping("/FindAllVehicles")				//Metodo Get para listar todos os veiculos.
	ResponseEntity<List<VehicleModel>> FindAllVehicles(){
		return ResponseEntity.status(200).body(repository.findAll());
	}
	
	@GetMapping("/FindVehicleByID/{ID}")		//Metodo Get para encontrar um carro por ID
	ResponseEntity<Optional<VehicleModel>> FindVehicleByID(@PathVariable(value = "ID")Long ID){
		return ResponseEntity.status(200).body(repository.findById(ID));
	}
	
	
}
