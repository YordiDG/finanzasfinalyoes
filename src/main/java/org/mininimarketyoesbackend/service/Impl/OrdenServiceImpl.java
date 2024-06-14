package org.mininimarketyoesbackend.service.Impl;

import org.mininimarketyoesbackend.model.Orden;
import org.mininimarketyoesbackend.repository.OrdenRepository;
import org.mininimarketyoesbackend.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public List<Orden> obtenerTodasLasOrdenes() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden obtenerOrdenPorId(Long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public Orden agregarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public Orden actualizarOrden(Long id, Orden ordenActualizada) {
        Orden orden = ordenRepository.findById(id).orElse(null);
        if (orden != null) {
            orden.setItems(ordenActualizada.getItems());
            orden.setTotalCompra(ordenActualizada.getTotalCompra());
            orden.setDireccionEnvio(ordenActualizada.getDireccionEnvio());
            return ordenRepository.save(orden);
        }
        return null;
    }

    @Override
    public void eliminarOrden(Long id) {
        ordenRepository.deleteById(id);
    }
}

