import { RecoverComponent } from './recover/recover.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LoginOffGuard } from './guards/login-off.guard';

const routes: Routes = [
  {path:'', component:LoginComponent, },
  {path:'recover', component:RecoverComponent, canActivate:[LoginOffGuard]}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
