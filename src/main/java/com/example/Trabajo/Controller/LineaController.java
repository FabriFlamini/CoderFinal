package com.example.Trabajo.Controller;


import com.example.Trabajo.Entities.Linea;
import com.example.Trabajo.Service.LineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/linea")
public class LineaController {

    @Autowired
    private LineaService lineaService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crear(@RequestBody Linea linea){
        try{
            Linea clienteCreado = lineaService.guardar(linea);
            return ResponseEntity.created(URI.create("")).body(clienteCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }

    }



}
