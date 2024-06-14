package org.mininimarketyoesbackend.profile.service;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.mininimarketyoesbackend.profile.domain.model.Profile;
import org.mininimarketyoesbackend.profile.domain.persistence.ProfileRepository;
import org.mininimarketyoesbackend.profile.domain.service.ProfileService;
import org.mininimarketyoesbackend.profile.mapping.ProfileMapper;
import org.mininimarketyoesbackend.profile.resource.CreateProfileResource;
import org.mininimarketyoesbackend.shared.exception.ResourceNotFoundException;
import org.mininimarketyoesbackend.shared.exception.ResourceValidationException;
import org.mininimarketyoesbackend.user.domain.service.UserService;
import org.mininimarketyoesbackend.user.resource.CreateUserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class ProfileServiceImpl implements ProfileService {
    private static final String ENTITY = "Profile";

    private final ProfileRepository profileRepository;

    private final ProfileMapper mapper;

    private final UserService userService;

    private final Validator validator;

    public ProfileServiceImpl(ProfileRepository profileRepository, UserService userService, Validator validator, ProfileMapper mapper) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
        this.userService = userService;
        this.validator = validator;
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Page<Profile> getAll(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }

    @Override
    public Profile getById(Long profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, profileId));
    }

    @Override
    public Profile create(CreateProfileResource resource) {
        Set<ConstraintViolation<CreateProfileResource>> violations = validator.validate(resource);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        //validation of brand and model

        Profile existingProfile = profileRepository.findByDni(resource.getDni());

        if (existingProfile != null)
            throw new ResourceValidationException(ENTITY, "This profile alredy exists");
        
        Profile newProfile = profileRepository.save(mapper.toModel(resource));

        userService.create(new CreateUserResource(resource.getEmail(), resource.getPassword(), newProfile.getId()));

        return newProfile;
    }
}
