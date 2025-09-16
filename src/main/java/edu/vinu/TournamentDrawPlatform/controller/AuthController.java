package edu.vinu.TournamentDrawPlatform.controller;

import edu.vinu.TournamentDrawPlatform.enums.Roles;
import edu.vinu.TournamentDrawPlatform.model.Users;
import edu.vinu.TournamentDrawPlatform.requests.ClanRegistrationRequest;
import edu.vinu.TournamentDrawPlatform.requests.OrganizerRegistrationRequest;
import edu.vinu.TournamentDrawPlatform.requests.UserLoginRequest;
import edu.vinu.TournamentDrawPlatform.response.ApiResponse;
import edu.vinu.TournamentDrawPlatform.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/organizer")
    public ResponseEntity<ApiResponse> registerOrganizer(@Valid @RequestBody OrganizerRegistrationRequest request){
        Users user = authService.registerOrganizer(request);
        return ResponseEntity.ok(new ApiResponse("Organizer registered successfully", user));
    }

    @PostMapping("/register/clan")
    public ResponseEntity<ApiResponse> registerClan(@Valid @RequestBody ClanRegistrationRequest request){
        Users user = authService.registerClan(request);
        return ResponseEntity.ok(new ApiResponse("Clan registered successfully", user));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody UserLoginRequest loginRequest){
        Users user = authService.login(loginRequest);
        return ResponseEntity.ok(new ApiResponse("Login successful", user));
    }
}
