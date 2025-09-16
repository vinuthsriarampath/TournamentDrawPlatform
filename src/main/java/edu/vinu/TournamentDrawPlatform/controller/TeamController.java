package edu.vinu.TournamentDrawPlatform.controller;

import edu.vinu.TournamentDrawPlatform.model.Team;
import edu.vinu.TournamentDrawPlatform.requests.TeamCreateRequest;
import edu.vinu.TournamentDrawPlatform.response.ApiResponse;
import edu.vinu.TournamentDrawPlatform.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/{clanId}/create")
    public ResponseEntity<ApiResponse> createTeam(@PathVariable Long clanId, @Valid @RequestBody TeamCreateRequest request) {
        Team team = teamService.createTeam(clanId, request);
        return ResponseEntity.status(201).body(new ApiResponse("Team created successfully", team));
    }

    @GetMapping("/{clanId}/all")
    public ResponseEntity<ApiResponse> allTeamsByClanId(@PathVariable Long clanId) {
        List<Team> teams = teamService.getAllTeamsByClan(clanId);
        return ResponseEntity.ok(new ApiResponse("Teams fetched successfully", teams ));
    }
}
