package org.mininimarketyoesbackend.user.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mininimarketyoesbackend.user.domain.service.UserService;
import org.mininimarketyoesbackend.user.mapping.UserMapper;
import org.mininimarketyoesbackend.user.resource.CreateUserResource;
import org.mininimarketyoesbackend.user.resource.UserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Create and read users")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;


    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable){
        return mapper.modelListPage(userService.getAll(), pageable);
    }

    @Operation(summary = "Get all users")
    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable Long userId){
        return mapper.toResource(userService.getById(userId));
    }

    @Operation(summary = "Create user", responses = {
            @ApiResponse(description = "User successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class)))
    })
    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        return new ResponseEntity<>(mapper.toResource(userService.create(resource)), HttpStatus.CREATED);
    }

    @Operation(summary = "Get user by email and password")
    @GetMapping("/login")
    public UserResource getUserByEmailAndPassword(@RequestParam String email, @RequestParam String password){
        return mapper.toResource(userService.getByEmailAndPassword(email, password));
    }
}
