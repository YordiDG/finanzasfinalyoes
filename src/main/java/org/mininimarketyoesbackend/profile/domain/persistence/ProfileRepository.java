package org.mininimarketyoesbackend.profile.domain.persistence;


import org.mininimarketyoesbackend.profile.domain.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByDni(String dni);
}
