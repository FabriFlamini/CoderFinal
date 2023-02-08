package com.example.Trabajo.Service;


import com.example.Trabajo.Repository.ProductoRepository;
import com.example.Trabajo.Entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.UnableToRegisterMBeanException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * @param producto
     * @return
     * @throws Exception
     */
    public Producto guardar(Producto producto) throws Exception {

  if (producto.getCantidad() == null || producto.getCantidad() == 0) {
                    throw new Exception("Debe ingresar una cantidad valida");
                }
  if (producto.getCodigo() == null || producto.getCodigo() == 0) {
      throw new Exception("Error en el sistema");
  }

  if (producto.getDescripcion() == null || producto.getDescripcion().isEmpty()) {
   throw new Exception("Ingresar una descripcion valida");
  }
  if (producto.getPrecio() == null || producto.getPrecio() == 0) {
      throw new Exception("Ingresar un precio valido");
  }
            {
                return productoRepository.save(producto);
            }
        }
    public Optional<Producto> buscarPorId(Integer id){
        return productoRepository.findById(id);
    }
}
