import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/entities/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {
  email = '';
  nome = '';
  telefone = '';
  senha = '';
  cliente = new Cliente();

  constructor(private clienteService: ClienteService, private router: Router) {

  }

  setEmail(event: any){
    this.email = event.target.value;
  }

  setNome(event: any){
    this.nome = event.target.value;
  }

  setTelefone(event: any){
    this.telefone = event.target.value;
  }

  setSenha(event: any){
    this.senha = event.target.value;
  }

  async validarCadastro(){
    if(this.email == '' || this.nome == '' || this.telefone == '' || this.senha == ''){
      alert('Um dos campos está vazio')
    }else if( await this.validarLogin(this.email)){
      this.cliente.email = this.email;
      this.cliente.nome = this.nome;
      this.cliente.telefone = this.telefone;
      this.cliente.senha = this.senha;
      this.clienteService.cadastrar(this.cliente).subscribe(
        (error) =>{
          if(error) console.log(error) 
        }
      );
      alert('Email cadastrado com sucesso')
      this.logar()
    } else{
      alert('Email já cadastrado')
    }
  }

//   if (this.produto.nome !== "" && this.produto.preco>0) {
//     this.produtoService.inserirProduto(this.produto).subscribe(
//       (error) => {
//         this.buscarProdutos();
//         if (error) console.log(error);
//       }
//     );
//     console.log(this.produto.descricao)
//     this.snackBar.open("Produto cadastrado!", "OK!");
//   } else {
//     this.snackBar.open("O Nome ou preço do produto invalido!", "OK!");
//   }
// }


  async validarLogin(email:String){
    let teste: any;
    teste = await this.clienteService.validarLogin(this.email, this.senha)
    if(teste == null){
      return true;
    } else if(email === teste.email){
      return false;
    }
    return true;
  }

  logar(){
    this.router.navigateByUrl(``);
  }
}
