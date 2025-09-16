package edu.vinu.TournamentDrawPlatform.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamCreateRequest {
    @NotBlank(message = "Team name cannot be blank")
    private String teamName;
}
