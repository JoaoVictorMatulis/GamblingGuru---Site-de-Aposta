package com.br.GamblingGuru.repositories;

import java.util.Optional;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.GamblingGuru.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

    Optional<Cliente> findByEmail(String email);

    @Query("SELECT cliente FROM Cliente cliente where cliente.email = :email and cliente.senha = :senha")
    Optional<Cliente> validarLogin(@Param("email") String email, @Param("senha") String senha);
}
