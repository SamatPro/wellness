package com.sera.wellness.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistrationForm {
    private String firstName;
    private String lastName;
    private String sex;
    private String email;
    private String password;
    private String repeatPassword;
    private boolean consentToTheProcessingOfPersonalData;
    private boolean consentToReceiveEmails;
}
