package org.mininimarketyoesbackend.service;

import org.mininimarketyoesbackend.model.Producto;


import java.util.List;

public interface ProductoService {
    List<Producto> obtenerTodosLosProductos();
    Producto obtenerProductoPorId(Long id);
    Producto agregarProducto(Producto producto);
    Producto actualizarProducto(Long id, Producto productoActualizado);
    void eliminarProducto(Long id);


}

