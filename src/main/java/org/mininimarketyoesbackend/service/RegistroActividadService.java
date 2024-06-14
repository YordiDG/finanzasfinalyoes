package org.mininimarketyoesbackend.service;

import org.mininimarketyoesbackend.model.RegistroActividad;

import java.util.List;

public interface RegistroActividadService {
    List<RegistroActividad> obtenerTodosLosRegistros();
    RegistroActividad obtenerRegistroPorId(Long id);
    RegistroActividad agregarRegistro(RegistroActividad registroActividad);
    RegistroActividad actualizarRegistro(Long id, RegistroActividad registroActividadActualizado);
    void eliminarRegistro(Long id);
}
