
import { Component } from '@angular/core';
import { catchError, delay, first, Observable, of, tap } from 'rxjs';
import { Usuario } from '../model/usuario';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent {
  displayedColumns = ['nome','cpf','perfil','situacao']
  usuarios$: Observable<Usuario[]>;

  constructor() {
    this.usuarios$ = this.mockGetUsuarios().pipe(
      catchError(e=>{
       // this.onError('Erro ao carregar lista!');
        return of([]);
      }),
      first(), //só interessa a primeira resposta vinda do backend. Isso fecha a conexao
      delay(1000),
      tap(data=>console.log(data))
    );
  }

  private mockGetUsuarios() : Observable<Usuario[]> {
      let list = [
        { id: 1, nome: "João Batista", cpf: "999.999.999-99", perfil: "COMUM", situacao: "Ativo", login: "", senha: "" },
        { id: 2, nome: "Sandro Oliveira", cpf: "798.540.985-99", perfil: "COMUM", situacao: "Ativo", login: "", senha: "" },
        { id: 3, nome: "Master", cpf: "874.652.746-66", perfil: "MASTER", situacao: "Ativo", login: "", senha: "" },
        { id: 4, nome: "Juliana Brito", cpf: "999.652.842-66", perfil: "COMUM", situacao: "Ativo", login: "", senha: "" },
        { id: 5, nome: "Beatriz Silva", cpf: "632.785.842-66", perfil: "COMUM", situacao: "Ativo", login: "", senha: "" },
      ];
      return of(list);
  }
}
