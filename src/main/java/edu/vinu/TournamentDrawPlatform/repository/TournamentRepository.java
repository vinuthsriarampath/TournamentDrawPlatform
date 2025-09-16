package edu.vinu.TournamentDrawPlatform.repository;

import edu.vinu.TournamentDrawPlatform.entity.TournamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<TournamentEntity,Long> {
    List<TournamentEntity> findAllByOrganizer_Id(Long organizerId);

    List<TournamentEntity> findAllByRegistrationDeadlineAfter(LocalDateTime now);
}
