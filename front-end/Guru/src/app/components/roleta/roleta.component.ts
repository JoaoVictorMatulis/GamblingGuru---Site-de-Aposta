import { Component} from '@angular/core';
import { ClienteService } from 'src/app/services/cliente.service';
import { Cliente } from 'src/app/entities/cliente';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-roleta',
  templateUrl: './roleta.component.html',
  styleUrls: ['./roleta.component.css']
})

export class RoletaComponent{
  state: string = 'default';
  rotacao: number = 0;
  tipoAposta = '';
  valorAposta = 0;
  pontosGanhos = 0;
  list: any;
  cliente = new Cliente();
  updatedCliente = new Cliente();
  email: string = String(this.route.snapshot.paramMap.get('email'))

  constructor(private clienteService: ClienteService, private router: Router, private route: ActivatedRoute) {

  }

  leaderBoard(){
    this.router.navigateByUrl(`leaderboardLogado/${this.cliente.email}`);
  }

  ngOnInit(): void {
    this.findByEmail();
  }
  
  findByEmail(): void {
    this.clienteService.findByEmail(this.email).subscribe((clientes) => {
        this.cliente = clientes;
    });
  }

  rotate() {
    if(this.cliente.pontos == null || this.cliente.pontos == undefined){
      this.cliente.pontos = 0
    }
    if(this.tipoAposta == '0' || this.valorAposta <= 0 || this.valorAposta > Number(this.cliente.pontos)){
      alert('Aposta Inválida')
    } else{
      this.apostar();
    }
  }

  apostar() {
    this.updatedCliente = this.cliente
    let numero_sorteado: number = Math.floor(Math.random() * 37);
    let grau = 0;
    if(numero_sorteado == 0){
      grau = 0;
    }if(numero_sorteado == 26){
      grau = 1;
    }if(numero_sorteado == 3){
      grau = 2;
    }if(numero_sorteado == 35){
      grau = 3;
    }if(numero_sorteado == 12){
      grau = 4;
    }if(numero_sorteado == 28){
      grau = 5;
    }if(numero_sorteado == 7){
      grau = 6;
    }if(numero_sorteado == 29){
      grau = 7;
    }if(numero_sorteado == 18){
      grau = 8;
    }if(numero_sorteado == 22){
      grau = 9;
    }if(numero_sorteado == 9){
      grau = 10;
    }if(numero_sorteado == 31){
      grau = 11;
    }if(numero_sorteado == 14){
      grau = 12;
    }if(numero_sorteado == 20){
      grau = 13;
    }if(numero_sorteado == 1){
      grau = 14;
    }if(numero_sorteado == 33){
      grau = 15;
    }if(numero_sorteado == 16){
      grau = 16;
    }if(numero_sorteado == 24){
      grau = 17;
    }if(numero_sorteado == 5){
      grau = 18;
    }if(numero_sorteado == 10){
      grau = 19;
    }if(numero_sorteado == 23){
      grau = 20;
    }if(numero_sorteado == 8){
      grau = 21;
    }if(numero_sorteado == 30){
      grau = 22;
    }if(numero_sorteado == 11){
      grau = 23;
    }if(numero_sorteado == 36){
      grau = 24;
    }if(numero_sorteado == 13){
      grau = 25;
    }if(numero_sorteado == 27){
      grau = 26;
    }if(numero_sorteado == 6){
      grau = 27;
    }if(numero_sorteado == 34){
      grau = 28;
    }if(numero_sorteado == 17){
      grau = 29;
    }if(numero_sorteado == 25){
      grau = 30;
    }if(numero_sorteado == 2){
      grau = 31;
    }if(numero_sorteado == 21){
      grau = 32;
    }if(numero_sorteado == 4){
      grau = 33;
    }if(numero_sorteado == 19){
      grau = 34;
    }if(numero_sorteado == 15){
      grau = 35;
    }if(numero_sorteado == 32){
      grau = 36;
    }
    let rotacaoTotal: number = 9.729 * grau;
    if(this.tipoAposta === "1 até 18"){
       this.pontosGanhos = this.umAteDezoito(numero_sorteado)
    } else if(this.tipoAposta === "19 até 36"){
      this.pontosGanhos = this.dezenoveAteTrintaESeis(numero_sorteado)
    } else if(this.tipoAposta === "Vermelho"){
      this.pontosGanhos = this.vermelho(numero_sorteado)
    } else if(this.tipoAposta === "Preto"){
      this.pontosGanhos= this.preto(numero_sorteado)
    } else if(this.tipoAposta === "Impar"){
      this.pontosGanhos = this.impar(numero_sorteado)
    } else if(this.tipoAposta === "Par"){
      this.pontosGanhos = this.par(numero_sorteado)
    }  else if(this.tipoAposta === "Impar"){
      this.pontosGanhos = this.impar(numero_sorteado)
    } else if(this.tipoAposta === "1º12"){
      this.pontosGanhos = this.umAteDoze(numero_sorteado)
    } else if(this.tipoAposta === "2º12"){
      this.pontosGanhos = this.trezeAteeVinteEQuatro(numero_sorteado)
    } else if(this.tipoAposta === "3º12"){
      this.pontosGanhos = this.vinteECincoAteTrintaESeis(numero_sorteado)
    } else if(numero_sorteado === Number(this.tipoAposta)){
        this.pontosGanhos = Number(this.valorAposta*35);
    } else{
      this.pontosGanhos = -this.valorAposta
    }
 
    this.rotacao = rotacaoTotal + 1080;
    if(this.pontosGanhos > 0){
      alert('Você ganhou, total de pontos ganhos:\n'+this.pontosGanhos+"!")
    }else{
      alert('Você perdeu, boa sorte na proxima vez')
    }
    this.updatedCliente.pontos = Number(this.updatedCliente.pontos) + Number(this.pontosGanhos);
    this.updatedCliente.jogos = Number(this.updatedCliente.jogos) + 1; 
    if(Number(this.updatedCliente.pontos) <= 100){
      alert("Como os seus pontos estão acabando, vamos deixar você com 1000 pontos, para você poder continuar jogando")
      this.updatedCliente.pontos = 1000;
    }
    this.clienteService.updateCliente(String(this.cliente.email), this.updatedCliente).subscribe(
      (data: Cliente) => {
        console.log('Cliente updated successfully:', data);
      },
      error => {
        console.error('Error updating cliente:', error);
      }
    );
    this.router.navigateByUrl(`logado/${this.cliente.email}`);
  }

  setAposta(aposta: any){
    this.tipoAposta = aposta;
  }

  setValor(event: any){
    this.valorAposta = event.target.value;
  }

  umAteDezoito(num: number){
    if(num >=1 && num <=18){
     let pontosGanhos = Number(this.valorAposta/2)
      return pontosGanhos;
    }else{
      let pontosGanhos = -this.valorAposta
      return pontosGanhos;
    }
  }

  dezenoveAteTrintaESeis(num: number){
    if(num >=19 && num <=36){
      let pontosGanhos = Number(this.valorAposta/2)
      return pontosGanhos;
    }else{
      let pontosGanhos = -this.valorAposta
      return pontosGanhos;
    }
  }

  impar(num: number){
    if(num%2 == 1){
      let pontosGanhos = Number(this.valorAposta/2)
      return pontosGanhos;
    }else{
      let pontosGanhos = -this.valorAposta
      return pontosGanhos;
    }
  }

  par(num: number){
    if(num%2 == 0){
      let pontosGanhos = Number(this.valorAposta/2)
      return pontosGanhos;
    }else{
      let pontosGanhos = -this.valorAposta
      return pontosGanhos;
    }
  }

  vermelho(num: number){
    const vermelho = [1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36];
    for(let items of vermelho){
      if(num == items){
        let pontosGanhos = Number(this.valorAposta/2)
        return pontosGanhos;
      }
    }
    let pontosGanhos = -this.valorAposta
      return pontosGanhos;
  }

  preto(num: number){
    const preto = [2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35];
    for(let items of preto){
      if(num == items){
        let pontosGanhos = Number(this.valorAposta/2)
        return pontosGanhos;
      }
    }
    let pontosGanhos = -this.valorAposta
      return pontosGanhos;
  }

  umAteDoze(num: number){
    if(num >= 1 && num <=12){
      let pontosGanhos = Number(this.valorAposta)
        return pontosGanhos;
    }else{
      let pontosGanhos = -this.valorAposta
      return pontosGanhos;
    }
  }
  
  trezeAteeVinteEQuatro(num: number){
    if(num >= 13 && num <=24){
      let pontosGanhos = Number(this.valorAposta)
        return pontosGanhos;
    }else{
      let pontosGanhos = -this.valorAposta
      return pontosGanhos;
    }
  }

  vinteECincoAteTrintaESeis(num: number){
    if(num >= 25 && num <=26){
      let pontosGanhos = Number(this.valorAposta)
        return pontosGanhos;
    }else{
      let pontosGanhos = -this.valorAposta
      return pontosGanhos;
    }
  }
}