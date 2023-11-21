import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/entities/cliente';
import { ClienteService } from 'src/app/services/cliente.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-header-admin',
  templateUrl: './header-admin.component.html',
  styleUrls: ['./header-admin.component.css']
})
export class HeaderAdminComponent implements OnInit {
  cliente = new Cliente();
  nome = ''
  saldo = 0;
  
  // constructor(private clienteService: ClienteService,private router: Router, private route: ActivatedRoute) {}
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

    this.nome = String(this.cliente.nome)
    this.saldo = Number(this.cliente.pontos)
  }

  leaderBoard(){
    this.router.navigateByUrl(`leaderboardLogado/${this.cliente.email}`);
  }

  voltar(){
    this.router.navigateByUrl(`logado/${this.email}`);
    typeof(this.cliente)
  }
}
