package com.br.GamblingGuru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.GamblingGuru.entities.Cliente;
import com.br.GamblingGuru.repositories.ClienteRepository;

@Service
public class GamblingService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente findById(String email){
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        return cliente.orElse(null);
    }
}
