package org.learning.notes.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private String name;

    private String username;

    @Email
    private String email;

    private String password;

    private String confirmPassword;
}
