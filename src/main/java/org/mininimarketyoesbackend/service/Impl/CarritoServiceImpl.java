package org.mininimarketyoesbackend.service.Impl;

import org.mininimarketyoesbackend.model.CarritoItem;
import org.mininimarketyoesbackend.repository.CarritoRepository;
import org.mininimarketyoesbackend.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public List<CarritoItem> obtenerTodosLosItems() {
        return carritoRepository.findAll();
    }

    @Override
    public CarritoItem obtenerItemPorId(Long id) {
        return carritoRepository.findById(id).orElse(null);
    }

    @Override
    public CarritoItem agregarItem(CarritoItem item) {
        return carritoRepository.save(item);
    }

    @Override
    public CarritoItem actualizarItem(Long id, CarritoItem itemActualizado) {
        CarritoItem item = carritoRepository.findById(id).orElse(null);
        if (item != null) {
            item.setProducto(itemActualizado.getProducto());
            item.setCantidad(itemActualizado.getCantidad());

            return carritoRepository.save(item);
        }
        return null;
    }

    @Override
    public void eliminarItem(Long id) {
        carritoRepository.deleteById(id);
    }
}

