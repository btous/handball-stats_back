package cat.handballstats.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cat.handballstats.model.Team;
import cat.handballstats.repository.TeamRepository;

@Service
public class TeamService {
	
	private final TeamRepository repository;
	
	
	TeamService(TeamRepository repository) {
		this.repository = repository;
	}
    
	// Get club teams
	public List<Team> getClubTeams(Long clubId) {
		return repository.findByClubId(clubId);
	}

	// Get player teams
	public List<Team> getPlayerTeams(Long playerId) {
		return repository.findByPlayersId(playerId);
	}
    
	// Get team
	public Team getTeam(Long id) {
		return repository.findById(id).orElse(null);
	}
    
	// Add team
	public Team addTeam(Team newTeam) {
		return repository.save(newTeam);
	}
    
	// Update team
	public Team updateTeam(Long id, Team updatedTeam) {
		return repository.findById(id).map(team -> {
			team.setName(updatedTeam.getName());
			team.setCategory(updatedTeam.getCategory());
			team.setCategoryLabel(updatedTeam.getCategoryLabel());
			team.setLeague(updatedTeam.getLeague());
			team.setGender(updatedTeam.getGender());
			return repository.save(team);
		}).orElse(null);
	}
    
	// Delete team
	public void deleteTeam(Long id) {
		repository.deleteById(id);
	}
	
	// Delete teams
	public void deleteTeams(List<Long> idsList) {
		for(int i = 0; i < idsList.size(); i++) {
			this.deleteTeam(idsList.get(i));
		}
	}
}
