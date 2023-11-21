import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {Cliente} from 'src/app/entities/cliente';
import { environment } from 'src/app/environments/environmet';

@Injectable({
  providedIn: 'root'
})

export class ClienteService {

  constructor(private http: HttpClient) {}
  
  findAll(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>(`${environment.baseUrl}`);
  }

  leaderBoard(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>(`${environment.baseUrl}/leaderboard`);
  }

  updateCliente(email: string, cliente: Cliente): Observable<Cliente> {
    const url = `${environment.baseUrl}/${email}`;
    return this.http.put<Cliente>(url, cliente);
  }

  findByEmail(email: String): Observable<Cliente>{
    return this.http.get<Cliente>(`${environment.baseUrl}/${email}`)
  }

  validarLogin(email: String, senha:String): Observable<Cliente>{
    return this.http.get<Cliente>(`${environment.baseUrl}/validarlogin/${email}/${senha}`);
  }

  cadastrar(cliente?: Cliente): Observable<boolean>{
    if(!cliente) return of(false);
    return this.http.post<boolean>(`${environment.baseUrl}`,cliente)
  }

  deletar(email: String): Observable<Cliente>{
    return this.http.delete<Cliente>(`${environment.baseUrl}/${email}`);
  }
}