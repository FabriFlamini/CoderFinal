package com.example.Trabajo.Entities;

import jakarta.persistence.*;
import org.springframework.data.repository.query.Param;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "comprobante")

public class Comprobante {

    @Id
    @Column(name = "idcomprobante", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comprobanteid;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clienteid")
    private Cliente cliente;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Float total;


    public String getFecha() {
        {
            Date fecha=new Date();
            SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");

            return formatoFecha.format(fecha);
        }
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        {cantidad = (int) (Math.random() * 100);}{
        return cantidad;
    }}

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getTotal() {
        {total = (float) (Math.random() * 100000);
        return total;
    }}

    public void setTotal(Float total) {
        this.total = total;
    }

    public Long getComprobanteid() {
        return comprobanteid;
    }

    public void setComprobanteid(Long comprobanteid) {
        this.comprobanteid = comprobanteid;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}