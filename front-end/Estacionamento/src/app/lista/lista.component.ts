import { getLocaleDateFormat, getLocaleDateTimeFormat } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ClientModel } from '../model/Client';
import { Rotative } from '../model/Rotative';
import { VehicleModel } from '../model/Vehicle';
import { ServicosService } from '../service/servicos.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  Cliente: ClientModel = new ClientModel()
  Veiculo: VehicleModel = new VehicleModel()
  rotativo: Rotative = new Rotative()
  clientEdit: ClientModel
  veiculoEdit: VehicleModel
  rotativoEdit: Rotative
  listarClientes: ClientModel[]
  listarVehicles: VehicleModel[]
  listarRotatives: Rotative[]
  

  constructor(
    private Service: ServicosService,
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
    this.ListAllClients()
    this.ListAllVehicles()
    this.ListAllRotatives()
  }

  ListAllClients() {
    this.Service.listAllClients().subscribe((resp: ClientModel[]) =>
      this.listarClientes = resp
    )
  }

  ListAllVehicles() {
    this.Service.listAllVehicles().subscribe((resp: VehicleModel[]) =>
      this.listarVehicles = resp
    )
  }

  ListAllRotatives() {
    this.Service.listAllRotatives().subscribe((resp: Rotative[]) =>
      this.listarRotatives = resp
    )
  }


}
