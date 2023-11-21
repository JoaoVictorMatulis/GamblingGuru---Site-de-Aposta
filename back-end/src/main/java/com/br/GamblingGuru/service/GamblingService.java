package com.br.GamblingGuru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.br.GamblingGuru.entities.Cliente;
import com.br.GamblingGuru.repositories.ClienteRepository;

@Service
public class GamblingService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente findById(String email){
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        return cliente.orElse(null);
    }

    public List<Cliente> leaderboard() {
        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.DESC, "pontos"));
        return clientes;
    }

    public Cliente validarLogin(String email, String senha) {
        Optional<Cliente> cliente = clienteRepository.validarLogin(email, senha);
        return cliente.orElse(null);
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(String email, Cliente cliente) {
        Cliente alterado = findById(email);
        if(alterado != null){
            if(cliente.getNome() != null){
                alterado.setNome(cliente.getNome());
            }
            if(cliente.getTelefone() != null){
                alterado.setTelefone(cliente.getTelefone());
            }
            if(cliente.getSenha() != null){
                alterado.setSenha(cliente.getSenha());
            }
            if(cliente.getPontos() != 0){
                alterado.setPontos(cliente.getPontos());
            }
            if(cliente.getJogos() != 0){
                alterado.setJogos(cliente.getJogos());
            }
            if(cliente.isAdmin() != alterado.isAdmin()){
                alterado.setAdmin(cliente.isAdmin());
            }
            return clienteRepository.save(alterado);
        }
        return null;
    }

    public void deletar(String email) {
        clienteRepository.deleteById(email);
    }
}
