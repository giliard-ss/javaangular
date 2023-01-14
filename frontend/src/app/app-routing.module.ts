import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginOffGuard } from './login/guards/login-off.guard';
import { LoginOnGuard } from './login/guards/login-on.guard';

const routes: Routes = [
  { path: '', pathMatch:'full', redirectTo:'principal'},
  { path: 'principal', loadChildren: () => import('./principal/principal.module').then(m => m.PrincipalModule), canActivate: [LoginOnGuard]},
  { path: 'login', loadChildren: () => import('./login/login.module').then(m => m.LoginModule), canActivate: [LoginOffGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
