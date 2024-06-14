package org.mininimarketyoesbackend.user.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UserResource {
    private Long id;
    private String email;
    private String password;
}
