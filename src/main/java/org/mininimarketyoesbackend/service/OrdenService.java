package org.mininimarketyoesbackend.service;

import org.mininimarketyoesbackend.model.Orden;

import java.util.List;

public interface OrdenService {
    List<Orden> obtenerTodasLasOrdenes();
    Orden obtenerOrdenPorId(Long id);
    Orden agregarOrden(Orden orden);
    Orden actualizarOrden(Long id, Orden ordenActualizada);
    void eliminarOrden(Long id);
}

