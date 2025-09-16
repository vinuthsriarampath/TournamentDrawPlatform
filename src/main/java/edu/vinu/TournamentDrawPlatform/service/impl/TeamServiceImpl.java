package edu.vinu.TournamentDrawPlatform.service.impl;

import edu.vinu.TournamentDrawPlatform.entity.ClanEntity;
import edu.vinu.TournamentDrawPlatform.entity.TeamEntity;
import edu.vinu.TournamentDrawPlatform.exceptions.custom.NotFoundException;
import edu.vinu.TournamentDrawPlatform.model.Team;
import edu.vinu.TournamentDrawPlatform.repository.TeamRepository;
import edu.vinu.TournamentDrawPlatform.requests.TeamCreateRequest;
import edu.vinu.TournamentDrawPlatform.service.TeamService;
import edu.vinu.TournamentDrawPlatform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper mapper;
    private final UserService userService;
    @Override
    public Team createTeam(Long clanId, TeamCreateRequest request) {
        if (isTeamExist(request.getTeamName())){
            throw new IllegalArgumentException("Team with name " + request.getTeamName() + " already exists.");
        } else {
            TeamEntity teamEntity = mapper.map(request, TeamEntity.class);
            teamEntity.setClan(mapper.map(userService.getClanById(clanId), ClanEntity.class));
            TeamEntity savedEntity = teamRepository.save(teamEntity);
            return mapper.map(savedEntity, Team.class);
        }
    }

    @Override
    public Team getTeamByName(String name) {
        TeamEntity teamEntity = teamRepository.findByTeamName(name).orElseThrow(() -> new NotFoundException("Team with name " + name + " not found."));
        return mapper.map(teamEntity,Team.class);
    }

    @Override
    public List<Team> getAllTeamsByClan(Long clanId) {
        return teamRepository.findAllByClan_Id(clanId)
                .stream()
                .map(teamEntity -> mapper.map(teamEntity, Team.class))
                .toList();
    }

    public Boolean isTeamExist(String name) {
        return teamRepository.findByTeamName(name).isPresent();
    }
}
