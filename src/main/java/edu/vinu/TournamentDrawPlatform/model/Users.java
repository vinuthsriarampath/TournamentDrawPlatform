package edu.vinu.TournamentDrawPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.vinu.TournamentDrawPlatform.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private Roles role;
}
