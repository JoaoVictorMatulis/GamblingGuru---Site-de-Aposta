import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-home-cliente',
  templateUrl: './home-cliente.component.html',
  styleUrls: ['./home-cliente.component.css']
})
export class HomeClienteComponent {

  email: string = String(this.route.snapshot.paramMap.get('email'));

  constructor(
    private route: ActivatedRoute
  ) {}


}
