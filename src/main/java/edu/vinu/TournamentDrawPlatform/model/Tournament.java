package edu.vinu.TournamentDrawPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tournament {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime registrationDeadline;
    private LocalDateTime tournamentDate;

}
