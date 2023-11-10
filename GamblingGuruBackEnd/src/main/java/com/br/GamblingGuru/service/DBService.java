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
		Cliente cliente1 = new Cliente("guru@gmail.com", "Guru", formato.parse("02/06/2000"), "(43) 3945-8799", "gurubambling", true);
        Cliente cliente2 = new Cliente("paula.macedo@yahoo.com.br", "Paula Giron Macedo", formato.parse("02/11/1973"), "(64) 99753-7014", "xQ6meabI(63I");
        Cliente cliente3 = new Cliente("fernando.souza@gmail.com", "Fernando", formato.parse("30/10/1949"), "(17) 97643-1537", "Zx+CKjHhv@l");
        Cliente cliente4 = new Cliente("lara@gmail.com", "Mônica", formato.parse("14/08/2000"), "(13) 98678-5367", "cYO!va$&$li");
        clienteRepository.saveAll(Arrays.asList(cliente1,cliente2,cliente3,cliente4));
        HistoricoJogos historico1 = new HistoricoJogos("Par", 14, "R$:200.00", "R$:150.00", "R$:350.00", cliente1);
        historicoJogos.saveAll(Arrays.asList(historico1));
    }
}
