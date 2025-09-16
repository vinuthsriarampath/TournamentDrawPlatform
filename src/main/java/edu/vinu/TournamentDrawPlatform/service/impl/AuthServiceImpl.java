package edu.vinu.TournamentDrawPlatform.service.impl;

import edu.vinu.TournamentDrawPlatform.entity.ClanEntity;
import edu.vinu.TournamentDrawPlatform.entity.OrganizerEntity;
import edu.vinu.TournamentDrawPlatform.entity.UsersEntity;
import edu.vinu.TournamentDrawPlatform.enums.Roles;
import edu.vinu.TournamentDrawPlatform.model.Clan;
import edu.vinu.TournamentDrawPlatform.model.Organizer;
import edu.vinu.TournamentDrawPlatform.model.Users;
import edu.vinu.TournamentDrawPlatform.repository.UserRepository;
import edu.vinu.TournamentDrawPlatform.requests.ClanRegistrationRequest;
import edu.vinu.TournamentDrawPlatform.requests.OrganizerRegistrationRequest;
import edu.vinu.TournamentDrawPlatform.requests.UserLoginRequest;
import edu.vinu.TournamentDrawPlatform.service.AuthService;
import edu.vinu.TournamentDrawPlatform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMapper mapper;

    @Override
    public Users registerOrganizer(OrganizerRegistrationRequest request) {
        if(userService.isUserExist(request.getEmail())){
            throw new IllegalArgumentException("User with email " + request.getEmail() + " already exists.");
        } else {
            UsersEntity usersEntity = mapper.map(request, OrganizerEntity.class);
            usersEntity.setRole(Roles.ORGANIZER);

            UsersEntity savedEntity = userRepository.save(usersEntity);
            return mapper.map(savedEntity, Organizer.class);
        }
    }

    @Override
    public Users registerClan(ClanRegistrationRequest request) {
        if(userService.isUserExist(request.getEmail())){
            throw new IllegalArgumentException("User with email " + request.getEmail() + " already exists.");
        } else {
            UsersEntity usersEntity = mapper.map(request, ClanEntity.class);
            usersEntity.setRole(Roles.CLAN);

            UsersEntity savedEntity = userRepository.save(usersEntity);
            return mapper.map(savedEntity, Clan.class);
        }
    }

    @Override
    public Users login(UserLoginRequest loginRequest) {
        Users user = userService.getUserByEmail(loginRequest.getEmail());
        if (user.getPassword().trim().equals(loginRequest.getPassword().trim())) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid email or password");
        }
    }
}
