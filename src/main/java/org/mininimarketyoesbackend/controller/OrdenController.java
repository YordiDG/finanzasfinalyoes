package org.mininimarketyoesbackend.controller;

import org.mininimarketyoesbackend.model.Orden;
import org.mininimarketyoesbackend.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minimarket/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping("/all-orders")
    public List<Orden> obtenerTodasLasOrdenes() {
        return ordenService.obtenerTodasLasOrdenes();
    }

    @GetMapping("/{id}")
    public Orden obtenerOrdenPorId(@PathVariable Long id) {
        return ordenService.obtenerOrdenPorId(id);
    }

    @PostMapping("/new-order")
    public Orden agregarOrden(@RequestBody Orden orden) {
        return ordenService.agregarOrden(orden);
    }

    @PutMapping("/{id}/update-order")
    public Orden actualizarOrden(@PathVariable Long id, @RequestBody Orden ordenActualizada) {
        return ordenService.actualizarOrden(id, ordenActualizada);
    }

    @DeleteMapping("/{id}/delete-order")
    public void eliminarOrden(@PathVariable Long id) {
        ordenService.eliminarOrden(id);
    }
}

