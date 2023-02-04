package com.example.Trabajo.Controller;


import com.example.Trabajo.Entities.Cliente;
import com.example.Trabajo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
        try {
            Cliente clienteCreado = clienteService.guardar(cliente);
            return ResponseEntity.created(URI.create("")).body(clienteCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }

    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscaPorId(@PathVariable(name = "id") Long id) {
        Optional<Cliente> posibleCliente = clienteService.buscarPorId(id);

        if (posibleCliente.isPresent()) {
            return ResponseEntity.of(posibleCliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}