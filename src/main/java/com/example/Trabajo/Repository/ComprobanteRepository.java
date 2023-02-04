package com.example.Trabajo.Repository;


import com.example.Trabajo.Entities.Cliente;
import com.example.Trabajo.Entities.Comprobante;
import com.example.Trabajo.Repository.ComprobanteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {

}