import { Component } from '@angular/core';
import { AutenticacaoService } from '../services/autenticacao.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Usuario } from 'src/app/usuario/model/usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  imagesPath = "/src/assets/images"
  formLogin: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private usuarioService: AutenticacaoService,
              private snackBar: MatSnackBar) {
                this.formLogin = this.formBuilder.group({
                  login: ['', [Validators.required]],
                  senha: ['', [Validators.required]]
                });
               }


  logar(){

    if(this.formLogin.invalid) return;
    var usuario = this.formLogin.getRawValue() as Usuario;
    this.usuarioService.logar(usuario).subscribe((response) => {
        if(!response.sucesso){
          this.snackBar.open('Falha na autenticação', 'Usuário ou senha incorretos.', {
            duration: 3000
          });
        }
    })
  }
}
