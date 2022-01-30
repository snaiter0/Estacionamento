import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClientModel } from '../model/Client';
import { Rotative } from '../model/Rotative';
import { VehicleModel } from '../model/Vehicle';

@Injectable({
  providedIn: 'root'
})
export class ServicosService {

  constructor(
    private http: HttpClient
  ) { }

    newClient(clientModel: ClientModel):Observable<ClientModel>{
    return this.http.post<ClientModel>("http://localhost:8080/Client/Save", clientModel)
    }

    updateClient(clientModel: ClientModel):Observable<ClientModel>{
      return this.http.put<ClientModel>("http://localhost:8080/Client/UpdateClient", clientModel)
    }

    updateVehicle(vehicleModel: VehicleModel):Observable<VehicleModel>{
      return this.http.put<VehicleModel>("http://localhost:8080/VehicleController/Update", vehicleModel)
    }

    updateRotative(rotative: Rotative) : Observable<Rotative>{
      return this.http.put<Rotative>("http://localhost:8080/Rotative/UpdateRotative", rotative)
    }

    getClientByID(id: number): Observable<ClientModel>{
    return this.http.get<ClientModel>(`http://localhost:8080/Client/FindClientById/${id}`)
    }

    getVehicleByID(id: number) : Observable<VehicleModel>{
      return this.http.get<VehicleModel>(`http://localhost:8080/VehicleController/FindVehicleByID/${id}`)
    }

    getRotativeByID(id: number) : Observable<Rotative>{
      return this.http.get<Rotative>(`http://localhost:8080/Rotative/FindRotativeByID/${id}`)
    }
    
    newVehicle(vehicleModel:VehicleModel): Observable<VehicleModel>{
      return this.http.post<VehicleModel>("http://localhost:8080/VehicleController/Save", vehicleModel)
    }

    newRotative(rotative:Rotative) : Observable<Rotative>{
      return this.http.post<Rotative>("http://localhost:8080/Rotative/Save", rotative)
    }

    listAllClients(): Observable<ClientModel[]>{
      return this.http.get<ClientModel[]>("http://localhost:8080/Client/ListAllClients")
    }

    listAllVehicles(): Observable<VehicleModel[]>{
      return this.http.get<VehicleModel[]>("http://localhost:8080/VehicleController/FindAllVehicles")
    }

    listAllRotatives(): Observable<Rotative[]>{
      return this.http.get<Rotative[]>("http://localhost:8080/Rotative/FindAllRotatives")
    }


}
