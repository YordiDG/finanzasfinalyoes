package org.mininimarketyoesbackend.service;

import org.mininimarketyoesbackend.model.Disponibilidad;

import java.util.List;

public interface DisponibilidadService {
    List<Disponibilidad> obtenerTodasLasDisponibilidades();
    Disponibilidad obtenerDisponibilidadPorId(Long id);
    Disponibilidad agregarDisponibilidad(Disponibilidad disponibilidad);
    Disponibilidad actualizarDisponibilidad(Long id, Disponibilidad disponibilidadActualizada);
    void eliminarDisponibilidad(Long id);
}

