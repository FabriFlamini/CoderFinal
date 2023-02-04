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
        if (linea.getComprobante() == null) ;
        {
            throw new Exception("Error en el sistema");
        }
    }
}
