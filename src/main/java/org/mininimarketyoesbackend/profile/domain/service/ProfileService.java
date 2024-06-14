package org.mininimarketyoesbackend.profile.domain.service;

import org.mininimarketyoesbackend.profile.domain.model.Profile;
import org.mininimarketyoesbackend.profile.resource.CreateProfileResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfileService {
    List<Profile> getAll();
    Page<Profile> getAll(Pageable pageable);

    Profile getById(Long id);
    Profile create(CreateProfileResource resource);
}
