package edu.vinu.TournamentDrawPlatform.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("ORGANIZER")
@Entity
public class OrganizerEntity extends UsersEntity{
    private String organizationName;

    @OneToMany(mappedBy = "organizer",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TournamentEntity> organizedTournaments;
}
