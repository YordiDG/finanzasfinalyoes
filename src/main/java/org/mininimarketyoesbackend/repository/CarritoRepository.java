package org.mininimarketyoesbackend.repository;

import org.mininimarketyoesbackend.model.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<CarritoItem, Long> {

}

