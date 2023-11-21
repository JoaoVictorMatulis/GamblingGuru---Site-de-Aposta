import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { catchError, of } from 'rxjs';
import {Cliente} from 'src/app/entities/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  list: Cliente[] = [];
  cliente: Cliente = {};
  clientePesquisa: Cliente ={};
  email: string = String(this.route.snapshot.paramMap.get('email'));
  emailCliente: String = '';
  teste: boolean = false;
  constructor(private clienteService: ClienteService, private router: Router, private route: ActivatedRoute) {

  }
  ngOnInit():void{
    this.findAll();
    this.findByEmail(this.email);
  }
  
  findAll(): void{
    this.clienteService.leaderBoard()
    .pipe(
      catchError((error) => {
        return of([]);
      })
    )
    .subscribe((adms) => {
      this.list= adms;
    });
  }

  findByEmail(email:String): void {
    this.clienteService.findByEmail(email).subscribe((clientes) => {
        this.cliente = clientes;
    });
  }

  findCliente(email:String): void {
    this.clienteService.findByEmail(email).subscribe((clientes) => {
        this.clientePesquisa = clientes;
    });
  }

  setEmail(event: any): void{
    this.emailCliente = event.target.value;
  }

  setAdmin(event: any): void{
    this.clientePesquisa.admin = event.target.checked;
    alert( this.clientePesquisa.admin);
  }

  setPontos(event: any): void{
    this.clientePesquisa.pontos = event.target.value;
  }

  editar(email: String | undefined, admin: Boolean | undefined, pontos: Number | undefined):void{
    if(email == undefined || admin == undefined || pontos == undefined){
      alert("ERRO")
    }else{
      this.clientePesquisa.email = email;
      this.clientePesquisa.admin = Boolean(admin);
      this.clientePesquisa.pontos = pontos;
    }
  }

  excluir(email: String | undefined):void{
    if(email == undefined){
      alert('ERRO')
    }else{
      this.clienteService.deletar(String(email)).subscribe((cleinte)=>{
        alert("Cliente removido!!!")
        this.findAll();
      })
    }
  }

  alterar(email: String | undefined, alteracao: Cliente | undefined){
    if(email == undefined || alteracao == undefined){
      alert('ERRO')
    }else{
      this.clienteService.updateCliente(String(email), alteracao).subscribe((cleinte)=>{
        alert("Alteração feita com sucesso!!!")
        this.findAll();
      })
    }
  }
}
