import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { catchError, of } from 'rxjs';
import {Cliente} from 'src/app/entities/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})

export class LeaderboardComponent {
  list: Cliente[] = []
  cliente: Cliente = {}
  email: string = String(this.route.snapshot.paramMap.get('email'))
  constructor(private clienteService: ClienteService, private router: Router, private route: ActivatedRoute) {

  }
  ngOnInit():void{
    this.findAll();
    this.findByEmail();
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

  findByEmail(): void {
    this.clienteService.findByEmail(this.email).subscribe((clientes) => {
        this.cliente = clientes;
    });
  }

}



// export interface Cliente{
//   email?:String,
//   nome: String,
//   dataCadastro: Data,
//   telefone: String,
//   senha: String,
//   pontos: Number,
//   jogos: BigInt,
//   admin: boolean
// }