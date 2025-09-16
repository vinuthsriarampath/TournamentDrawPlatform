package edu.vinu.TournamentDrawPlatform.service;

import edu.vinu.TournamentDrawPlatform.model.Team;
import edu.vinu.TournamentDrawPlatform.requests.TeamCreateRequest;

import java.util.List;

public interface TeamService {
    Team createTeam(Long clanId, TeamCreateRequest request);

    Team getTeamByName(String name);

    List<Team> getAllTeamsByClan(Long clanId);
}
