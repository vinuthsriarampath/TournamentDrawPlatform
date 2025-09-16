package edu.vinu.TournamentDrawPlatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_member")
public class TeamMemberEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
