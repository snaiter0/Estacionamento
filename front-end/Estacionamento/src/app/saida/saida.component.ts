import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientModel } from '../model/Client';
import { consulta } from '../model/Consulta';
import { Rotative } from '../model/Rotative';
import { VehicleModel } from '../model/Vehicle';
import { ServicosService } from '../service/servicos.service';

@Component({
  selector: 'app-saida',
  templateUrl: './saida.component.html',
  styleUrls: ['./saida.component.css']
})
export class SaidaComponent implements OnInit {

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


}

