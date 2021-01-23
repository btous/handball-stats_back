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

import cat.handballstats.model.Player;
import cat.handballstats.service.PlayerService;

@RestController
public class PlayerController {
    
	private final PlayerService service;
	private Gson gson = new Gson();
	
	PlayerController(PlayerService service) {
		this.service = service;
	}
	
	// Get club players
	@GetMapping("/clubs/{club_id}/players")
	public List<Player> getClubPlayers(@PathVariable Long club_id) {
		return service.getClubPlayers(club_id);
	}
	
	// Get team players
	@GetMapping("/teams/{teamId}/players")
	public List<Player> getTeamPlayers(@PathVariable Long teamId) {
		return service.getTeamPlayers(teamId);
	}
	
	// Get match players
	@GetMapping("/matches/{matchId}/players")
	public List<Player> getMatchPlayers(@PathVariable Long matchId) {
		return service.getPlayersByMatchId(matchId);
	}
	
	// Get player
	@GetMapping("/players/{id}")
	public Player getPlayer(@PathVariable Long id) {
		return service.getPlayer(id);
	}
	
	// Add player
	@PostMapping("/players/new_player")
	public Player addPlayer(@RequestBody Player newPlayer) {
		return service.addPlayer(newPlayer);
	}
	
	// Update player
	@PutMapping("/players/{id}")
	public Player updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
		return service.updatedPlayer(id, updatedPlayer);
	}
	
	// Delete player
	@DeleteMapping("/players/{id}")
	public String deletePlayer(@PathVariable Long id) {
		service.deletePlayer(id);
		return gson.toJson("Player deleted");
	}
	
	// Delete players
	@DeleteMapping("/players")
	public String deletePlayers(@RequestBody List<Long> idsList) {
		service.deletePlayers(idsList);
		return gson.toJson("Players deleted");
	}
}
