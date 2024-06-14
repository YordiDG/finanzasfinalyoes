package org.mininimarketyoesbackend.repository;

import org.mininimarketyoesbackend.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {

}

