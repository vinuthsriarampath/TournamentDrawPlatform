package edu.vinu.TournamentDrawPlatform.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.vinu.TournamentDrawPlatform.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Pattern(regexp = ".{8,}", message = "Password must be at least 8 characters long")
    private String password;
}
