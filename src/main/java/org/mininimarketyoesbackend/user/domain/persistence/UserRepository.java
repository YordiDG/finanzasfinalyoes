package org.mininimarketyoesbackend.user.domain.persistence;

import org.mininimarketyoesbackend.user.domain.model.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserLog, Long> {
    UserLog findByEmail(String email);
    UserLog findByEmailAndPassword(String email, String password);
}
