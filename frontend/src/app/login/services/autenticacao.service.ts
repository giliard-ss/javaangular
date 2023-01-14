import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of, tap } from 'rxjs';
import { Usuario } from 'src/app/usuario/model/usuario';

@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService {

  constructor(private router: Router, private httpClient: HttpClient) { }

  logar(usuario: Usuario): Observable<any> {
    /*return this.httpClient.post<any>(apiUrlUsuario + "/login", usuario).pipe(
      tap((resposta) => {
        if(!resposta.sucesso) return;
        localStorage.setItem('token', btoa(JSON.stringify(resposta['token'])));
        localStorage.setItem('usuario', btoa(JSON.stringify(resposta['usuario'])));
        this.router.navigate(['']);
      }));*/
    return this.mockUsuarioLogin(usuario).pipe(tap((resposta) => {
      if (!resposta.sucesso) return;
      localStorage.setItem('token', btoa(JSON.stringify("TokenQueSeriaGeradoPelaAPI")));
      localStorage.setItem('usuario', btoa(JSON.stringify(usuario)));
      this.router.navigate(['']);
    }));
  }

  private mockUsuarioLogin(usuario: Usuario): Observable<any> {
    var retornoMock: any = [];
    if (usuario.login === "master" && usuario.password == "123456") {
      retornoMock.sucesso = true;
      retornoMock.usuario = usuario;
      retornoMock.token = "TokenQueSeriaGeradoPelaAPI";
      return of(retornoMock);
    }
    retornoMock.sucesso = false;
    retornoMock.usuario = usuario;
    return of(retornoMock);
  }

  deslogar() {
    localStorage.clear();
    this.router.navigate(['login']);
  }

  get obterUsuarioLogado(): Usuario {
    return localStorage.getItem('usuario')
      ? JSON.parse(window.atob(localStorage.getItem('usuario')!))
      : null;
  }

  get obterIdUsuarioLogado(): number | null {
    return localStorage.getItem('usuario')
      ? (JSON.parse(window.atob(localStorage.getItem('usuario')!)) as Usuario).id
      : null;
  }

  get obterTokenUsuario(): string {
    return localStorage.getItem('token')
      ? JSON.parse(window.atob(localStorage.getItem('token')!))
      : null;
  }

  get logado(): boolean {
    return localStorage.getItem('token') ? true : false;
  }
}
