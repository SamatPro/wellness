package com.sera.wellness.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileForm {
  private Long id;
  private String firstName;
  private String lastName;
  private Boolean sex;
  private String email;
  private String password;
  private String repeatPassword;
  private boolean consentToReceiveEmails;
  private MultipartFile photo;
  private Integer age;
  private Integer growth;
  private Integer weight;
  private Integer purposeWeight;
}
