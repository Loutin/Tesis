import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ServiciosComponent } from './servicios.component';
import { CategoriasComponent } from '../categorias/categorias.component';

const routes: Routes = [
  {
    path: 'servicios',
    component: ServiciosComponent,
    children: [{ path: ':category', component: CategoriasComponent }],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ServiciosRoutingModule {}
