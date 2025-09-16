package edu.vinu.TournamentDrawPlatform.service.impl;

import edu.vinu.TournamentDrawPlatform.entity.UsersEntity;
import edu.vinu.TournamentDrawPlatform.enums.Roles;
import edu.vinu.TournamentDrawPlatform.exceptions.custom.NotFoundException;
import edu.vinu.TournamentDrawPlatform.model.Clan;
import edu.vinu.TournamentDrawPlatform.model.Organizer;
import edu.vinu.TournamentDrawPlatform.model.Users;
import edu.vinu.TournamentDrawPlatform.repository.UserRepository;
import edu.vinu.TournamentDrawPlatform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public boolean isUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public Users getUserByEmail(String email) {
        UsersEntity usersEntity = userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("User not found with email: " + email)
        );
        return mapper.map(usersEntity, Users.class);
    }

    @Override
    public Clan getClanById(Long clanId) {
        UsersEntity usersEntity = userRepository.findById(clanId).orElseThrow(
                () -> new NotFoundException("User not found with id: " + clanId)
        );
        if (Roles.CLAN.equals(usersEntity.getRole())) {
            return mapper.map(usersEntity, Clan.class);
        }
        throw new NotFoundException("User with id: " + clanId + " is not a Clan");
    }

    @Override
    public Organizer getOrganizerById(Long organizerId) {
        UsersEntity usersEntity = userRepository.findById(organizerId).orElseThrow(
                () -> new NotFoundException("User not found with id: " + organizerId)
        );
        if (Roles.ORGANIZER.equals(usersEntity.getRole())) {
            return mapper.map(usersEntity, Organizer.class);
        }
        throw new NotFoundException("User with id: " + organizerId + " is not a Organizer");
    }
}
