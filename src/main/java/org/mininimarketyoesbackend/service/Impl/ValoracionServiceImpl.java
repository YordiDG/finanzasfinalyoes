package org.mininimarketyoesbackend.service.Impl;

import org.mininimarketyoesbackend.model.Valoracion;
import org.mininimarketyoesbackend.repository.ValoracionRepository;
import org.mininimarketyoesbackend.service.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionServiceImpl implements ValoracionService {

    @Autowired
    private ValoracionRepository valoracionRepository;

    @Override
    public List<Valoracion> obtenerTodasLasValoraciones() {
        return valoracionRepository.findAll();
    }

    @Override
    public Valoracion obtenerValoracionPorId(Long id) {
        return valoracionRepository.findById(id).orElse(null);
    }

    @Override
    public Valoracion agregarValoracion(Valoracion valoracion) {
        return valoracionRepository.save(valoracion);
    }

    @Override
    public Valoracion actualizarValoracion(Long id, Valoracion valoracionActualizada) {
        Valoracion valoracion = valoracionRepository.findById(id).orElse(null);
        if (valoracion != null) {
            valoracion.setProducto(valoracionActualizada.getProducto());
            valoracion.setPuntuacion(valoracionActualizada.getPuntuacion());
            valoracion.setComentario(valoracionActualizada.getComentario());
            // Actualizar otros atributos según sea necesario
            return valoracionRepository.save(valoracion);
        }
        return null;
    }

    @Override
    public void eliminarValoracion(Long id) {
        valoracionRepository.deleteById(id);
    }
}

