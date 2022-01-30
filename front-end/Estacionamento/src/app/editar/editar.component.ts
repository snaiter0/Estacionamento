import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientModel } from '../model/Client';
import { consulta } from '../model/Consulta';
import { Rotative } from '../model/Rotative';
import { VehicleModel } from '../model/Vehicle';
import { ServicosService } from '../service/servicos.service';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})

export class EditarComponent implements OnInit {
  vehicle : VehicleModel = new VehicleModel()
  ClientByID: ClientModel
  VehicleByID: VehicleModel
  RotativeByID: Rotative = new Rotative()
  Consulta: consulta
  id = this.route.snapshot.params['id']

  constructor(
    private Service: ServicosService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    window.scroll(0,0)

    let id = this.route.snapshot.params['id']
    this.ConsultaEntrada(id)
  }

  ConsultaEntrada(id: number) {
    this.Service.getClientByID(id).subscribe((resp: ClientModel) => {
      this.ClientByID = resp
      console.log(resp);
    })
      this.Service.getVehicleByID(id).subscribe((resp: VehicleModel) => {
        this.VehicleByID = resp
        console.log(resp);
      })
        this.Service.getRotativeByID(id).subscribe((resp: Rotative) => {
          this.RotativeByID = resp
          console.log(resp);
})
}

encerrar(){
this.Service.updateRotative(this.RotativeByID).subscribe((resp:Rotative)=>{
  this.RotativeByID = resp;
  alert("Saída contabilizada.")
})
}

EditarClient(){
  this.Service.updateClient(this.ClientByID).subscribe((resp:ClientModel)=>{
    this.ClientByID= resp;
    alert("Dados do cliente atualizado.");
  })
}

EditarVehicle(){
  this.Service.updateVehicle(this.VehicleByID).subscribe((resp:VehicleModel)=>{
    this.VehicleByID = resp;
    alert("Dados do veiculo atualizado.");
  })
}

EditarRotative(){
  this.Service.updateRotative(this.RotativeByID).subscribe((resp:Rotative)=>{
    this.RotativeByID = resp;
    alert("Dados do rotativo atualizado.");
  })
}

}