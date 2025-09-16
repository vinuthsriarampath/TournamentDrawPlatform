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
public class ClanRegistrationRequest extends UserRegistrationRequest {
    @NotBlank(message = "Clan name is required")
    private String clanName;
}
