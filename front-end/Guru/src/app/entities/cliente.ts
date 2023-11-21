import { Data } from "@angular/router";

export class Cliente{
    email?:String;
    nome?: String;
    dataCadastro?: Data;
    telefone?: String;
    senha?: String;
    pontos?: Number;
    jogos?: Number;
    admin?: boolean
}