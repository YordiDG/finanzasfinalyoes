package org.mininimarketyoesbackend.service.Impl;

import org.mininimarketyoesbackend.model.Producto;
import org.mininimarketyoesbackend.repository.IProducto;
import org.mininimarketyoesbackend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private IProducto productoRepository;

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            // Actualiza solo los campos que se proporcionan en productoActualizado
            if (productoActualizado.getName() != null) {
                producto.setName(productoActualizado.getName());
            }
            if (productoActualizado.getDescription() != null) {
                producto.setDescription(productoActualizado.getDescription());
            }
            if (productoActualizado.getImage() != null) {
                producto.setImage(productoActualizado.getImage());
            }
            if (productoActualizado.getCategory() != null) {
                producto.setCategory(productoActualizado.getCategory());
            }
            if (productoActualizado.getDisponibilidad() != null) {
                producto.setDisponibilidad(productoActualizado.getDisponibilidad());
            }
            if (productoActualizado.getCantidad_stock() != 0) {
                producto.setCantidad_stock(productoActualizado.getCantidad_stock());
            }
            if (productoActualizado.getValoracion() != null) {
                producto.setValoracion(productoActualizado.getValoracion());
            }
            return productoRepository.save(producto);
        }
        return null;
    }


    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
