package com.br.GamblingGuru.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.br.GamblingGuru.entities.Cliente;
import com.br.GamblingGuru.entities.HistoricoJogos;
import com.br.GamblingGuru.repositories.ClienteRepository;
import com.br.GamblingGuru.repositories.HistoricoJogosRepository;

@Service
public class DBService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired 
    private HistoricoJogosRepository historicoJogos;

    @Bean
    public void instanciarDB() throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Cliente cliente1 = new Cliente("teste@gmail.com", "teste", formato.parse("02/06/2003"), "(43) 3945-8799", "senha123", 2300.30);
        clienteRepository.saveAll(Arrays.asList(cliente1));
        HistoricoJogos historico1 = new HistoricoJogos("Par", 14, "R$:200.00", "R$:150.00", "R$:350.00", cliente1);
        historicoJogos.saveAll(Arrays.asList(historico1));
    }
}
