package edu.vinu.TournamentDrawPlatform.service;

import edu.vinu.TournamentDrawPlatform.model.Clan;
import edu.vinu.TournamentDrawPlatform.model.Organizer;
import edu.vinu.TournamentDrawPlatform.model.Users;

public interface UserService {
    boolean isUserExist(String email);

    Users getUserByEmail(String email);

    Clan getClanById(Long clanId);

    Organizer getOrganizerById(Long organizerId);
}
