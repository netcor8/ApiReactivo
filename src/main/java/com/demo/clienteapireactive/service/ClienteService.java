package com.demo.clienteapireactive.service;


import com.demo.clienteapireactive.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.clienteapireactive.repository.ClienteRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    public void create(Cliente cliente){
         clienteRepository.save(cliente).subscribe();
    }

    public Flux<Cliente> findAll(){
        return clienteRepository.findAll();
    }

}
