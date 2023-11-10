package com.br.GamblingGuru.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.GamblingGuru.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

    Optional<Cliente> findByEmail(String email);

    
}
