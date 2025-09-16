package edu.vinu.TournamentDrawPlatform.service.impl;

import edu.vinu.TournamentDrawPlatform.entity.OrganizerEntity;
import edu.vinu.TournamentDrawPlatform.entity.TournamentEntity;
import edu.vinu.TournamentDrawPlatform.model.Team;
import edu.vinu.TournamentDrawPlatform.model.Tournament;
import edu.vinu.TournamentDrawPlatform.repository.TournamentRepository;
import edu.vinu.TournamentDrawPlatform.requests.TournamentCreateRequest;
import edu.vinu.TournamentDrawPlatform.service.TournamentService;
import edu.vinu.TournamentDrawPlatform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {

    private final ModelMapper mapper;
    private final TournamentRepository tournamentRepository;
    private final UserService userService;

    @Override
    public Tournament createTournament(Long organizerId, TournamentCreateRequest request) {
        TournamentEntity entity= mapper.map(request, TournamentEntity.class);
        entity.setOrganizer(mapper.map(userService.getOrganizerById(organizerId), OrganizerEntity.class));
        TournamentEntity savedEntity = tournamentRepository.save(entity);
        return mapper.map(savedEntity, Tournament.class);
    }

    @Override
    public List<Tournament> getAllTournamentsByOrganizer(Long organizerId) {
        return tournamentRepository.findAllByOrganizer_Id(organizerId)
                .stream()
                .map(tournamentEntity -> mapper.map(tournamentEntity, Tournament.class))
                .toList();
    }

    @Override
    public List<Tournament> getAllOpenTournaments() {
        return tournamentRepository.findAllByRegistrationDeadlineAfter(java.time.LocalDateTime.now())
                .stream()
                .map(entity -> mapper.map(entity, Tournament.class))
                .toList();
    }
}
