package com.br.GamblingGuru.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.br.GamblingGuru.entities.Cliente;
import com.br.GamblingGuru.repositories.ClienteRepository;

@Configuration
@Service
public class DBService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Bean
    public void instanciarDB() throws ParseException{
		Cliente cliente1 = new Cliente("guru@gmail.com", "Guru", "(43) 3945-8799", "gurubambling", true);
        Cliente cliente2 = new Cliente("paula.macedo@yahoo.com.br", "Paula Giron Macedo", "(64) 99753-7014", "xQ6meabI(63I");
        Cliente cliente3 = new Cliente("fernando.souza@gmail.com", "Fernando" , "(17) 97643-1537", "Zx+CKjHhv@l");
        Cliente cliente4 = new Cliente("lara@gmail.com", "Mônica", "(13) 98678-5367", "cYO!va$&$li");
        Cliente cliente5 = new Cliente("a", "Mônica", "(13) 98678-5367", "a", true);
        clienteRepository.saveAll(Arrays.asList(cliente1,cliente2,cliente3,cliente4,cliente5));
    }
}
