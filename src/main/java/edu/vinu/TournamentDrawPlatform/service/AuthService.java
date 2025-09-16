package edu.vinu.TournamentDrawPlatform.service;

import edu.vinu.TournamentDrawPlatform.model.Users;
import edu.vinu.TournamentDrawPlatform.requests.ClanRegistrationRequest;
import edu.vinu.TournamentDrawPlatform.requests.OrganizerRegistrationRequest;
import edu.vinu.TournamentDrawPlatform.requests.UserLoginRequest;

public interface AuthService {

    Users registerOrganizer(OrganizerRegistrationRequest request);

    Users registerClan( ClanRegistrationRequest request);

    Users login(UserLoginRequest loginRequest);
}
