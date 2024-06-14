package org.mininimarketyoesbackend.controller;

import org.mininimarketyoesbackend.model.Valoracion;
import org.mininimarketyoesbackend.service.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minimarket/valoraciones")
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;

    @GetMapping("/all-valoracion")
    public List<Valoracion> obtenerTodasLasValoraciones() {
        return valoracionService.obtenerTodasLasValoraciones();
    }

    @GetMapping("/{id}")
    public Valoracion obtenerValoracionPorId(@PathVariable Long id) {
        return valoracionService.obtenerValoracionPorId(id);
    }

    @PostMapping("/new-valoracion")
    public Valoracion agregarValoracion(@RequestBody Valoracion valoracion) {
        return valoracionService.agregarValoracion(valoracion);
    }

    @PutMapping("/{id}/new-update")
    public Valoracion actualizarValoracion(@PathVariable Long id, @RequestBody Valoracion valoracionActualizada) {
        return valoracionService.actualizarValoracion(id, valoracionActualizada);
    }

    @DeleteMapping("/{id}/new-delete")
    public void eliminarValoracion(@PathVariable Long id) {
        valoracionService.eliminarValoracion(id);
    }
}

