package org.mininimarketyoesbackend.profile.resource;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResource {
    private String name;
    private String motherLastName;
    private String fatherLastName;
    private String job;
    private BigDecimal salary;
    private String dni;
}
