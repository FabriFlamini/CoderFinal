package com.example.Trabajo.Repository;


import com.example.Trabajo.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}