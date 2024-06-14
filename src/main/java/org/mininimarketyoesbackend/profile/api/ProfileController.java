package org.mininimarketyoesbackend.profile.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mininimarketyoesbackend.profile.domain.service.ProfileService;
import org.mininimarketyoesbackend.profile.mapping.ProfileMapper;
import org.mininimarketyoesbackend.profile.resource.CreateProfileResource;
import org.mininimarketyoesbackend.profile.resource.ProfileResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/profiles")
@Tag(name = "Profiles", description = "Create and read profiles")
public class ProfileController {
    private final ProfileService profileService;
    private final ProfileMapper mapper;

    public ProfileController(ProfileService profileService, ProfileMapper mapper) {
        this.profileService = profileService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ProfileResource> getAllProfiles(Pageable pageable){
        return mapper.modelListPage(profileService.getAll(), pageable);
    }

    @Operation(summary = "Get all profiles")
    @GetMapping("{profileId}")
    public ProfileResource getProfileById(@PathVariable Long profileId){
        return mapper.toResource(profileService.getById(profileId));
    }

    @Operation(summary = "Create profile", responses = {
            @ApiResponse(description = "Profile successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfileResource.class)))
    })
    @PostMapping
    public ResponseEntity<ProfileResource> createStudent(@RequestBody CreateProfileResource resource) {
        return new ResponseEntity<>(mapper.toResource(profileService.create(resource)), HttpStatus.CREATED);
    }

}
