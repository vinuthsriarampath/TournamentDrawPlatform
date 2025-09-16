package edu.vinu.TournamentDrawPlatform.requests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentCreateRequest {
    @NotBlank(message = "Tournament name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Registration deadline is required")
    @Future(message = "Registration deadline must be in the future")
    private LocalDateTime registrationDeadline;

    @NotNull(message = "Tournament date is required")
    @Future(message = "Tournament date must be in the future")
    private LocalDateTime tournamentDate;
}
