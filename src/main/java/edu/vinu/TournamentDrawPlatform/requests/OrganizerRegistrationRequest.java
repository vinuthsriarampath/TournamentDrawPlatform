package edu.vinu.TournamentDrawPlatform.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerRegistrationRequest extends UserRegistrationRequest{
    @NotBlank(message = "Organization name cannot be blank")
    private String organizationName;
}
