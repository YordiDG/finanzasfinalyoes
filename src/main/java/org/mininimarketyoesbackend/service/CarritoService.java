package org.mininimarketyoesbackend.service;

import org.mininimarketyoesbackend.model.CarritoItem;
import java.util.List;

public interface CarritoService {
    List<CarritoItem> obtenerTodosLosItems();
    CarritoItem obtenerItemPorId(Long id);
    CarritoItem agregarItem(CarritoItem item);
    CarritoItem actualizarItem(Long id, CarritoItem itemActualizado);
    void eliminarItem(Long id);
}

