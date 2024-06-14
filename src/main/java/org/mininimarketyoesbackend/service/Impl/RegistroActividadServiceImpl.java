package org.mininimarketyoesbackend.service.Impl;

import org.mininimarketyoesbackend.model.RegistroActividad;
import org.mininimarketyoesbackend.repository.RegistroActividadRepository;
import org.mininimarketyoesbackend.service.RegistroActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroActividadServiceImpl implements RegistroActividadService {

    @Autowired
    private RegistroActividadRepository registroActividadRepository;

    @Override
    public List<RegistroActividad> obtenerTodosLosRegistros() {
        return registroActividadRepository.findAll();
    }

    @Override
    public RegistroActividad obtenerRegistroPorId(Long id) {
        return registroActividadRepository.findById(id).orElse(null);
    }

    @Override
    public RegistroActividad agregarRegistro(RegistroActividad registroActividad) {
        return registroActividadRepository.save(registroActividad);
    }

    @Override
    public RegistroActividad actualizarRegistro(Long id, RegistroActividad registroActividadActualizado) {
        RegistroActividad registroActividad = registroActividadRepository.findById(id).orElse(null);
        if (registroActividad != null) {
            registroActividad.setEvento(registroActividadActualizado.getEvento());
            registroActividad.setDescripcion(registroActividadActualizado.getDescripcion());
            registroActividad.setFechaHora(registroActividadActualizado.getFechaHora());
            // Actualizar otros atributos según sea necesario
            return registroActividadRepository.save(registroActividad);
        }
        return null;
    }

    @Override
    public void eliminarRegistro(Long id) {
        registroActividadRepository.deleteById(id);
    }
}

