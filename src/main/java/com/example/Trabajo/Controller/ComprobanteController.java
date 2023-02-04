package com.example.Trabajo.Controller;



import com.example.Trabajo.Entities.Comprobante;
import com.example.Trabajo.Service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crear(@RequestBody Comprobante comprobante){
        try{
            Comprobante comprobanteCreado = comprobanteService.guardar(comprobante);
            return ResponseEntity.created(URI.create("")).body(comprobanteCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }

    }



}
