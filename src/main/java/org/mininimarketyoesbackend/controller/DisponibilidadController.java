package org.mininimarketyoesbackend.controller;

import org.mininimarketyoesbackend.model.Disponibilidad;
import org.mininimarketyoesbackend.service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minimarket/disponibilidad")
public class DisponibilidadController {

    @Autowired
    private DisponibilidadService disponibilidadService;

    @GetMapping("/todas")
    public List<Disponibilidad> obtenerTodasLasDisponibilidades() {
        return disponibilidadService.obtenerTodasLasDisponibilidades();
    }

    @GetMapping("/{id}")
    public Disponibilidad obtenerDisponibilidadPorId(@PathVariable Long id) {
        return disponibilidadService.obtenerDisponibilidadPorId(id);
    }

    @PostMapping("/nueva")
    public Disponibilidad agregarDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
        return disponibilidadService.agregarDisponibilidad(disponibilidad);
    }

    @PutMapping("/{id}/actualizar")
    public Disponibilidad actualizarDisponibilidad(@PathVariable Long id, @RequestBody Disponibilidad disponibilidadActualizada) {
        return disponibilidadService.actualizarDisponibilidad(id, disponibilidadActualizada);
    }

    @DeleteMapping("/{id}/eliminar")
    public void eliminarDisponibilidad(@PathVariable Long id) {
        disponibilidadService.eliminarDisponibilidad(id);
    }
}

