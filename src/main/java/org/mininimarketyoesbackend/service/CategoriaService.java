package org.mininimarketyoesbackend.service;

import org.mininimarketyoesbackend.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> obtenerTodasLasCategorias();
    Categoria obtenerCategoriaPorId(Long id);
    Categoria agregarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Long id, Categoria categoriaActualizada);
    void eliminarCategoria(Long id);
}

