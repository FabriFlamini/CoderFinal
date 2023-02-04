package com.example.Trabajo.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "productoid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer producto;
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "descripcion")
    private Integer descripcion;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Integer precio;
    public Producto(){

    }

    public Integer getProducto() {
        return this.producto;
    }

    public void setProducto(Integer productoid) {
        this.producto = productoid;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCodigo() {
        {codigo = (int) (Math.random() * 1000);}
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion()
    {
        ArrayList palabras = new ArrayList();
        palabras.add("Mesa redonda");
        palabras.add("Cepillo de dientes");
        palabras.add("Secador");
        palabras.add("Pala");
        palabras.add("Monitor");
        palabras.add("Silla");
        palabras.add("Pelota");
        palabras.add("Mouse");
        palabras.add("Teclado");
        palabras.add("Sillon");
        palabras.add("Televisor");
        palabras.add("Microfono");
        palabras.add("Impresora");
        palabras.add("Armario");
        palabras.add("Puerta");


        descripcion = (int) (Math.random() *14);

        return " " +palabras.get(descripcion);
    }


    public void setDescripcion(Integer descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        {
            precio = (int) (Math.random() * 100000 + 1000);
        }
        {
            return this.precio;
        }
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}