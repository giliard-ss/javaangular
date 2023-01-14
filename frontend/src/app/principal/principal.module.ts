import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PrincipalRoutingModule } from './principal-routing.module';
import { PrincipalComponent } from './principal/principal.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';



@NgModule({
  declarations: [
    PrincipalComponent
  ],
  imports: [
    CommonModule,
    PrincipalRoutingModule,
    AppMaterialModule
  ]
})
export class PrincipalModule { }
