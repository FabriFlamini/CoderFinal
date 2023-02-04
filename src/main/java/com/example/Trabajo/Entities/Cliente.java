package com.example.Trabajo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "idcliente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente;

    @Column(name = "dni")
    private Integer dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;


    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getClienteid() {
        return cliente;
    }

    public void setClienteid(Long clienteid) {
        this.cliente = clienteid;
    }
}