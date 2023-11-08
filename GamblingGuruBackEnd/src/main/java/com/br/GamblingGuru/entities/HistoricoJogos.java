package com.br.GamblingGuru.entities;

import java.io.Serializable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

//insert into HISTORICO_JOGOS (TIPO_APOSTA, NUMERO_SORTEADO, VALOR_APOSTADO, LUCRO, LUCRO_TOTAL, cliente_email) values ('Par', 14, 'R$:200.00', 'R$:150.00', 'R$:350.00', 'teste@gmail.com')

@Entity(name = "HistoricoJogos")
public class HistoricoJogos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    long id;

    @Column(name = "NumeroJogo")
    long num;

    @Column(name = "TipoAposta")
    String tipo_aposta;

    @Column(name = "NumeroSorteado")
    int numero_sorteado;

    @Column(name = "ValorApostado")
    String valor_apostado;

    @Column(name = "Lucro")
    String lucro;

    @Column(name = "LucroTotal")
    String lucro_total;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cliente_email", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Cliente cliente;

    public HistoricoJogos() {
    }

    public HistoricoJogos(String tipo_aposta, int numero_sorteado, String valor_apostado, String lucro,
            String lucro_total, Cliente cliente) {
        this.tipo_aposta = tipo_aposta;
        this.numero_sorteado = numero_sorteado;
        this.valor_apostado = valor_apostado;
        this.lucro = lucro;
        this.lucro_total = lucro_total;
        this.cliente = cliente;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo_aposta() {
        return tipo_aposta;
    }

    public void setTipo_aposta(String tipo_aposta) {
        this.tipo_aposta = tipo_aposta;
    }

    public int getNumero_sorteado() {
        return numero_sorteado;
    }

    public void setNumero_sorteado(int numero_sorteado) {
        this.numero_sorteado = numero_sorteado;
    }

    public String getValor_apostado() {
        return valor_apostado;
    }

    public void setValor_apostado(String valor_apostado) {
        this.valor_apostado = valor_apostado;
    }

    public String getLucro() {
        return lucro;
    }

    public void setLucro(String lucro) {
        this.lucro = lucro;
    }

    public String getLucro_total() {
        return lucro_total;
    }

    public void setLucro_total(String lucro_total) {
        this.lucro_total = lucro_total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
