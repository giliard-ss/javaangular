import { Component } from '@angular/core';
import { AutenticacaoService } from 'src/app/login/services/autenticacao.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {

  constructor(private auth: AutenticacaoService) { }


  deslogar() {
    this.auth.deslogar();
  }
}
