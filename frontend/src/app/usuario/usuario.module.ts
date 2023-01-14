import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsuarioRoutingModule } from './usuario-routing.module';
import { UsuarioComponent } from './usuario/usuario.component';
import { UsuarioFormComponent } from './usuario-form/usuario-form.component';


@NgModule({
  declarations: [
    UsuarioComponent,
    UsuarioFormComponent
  ],
  imports: [
    CommonModule,
    UsuarioRoutingModule,
    AppMaterialModule
  ]
})
export class UsuarioModule { }
