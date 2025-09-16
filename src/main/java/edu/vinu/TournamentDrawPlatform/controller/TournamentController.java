package edu.vinu.TournamentDrawPlatform.controller;

import edu.vinu.TournamentDrawPlatform.model.Tournament;
import edu.vinu.TournamentDrawPlatform.requests.TournamentCreateRequest;
import edu.vinu.TournamentDrawPlatform.response.ApiResponse;
import edu.vinu.TournamentDrawPlatform.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    @PostMapping("{organizerId}/create")
    public ResponseEntity<ApiResponse> createTournament(@PathVariable Long organizerId, @RequestBody TournamentCreateRequest request){
        Tournament tournament = tournamentService.createTournament(organizerId,request);
        return ResponseEntity.ok(new ApiResponse("Tournament created successfully", tournament));
    }

    @GetMapping("{organizerId}/all")
    public ResponseEntity<ApiResponse> getAllTournamentsByOrganizer(@PathVariable Long organizerId){
        List<Tournament> tournaments = tournamentService.getAllTournamentsByOrganizer(organizerId);
        return ResponseEntity.ok(new ApiResponse("Tournaments fetched successfully",tournaments));
    }

    @GetMapping("/open/all")
    public ResponseEntity<ApiResponse> getAllOpenTournaments(){
        List<Tournament> tournaments = tournamentService.getAllOpenTournaments();
        return ResponseEntity.ok(new ApiResponse("Open Tournaments fetched successfully",tournaments));
    }
}
