package com.br.GamblingGuru.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.GamblingGuru.entities.Cliente;
import com.br.GamblingGuru.service.GamblingService;

@RestController
@RequestMapping(value = "/guru")
@CrossOrigin
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

    @GetMapping( value = "/leaderboard")
    public List<Cliente> leaderboard(){
        List<Cliente> clientes = gamblingService.leaderboard();
        return clientes;
    }

    @GetMapping(value = "/validarlogin/{email}/{senha}")
    public ResponseEntity<Cliente> validarLogin(@PathVariable String email, @PathVariable String senha ){
        Cliente cliente = gamblingService.validarLogin(email,senha);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente){
        if(gamblingService.findById(cliente.getEmail()) == null){
            cliente = gamblingService.cadastrarCliente(cliente);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}").buildAndExpand(cliente.getEmail()).toUri();
            return ResponseEntity.created(uri).body(cliente);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping(value = "/{email}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable String email, @RequestBody Cliente cliente){
        Cliente alterado = gamblingService.atualizarCliente(email,cliente);
        return ResponseEntity.ok().body(alterado);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deletar(@PathVariable String email){
        gamblingService.deletar(email);
        return ResponseEntity.noContent().build();
    }
}
