package org.mininimarketyoesbackend.repository;

import org.mininimarketyoesbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);

    boolean existsByPhoneNumber(String phoneNumber);
}

