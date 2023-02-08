package com.example.Trabajo.Service;

import com.example.Trabajo.Entities.*;
import com.example.Trabajo.Repository.ClienteRepository;
import com.example.Trabajo.Repository.ComprobanteRepository;
import com.example.Trabajo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ComprobanteService {

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;
    private RestTemplate restTemplate;

    /**
     * @param
     * @return
     * @throws Exception
     */

    public Comprobante guardar(Comprobante comprobante) throws Exception {
        if (comprobante.getCantidad() == null || comprobante.getCantidad() == 0) {
            throw new Exception("Hay que poner la cantidad de productos");
        }
        if (comprobante.getTotal() == null || comprobante.getTotal() == 0) {
            throw new Exception("Error en el sistema");
        }
        if (comprobante.getCliente() == null ) {
            throw new Exception("Ingresar un cliente valido");
        }
                return comprobanteRepository.save(comprobante);
    }



    private Boolean existenProductos(Set<Linea> lineas) {
        for (Linea linea : lineas) {
            var productoId = linea.getProducto().getProducto();
            var opProducto = this.productoRepository.findById(productoId);
            if (opProducto.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private Boolean existeStock(Set<Linea> lineas) {
        for (Linea linea : lineas) {
            var productoid = linea.getProducto().getProducto();
            var opProducto = this.productoRepository.findById(productoid);
            if (opProducto.isEmpty()) {
                return false;
            }
            if (linea.getCantidad() < opProducto.get().getCantidad()) {
                return true;
            }
        }
        return false;
    }

    private BigDecimal calcularTotal(Set<Linea> lineas) {
        BigDecimal total = new BigDecimal("0");

        for (Linea linea : lineas) {
            total = total.add(new BigDecimal(linea.getPrecio().toString()));
        }

        return total;
    }

    private Comprobante armarComprobante(Comprobante comprobante) {
        var comprobanteAGuardar = new Comprobante();

        comprobanteAGuardar.setCliente(this.clienteRepository.findById(comprobante.getCliente().getClienteid()).get());

        WorldClock worldClock = this.restTemplate.getForObject("http://worldclockapi.com/api/json/utc/now", WorldClock.class);

        String currentDateTime = worldClock.getCurrentDateTime();

        try {
            Date date1=new SimpleDateFormat("yyyy-MM-dd'T'mm:ss'Z'").parse(currentDateTime);
            comprobanteAGuardar.setFecha(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            comprobanteAGuardar.setFecha(new Date());
        }
        return comprobanteAGuardar;
    }
    private void actualizarStock(Set<Linea> lineas) {
        for (Linea linea : lineas) {

            var cantidadVendida = linea.getCantidad();
            var producto = linea.getProducto();

            var productoDB = this.productoRepository.getById(producto.getProducto());
            var stock = productoDB.getCantidad();
            var nuevoStock = stock - cantidadVendida;
            productoDB.setCantidad(nuevoStock);

            this.productoRepository.save(productoDB);

        }

    }

}
