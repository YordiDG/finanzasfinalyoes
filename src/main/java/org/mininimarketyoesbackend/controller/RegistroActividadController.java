package org.mininimarketyoesbackend.controller;

import org.mininimarketyoesbackend.model.RegistroActividad;
import org.mininimarketyoesbackend.service.RegistroActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minimarket/registros-actividad")
public class RegistroActividadController {

    @Autowired
    private RegistroActividadService registroActividadService;

    @GetMapping("/todos")
    public List<RegistroActividad> obtenerTodosLosRegistros() {
        return registroActividadService.obtenerTodosLosRegistros();
    }

    @GetMapping("/{id}")
    public RegistroActividad obtenerRegistroPorId(@PathVariable Long id) {
        return registroActividadService.obtenerRegistroPorId(id);
    }

    @PostMapping("/nuevo")
    public RegistroActividad agregarRegistro(@RequestBody RegistroActividad registroActividad) {
        return registroActividadService.agregarRegistro(registroActividad);
    }

    @PutMapping("/{id}/actualizar")
    public RegistroActividad actualizarRegistro(@PathVariable Long id, @RequestBody RegistroActividad registroActividadActualizado) {
        return registroActividadService.actualizarRegistro(id, registroActividadActualizado);
    }

    @DeleteMapping("/{id}/eliminar")
    public void eliminarRegistro(@PathVariable Long id) {
        registroActividadService.eliminarRegistro(id);
    }
}

