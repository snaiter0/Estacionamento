import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarComponent } from './editar/editar.component';
import { EstacionamentoComponent } from './estacionamento/estacionamento.component';
import { ListaComponent } from './lista/lista.component';
import { SaidaComponent } from './saida/saida.component';

const routes: Routes = [
  {path: '', redirectTo: 'estacionamento',pathMatch: 'full'},

  {path:'estacionamento', component: EstacionamentoComponent},
  {path: 'lista', component: ListaComponent},
  {path: 'editar/:id', component: EditarComponent},
  {path: 'saida/:id', component: SaidaComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
