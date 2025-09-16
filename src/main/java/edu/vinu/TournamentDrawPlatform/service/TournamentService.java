package edu.vinu.TournamentDrawPlatform.service;

import edu.vinu.TournamentDrawPlatform.model.Tournament;
import edu.vinu.TournamentDrawPlatform.requests.TournamentCreateRequest;

import java.util.List;

public interface TournamentService {
    Tournament createTournament(Long organizerId, TournamentCreateRequest request);

    List<Tournament> getAllTournamentsByOrganizer(Long organizerId);

    List<Tournament> getAllOpenTournaments();
}
