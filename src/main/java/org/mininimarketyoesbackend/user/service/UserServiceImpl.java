package org.mininimarketyoesbackend.user.service;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import org.mininimarketyoesbackend.shared.exception.ResourceNotFoundException;
import org.mininimarketyoesbackend.shared.exception.ResourceValidationException;
import org.mininimarketyoesbackend.user.domain.model.UserLog;
import org.mininimarketyoesbackend.user.domain.persistence.UserRepository;
import org.mininimarketyoesbackend.user.domain.service.UserService;
import org.mininimarketyoesbackend.user.mapping.UserMapper;
import org.mininimarketyoesbackend.user.resource.CreateUserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY = "User";

    private final UserRepository userRepository;

    private final UserMapper mapper;

    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper, Validator validator) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public List<UserLog> getAll() {
        return userRepository.findAll();
    }


    @Override
    public Page<UserLog> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UserLog getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public UserLog create(CreateUserResource resource) {
        Set<ConstraintViolation<CreateUserResource>> violations = validator.validate(resource);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        //validation of brand and model

        UserLog existingUser = userRepository.findByEmail(resource.getEmail());

        if (existingUser != null)
            throw new ResourceValidationException(ENTITY, "A user with this email already exists");

        return userRepository.save(mapper.toModel(resource));
    }
    @Override
    public UserLog getByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
