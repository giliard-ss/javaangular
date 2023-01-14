import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AutenticacaoService } from '../services/autenticacao.service';

@Injectable({
  providedIn: 'root'
})
export class LoginOffGuard implements CanActivate {

  constructor(
    private auth: AutenticacaoService,
    private router: Router) { }


  canActivate() {
    if (this.auth.logado) {
      this.router.navigate(['']);
      return false;
    }
    return true;
  }

}
