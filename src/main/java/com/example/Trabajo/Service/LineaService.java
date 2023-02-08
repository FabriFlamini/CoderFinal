package com.example.Trabajo.Service;


import com.example.Trabajo.Entities.Cliente;
import com.example.Trabajo.Entities.Linea;
import com.example.Trabajo.Repository.ClienteRepository;
import com.example.Trabajo.Repository.LineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LineaService {

    @Autowired
    private LineaRepository lineaRepository;

    /**
     * @param linea
     * @return
     * @throws
     */
    public Linea guardar(Linea linea) throws Exception {
        if (linea.getDescripcion() == null || linea.getDescripcion().isEmpty()) {
            throw new Exception("Hay que poner una descripcion");
        }
        if (linea.getCantidad() == null || linea.getCantidad() == 0)
        {
            throw new Exception("Error en el sistema");
        }
        if (linea.getPrecio() == null || linea.getPrecio() == 0) {
            throw new Exception("El precio es invalido");
        }
        return lineaRepository.save(linea);
    }
}
