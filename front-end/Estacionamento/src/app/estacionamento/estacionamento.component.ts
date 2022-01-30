import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ClientModel } from '../model/Client';
import { Rotative } from '../model/Rotative';
import { VehicleModel } from '../model/Vehicle';
import { ServicosService } from '../service/servicos.service';

@Component({
  selector: 'app-estacionamento',
  templateUrl: './estacionamento.component.html',
  styleUrls: ['./estacionamento.component.css']
})
export class EstacionamentoComponent implements OnInit {

Cliente : ClientModel = new ClientModel
Veiculo : VehicleModel = new VehicleModel
Rotativo : Rotative = new Rotative
IDGet : number

RotativeByID : Rotative = new Rotative()
VehicleByID : VehicleModel = new VehicleModel()
ClientByID : ClientModel = new ClientModel()


  constructor(
    private Service: ServicosService,
    private http: HttpClient
  ) { }

  ngOnInit() { 
    window.scroll(0,0)
  }


  RegistraEntrada(){
    this.Service.newClient(this.Cliente).subscribe((resp: ClientModel) => {
    this.Cliente = resp
    })
    this.Service.newVehicle(this.Veiculo).subscribe((resp: VehicleModel) => {
      this.Veiculo = resp
    })
    this.Service.newRotative(this.Rotativo).subscribe((resp: Rotative)=>{
      this.Rotativo = resp
    })
    alert("Registro de entrada efetuado!")
    window.location.reload()
  }


  RegistraSaida(){
    this.Service.newClient(this.Cliente).subscribe((resp: ClientModel) => {
      this.Cliente = resp
        alert("Registro de Saida efetuado!")
      })
      this.Service.newVehicle(this.Veiculo).subscribe((resp: VehicleModel) => {
        this.Veiculo = resp
      })
      this.Service.newRotative(this.Rotativo).subscribe((resp: Rotative)=>{
        this.Rotativo = resp
      })
      window.location.reload()
    }
  }

