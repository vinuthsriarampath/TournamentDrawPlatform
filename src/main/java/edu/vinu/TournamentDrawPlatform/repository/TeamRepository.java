package edu.vinu.TournamentDrawPlatform.repository;

import edu.vinu.TournamentDrawPlatform.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    Optional<TeamEntity> findByTeamName(String name);

    List<TeamEntity> findAllByClan_Id(Long clanId);
}
