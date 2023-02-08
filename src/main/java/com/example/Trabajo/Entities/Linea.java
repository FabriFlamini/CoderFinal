package com.example.Trabajo.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

@Entity
@Table(name = "linea")
public class Linea {
    @Id
    @Column(name = "idlinea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineaid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "productoid", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "idcomprobante", nullable = false)
    private Comprobante comprobante;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Integer precio;


    public String getDescripcion()  {

        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        {
            cantidad = (int) (Math.random() * 300);
        }
        {
            return cantidad;
        }
    }

    public void setCantidad(Integer cantidad) {{cantidad = (int) (Math.random() * 100);} {
        this.cantidad = cantidad;
    }}

    public Integer getPrecio() {
        {
            Random r = new Random();
        precio = (int) (r.nextDouble() * 1000);
    }

    {
        return precio;
    }

}

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Long getLineaid() {
        return lineaid;
    }

    public void setLineaid(Long lineaid) {
        this.lineaid = lineaid;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }
    public Producto getProducto() {
        {System.out.println();}
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}