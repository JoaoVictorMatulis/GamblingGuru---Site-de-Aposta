package com.br.GamblingGuru.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

//insert into cliente(EMAIL, DATA_NASCIMENTO, NOME, SENHA , TELEFONE, SALDO) values('teste@gmail.com','2015-12-17', 'teste', 'senha123', '(43) 3945-8799', 2300.30)

@Entity(name = "Cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Email")
    String email;

    @Column(nullable = false, name = "Nome")
    String nome;

    @Column(nullable = false, name = "DataNascimento")
    Date dataNascimento;

    @Column(name = "Telefone")
    String telefone;

    @Column(nullable = false, name = "Senha")
    String senha;

    @Column(name = "Saldo")
    double saldo;

    public Cliente() {
    }

    public Cliente(String email, String nome, Date dataNascimento, String telefone, String senha, double saldo) {
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.senha = senha;
        this.saldo = saldo;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente [email=" + email + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", telefone="
                + telefone + ", senha=" + senha + ", saldo=" + saldo + "]";
    }

}