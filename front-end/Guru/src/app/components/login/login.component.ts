import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/entities/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email = '';
  senha = '';
  cliente: Cliente = {};

  constructor(private clienteService: ClienteService, private router: Router) {

  }

  setEmail(event: any){
    this.email = event.target.value;
  }

  setSenha(event: any){
    this.senha = event.target.value;
  }

  async validarLogin(){
    if(this.email === '' || this.senha === ''){
      alert('Um dos campos está vazio')
    }else{
      let emailenviar = this.email;
      let senhaenviar = this.senha;
      alert(emailenviar + " "  +senhaenviar)
      this.clienteService.validarLogin(emailenviar,senhaenviar)
      .subscribe((adms) => {
        this.cliente = adms;
      });
      if(this.cliente.email == null){
        alert('Email ou Senha inválido')
      } else if(this.cliente.email === this.email && this.cliente.senha === this.senha){
        this.logado(this.cliente)
      }else{
        alert('Email ou Senha inválido')
      }
    }    
  }

  logado(cliente: Cliente){
    if(cliente.admin){
      this.router.navigateByUrl(`admin/${cliente.email}`);
    }else{
      this.router.navigateByUrl(`logado/${cliente.email}`);
    }
  }
}
