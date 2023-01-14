import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login/login.component';
import { RecoverComponent } from './recover/recover.component';


@NgModule({
  declarations: [
    LoginComponent,
    RecoverComponent
  ],
  imports: [
    CommonModule,
    LoginRoutingModule,
    AppMaterialModule
  ]
})
export class LoginModule { }
