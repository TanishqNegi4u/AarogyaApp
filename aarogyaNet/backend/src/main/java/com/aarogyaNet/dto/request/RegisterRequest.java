package com.aarogyaNet.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank private String fullName;
    @Email @NotBlank private String email;
    @NotBlank private String phone;
    @NotBlank private String password;
    private String state;
    private String district;
    private String village;
    private String preferredLanguage = "hi";
}