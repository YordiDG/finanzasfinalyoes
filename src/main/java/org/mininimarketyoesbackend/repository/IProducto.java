package org.mininimarketyoesbackend.repository;

import org.mininimarketyoesbackend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducto extends JpaRepository<Producto, Long> {
}


