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

import cat.handballstats.model.Team;
import cat.handballstats.service.TeamService;

@RestController
public class TeamController {

	private final TeamService service;
	private Gson gson = new Gson();

	TeamController(TeamService service) {
		this.service = service;
	}

	// Get club teams
	@GetMapping("/clubs/{clubId}/teams")
	public List<Team> getTeams(@PathVariable Long clubId) {
		return service.getClubTeams(clubId);
	}
	
	// Get player teams
	@GetMapping("/players/{playerId}/teams")
	public List<Team> getPlayerTeams(@PathVariable Long playerId) {
		return service.getPlayerTeams(playerId);
	}

	// Get team
	@GetMapping("/teams/{id}")
	public Team getTeam(@PathVariable Long id) {
		return service.getTeam(id);
	}

	// Add team
	@PostMapping("/teams/new_team")
	public Team addTeam(@RequestBody Team newTeam) {
		return service.addTeam(newTeam);
	}

	// Update team
	@PutMapping("/teams/{id}")
	public Team updateTeam(@PathVariable Long id, @RequestBody Team updatedTeam) {
		return service.updateTeam(id, updatedTeam);
	}

	// Delete team
	@DeleteMapping("/teams/{id}")
	public String deleteTeam(@PathVariable Long id) {
		service.deleteTeam(id);
		return gson.toJson("Team deleted");
	}
	
	// Delete teams
	@DeleteMapping("/teams/")
	public String deleteTeams(@RequestBody List<Long> idsList) {
		service.deleteTeams(idsList);
		return gson.toJson("Teams deleted");
	}
}
