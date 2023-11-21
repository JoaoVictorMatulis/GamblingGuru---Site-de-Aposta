package com.br.GamblingGuru.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

//insert into cliente(EMAIL, DATA_NASCIMENTO, NOME, SENHA , TELEFONE, pontos) values('teste@gmail.com','2015-12-17', 'teste', 'senha123', '(43) 3945-8799', 2300.30)

@Entity(name = "Cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Email")
    String email;

    @Column(nullable = false, name = "Nome")
    String nome;

    @Column(name = "Telefone")
    String telefone;

    @Column(nullable = false, name = "Senha")
    String senha;

    @Column(name = "pontos")
    int pontos = 10000;

    @Column(name = "Jogos")
    int jogos = 0;

    @Column(name = "Admin")
    boolean admin = false;

    public Cliente() {
    }

    public Cliente(String email, String nome, String telefone, String senha, int pontos) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.pontos = pontos;
    }

    public Cliente(String email, String nome, String telefone, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
    }

    public Cliente(String email, String nome, String senha, int pontos) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.pontos = pontos;
    }

    public Cliente(String email, String nome, String telefone, String senha, int pontos,
            boolean admin) {
        this.email = email;
        this.nome = nome;
        
        this.senha = senha;
        this.telefone = telefone;
        this.pontos = pontos;
        this.admin = admin;
    }

    public Cliente(String email, String nome, String senha, int pontos, boolean admin) {
        this.email = email;
        this.nome = nome;
        
        this.senha = senha;
        this.pontos = pontos;
        this.admin = admin;
    }

    public Cliente(String email, String nome, String telefone, String senha, boolean admin) {
        this.email = email;
        this.nome = nome;
        
        this.senha = senha;
        this.telefone = telefone;
        this.admin = admin;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Cliente [email=" + email + ", nome=" + nome + ", telefone="
                + telefone + ", senha=" + senha + ", pontos=" + pontos + ", jogos=" + jogos + ", admin=" + admin + "]";
    }
}