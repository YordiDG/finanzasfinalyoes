package org.mininimarketyoesbackend.user.mapping;

import org.mininimarketyoesbackend.profile.domain.model.Profile;
import org.mininimarketyoesbackend.profile.domain.persistence.ProfileRepository;
import org.mininimarketyoesbackend.shared.mapping.EnhancedModelMapper;
import org.mininimarketyoesbackend.user.domain.model.UserLog;
import org.mininimarketyoesbackend.user.resource.CreateUserResource;
import org.mininimarketyoesbackend.user.resource.UpdateUserResource;
import org.mininimarketyoesbackend.user.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    @Autowired
    private ProfileRepository profileRepository;

    public UserResource toResource(UserLog model) {
        return mapper.map(model, UserResource.class);
    }

    public UserLog toModel(CreateUserResource resource) {
        UserLog user = mapper.map(resource, UserLog.class);
        if (user != null && resource.getProfileId() != null) {
            Profile profile = profileRepository.findById(resource.getProfileId()).orElse(null);
            if (profile != null) {
                user.setProfile(profile);
            } else {
                // Manejar el caso en el que no se encuentre el perfil correspondiente
                // Puedes lanzar una excepción, asignar un valor predeterminado, etc.
            }
        }
        return user;
    }

    public UserLog toModel(UpdateUserResource resource) {
        return mapper.map(resource, UserLog.class);
    }

    public Page<UserResource> modelListPage(List<UserLog> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }
}
