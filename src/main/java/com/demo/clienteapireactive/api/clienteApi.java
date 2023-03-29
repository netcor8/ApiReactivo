package com.demo.clienteapireactive.api;




import com.demo.clienteapireactive.model.Cliente;
import com.demo.clienteapireactive.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api/cliente")
public class clienteApi {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public void create(@RequestBody Cliente client) {
        clienteService.create(client);

    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Cliente> findAll(){
        return clienteService.findAll();
    }




}
