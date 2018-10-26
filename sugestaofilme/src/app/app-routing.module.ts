import { NgModule, Component } from '@angular/core';
import { RouterModule , Routes } from '@angular/router';
import { ListarFilmeComponent } from './listar-filme/listar-filme.component';
import { DetalheComponent } from './detalhe/detalhe.component';

const routes: Routes = [
  {path:'', redirectTo:'filme', pathMatch: 'full' },
  {path:'filme', component: ListarFilmeComponent},
  {path:'filme/:Title', component: ListarFilmeComponent},
  {path: 'filme/detalhe/:imdbID', component: DetalheComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
