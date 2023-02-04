package com.example.Trabajo.Service;


import com.example.Trabajo.Controller.ClienteController;
import com.example.Trabajo.Repository.ClienteRepository;
import com.example.Trabajo.Entities.Cliente;
import org.apache.logging.log4j.message.Message;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Va a registrar al cliente a un id
     * @param
     * @return
     * @throws Exception
     */
    public Cliente guardar(Cliente cliente) throws Exception {
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new Exception("El nombre es obligatorio");
        }
        if (cliente.getApellido() == null || cliente.getApellido().isEmpty()) {
            throw new Exception("El apellido es obligatorio");
        }
        if (cliente.getDni() == null || cliente.getDni() == 0) {
            throw new Exception("El DNI es obligatorio");
        }

        return clienteRepository.save(cliente);
    }

        public Optional<Cliente> buscarPorId(Long id){
            return clienteRepository.findById(id);
        }

}
