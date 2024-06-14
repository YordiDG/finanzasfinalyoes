package org.mininimarketyoesbackend.controller;

import org.mininimarketyoesbackend.model.CarritoItem;
import org.mininimarketyoesbackend.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minimarket/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/items")
    public List<CarritoItem> obtenerTodosLosItems() {
        return carritoService.obtenerTodosLosItems();
    }

    @GetMapping("/items/{id}")
    public CarritoItem obtenerItemPorId(@PathVariable Long id) {
        return carritoService.obtenerItemPorId(id);
    }

    @PostMapping("/items")
    public CarritoItem agregarItem(@RequestBody CarritoItem item) {
        return carritoService.agregarItem(item);
    }

    @PutMapping("/items/{id}")
    public CarritoItem actualizarItem(@PathVariable Long id, @RequestBody CarritoItem itemActualizado) {
        return carritoService.actualizarItem(id, itemActualizado);
    }

    @DeleteMapping("/items/{id}")
    public void eliminarItem(@PathVariable Long id) {
        carritoService.eliminarItem(id);
    }
}

