package cat.handballstats.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cat.handballstats.model.Match;
import cat.handballstats.service.MatchService;

@RestController
public class MatchController {

	private final MatchService service;
	private Gson gson = new Gson();
	
	public MatchController(MatchService service) {
		this.service = service;
	}
	
	// Get match
	@GetMapping("/matches/{id}")
	public Match getMatch(@PathVariable Long id) {
		return service.getMatch(id);
	}
	
	// Get matches
	@GetMapping("/teams/{teamId}/matches")
	public List<Match> getMatches(@PathVariable Long teamId) {
		return service.getMatches(teamId);
	}
	
	// Get pending matches
	@GetMapping("/teams/{teamId}/pending_matches")
	public List<Match> getPendingMatches(@PathVariable Long teamId) {
		return service.getPendingMatches(teamId);
	}
	
	// Get in progress matches
	@GetMapping("/teams/{teamId}/in_progress_matches")
	public List<Match> getInProgressMatches(@PathVariable Long teamId) {
		return service.getInProgressMatches(teamId);
	}
	
	// Get ended matches
	@GetMapping("/teams/{teamId}/ended_matches")
	public List<Match> getEndedMatches(@PathVariable Long teamId) {
		return service.getEndedMatches(teamId);
	}
	
	// Add match
	@PostMapping("/matches/new_match")
	public Match addMatch(@RequestBody Match newMatch) {
		return service.addMatch(newMatch);
	}

	// Update match
	@PutMapping("/matches/{id}")
	public Match updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
		return service.updateMatch(id, updatedMatch);
	}

	// Delete a match
	@DeleteMapping("/matches/{id}")
	public String deleteMatch(@PathVariable Long id) {
		service.deleteMatch(id);
		return gson.toJson("Match deleted");
	}
	
	// Delete matches
	@DeleteMapping("/matches")
	public String deleteMatches(@RequestBody List<Long> idsList) {
		service.deleteMatches(idsList);
		return gson.toJson("Matches deleted");
	}
	
	// Add existing player
	@PutMapping("/matches/{matchId}/add_player/{playerId}")
	public Match addExistingPlayer(@PathVariable Long matchId, @PathVariable Long playerId) {
		return service.addExistingPlayer(matchId, playerId);
	}

	// Set players
	@PutMapping("/matches/{matchId}/set_players")
	public String setMatchPlayers(@PathVariable Long matchId, @RequestBody List<Long> playersIdList) {
		service.setMatchPlayers(matchId, playersIdList);
		return gson.toJson("Players setted");
	}
}
