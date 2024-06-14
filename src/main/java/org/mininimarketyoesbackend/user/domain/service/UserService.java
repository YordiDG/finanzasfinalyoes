package org.mininimarketyoesbackend.user.domain.service;


import org.mininimarketyoesbackend.user.domain.model.UserLog;
import org.mininimarketyoesbackend.user.resource.CreateUserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<UserLog> getAll();
    Page<UserLog> getAll(Pageable pageable);

    UserLog getById(Long userId);
    UserLog create(CreateUserResource resource);
    UserLog getByEmailAndPassword(String email, String password);
}
