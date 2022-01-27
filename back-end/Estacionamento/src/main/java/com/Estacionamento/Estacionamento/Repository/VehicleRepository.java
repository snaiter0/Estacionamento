package com.Estacionamento.Estacionamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estacionamento.Estacionamento.Model.VehicleModel;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Long>{

}
