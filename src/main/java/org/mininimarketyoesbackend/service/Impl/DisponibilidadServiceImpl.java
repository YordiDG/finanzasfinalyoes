package org.mininimarketyoesbackend.service.Impl;

import org.mininimarketyoesbackend.model.Disponibilidad;
import org.mininimarketyoesbackend.repository.DisponibilidadRepository;
import org.mininimarketyoesbackend.service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadServiceImpl implements DisponibilidadService {

    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    @Override
    public List<Disponibilidad> obtenerTodasLasDisponibilidades() {
        return disponibilidadRepository.findAll();
    }

    @Override
    public Disponibilidad obtenerDisponibilidadPorId(Long id) {
        return disponibilidadRepository.findById(id).orElse(null);
    }

    @Override
    public Disponibilidad agregarDisponibilidad(Disponibilidad disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

    @Override
    public Disponibilidad actualizarDisponibilidad(Long id, Disponibilidad disponibilidadActualizada) {
        Disponibilidad disponibilidad = disponibilidadRepository.findById(id).orElse(null);
        if (disponibilidad != null) {
            disponibilidad.setDisponible(disponibilidadActualizada.isDisponible());
            // Actualizar otros atributos según sea necesario
            return disponibilidadRepository.save(disponibilidad);
        }
        return null;
    }

    @Override
    public void eliminarDisponibilidad(Long id) {
        disponibilidadRepository.deleteById(id);
    }
}

