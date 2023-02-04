package com.example.Trabajo.Controller;


import com.example.Trabajo.Entities.Producto;
import com.example.Trabajo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crear(@RequestBody Producto producto){
        try{
            Producto productoCreado = productoService.guardar(producto);
            return ResponseEntity.created(URI.create("")).body(productoCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }

    }



}
