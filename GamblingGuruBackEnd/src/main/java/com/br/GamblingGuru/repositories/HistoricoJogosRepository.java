package com.br.GamblingGuru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.GamblingGuru.entities.HistoricoJogos;

@Repository
public interface HistoricoJogosRepository extends JpaRepository<HistoricoJogos, Integer>{

    
}