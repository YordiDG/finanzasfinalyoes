package org.mininimarketyoesbackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterWithPhoneNumberRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
