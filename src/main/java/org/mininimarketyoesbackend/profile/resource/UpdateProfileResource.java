package org.mininimarketyoesbackend.profile.resource;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProfileResource {
    private Long Id;

    @NotNull
    private String name;

    @NotNull
    private String motherLastName;

    @NotNull
    private String fatherLastName;

    @NotNull
    private String job;

    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    @Digits(integer = 9, fraction = 2)
    private BigDecimal salary;

    @NotNull
    @NotBlank
    private String dni;
}
