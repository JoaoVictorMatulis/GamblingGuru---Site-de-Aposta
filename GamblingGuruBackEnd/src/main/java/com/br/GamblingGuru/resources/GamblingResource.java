package com.br.GamblingGuru.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.GamblingGuru.entities.Cliente;
import com.br.GamblingGuru.service.GamblingService;

@CrossOrigin(origins="*",maxAge=33600)
@RestController
@RequestMapping(value = "/guru")
public class GamblingResource {

    @Autowired
    private GamblingService gamblingService;

    @GetMapping
    public List<Cliente> findAll(){
        List<Cliente> clientes = gamblingService.findAll();
        return clientes;
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<Cliente> findById(@PathVariable String email) {
        Cliente cliente = gamblingService.findById(email);
        return ResponseEntity.ok().body(cliente);
    }

}
