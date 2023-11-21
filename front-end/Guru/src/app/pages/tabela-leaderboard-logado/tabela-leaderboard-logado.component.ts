import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/entities/cliente';
import { ClienteService } from 'src/app/services/cliente.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-tabela-leaderboard-logado',
  templateUrl: './tabela-leaderboard-logado.component.html',
  styleUrls: ['./tabela-leaderboard-logado.component.css']
})
export class TabelaLeaderboardLogadoComponent {
  cliente = new Cliente();

  constructor(private clienteService: ClienteService, private router: Router, private route: ActivatedRoute) {

  }

  email: string = String(this.route.snapshot.paramMap.get('email'))

  ngOnInit(): void {
    this.findByEmail();
  }
  
  findByEmail(): void {
    this.clienteService.findByEmail(this.email).subscribe((cliente) => {
        this.cliente = cliente;
      });
  }
}
