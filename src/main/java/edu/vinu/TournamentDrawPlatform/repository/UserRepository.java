package edu.vinu.TournamentDrawPlatform.repository;

import edu.vinu.TournamentDrawPlatform.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersEntity,Long> {
    Optional<UsersEntity> findByEmail(String username);

}
