package org.mininimarketyoesbackend.service;

import org.mininimarketyoesbackend.model.Valoracion;

import java.util.List;

public interface ValoracionService {
    List<Valoracion> obtenerTodasLasValoraciones();
    Valoracion obtenerValoracionPorId(Long id);
    Valoracion agregarValoracion(Valoracion valoracion);
    Valoracion actualizarValoracion(Long id, Valoracion valoracionActualizada);
    void eliminarValoracion(Long id);
}

