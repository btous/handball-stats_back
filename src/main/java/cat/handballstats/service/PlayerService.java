package cat.handballstats.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cat.handballstats.model.Player;
import cat.handballstats.model.Shot;
import cat.handballstats.model.Team;
import cat.handballstats.repository.PlayerRepository;

@Service
public class PlayerService {

	private final PlayerRepository repository;
	private final TeamService team_service;

	PlayerService(PlayerRepository repository, TeamService team_service) {
		this.repository = repository;
		this.team_service = team_service;
	}

	// Get club players
	public List<Player> getClubPlayers(Long club_id) {
		List<Team> teams = team_service.getClubTeams(club_id);
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < teams.size(); i++) {
				players.addAll(teams.get(i).getPlayers());
		}
		return players;
	}

	// Get team players
	public List<Player> getTeamPlayers(Long teamId) {
		return repository.findByTeamId(teamId);
	}
	
	// Get match players
	public List<Player> getPlayersByMatchId(Long matchId) {
		return repository.findByMatchesId(matchId);
	}

	// Get player
	public Player getPlayer(Long id) {
		return repository.findById(id).orElse(null);
	}

	// Add player
	public Player addPlayer(Player newPlayer) {
		return repository.save(newPlayer);
	}

	// Update player
	public Player updatedPlayer(Long id, Player updatedPlayer) {
		return repository.findById(id).map(player -> {
			player.setName(updatedPlayer.getName());
			player.setSurname(updatedPlayer.getSurname());
			player.setNumber(updatedPlayer.getNumber());
			player.setPosition(updatedPlayer.getPosition());
			player.setBirthday(updatedPlayer.getBirthday());
			player.setGender(updatedPlayer.getGender());
			player.setTeam(updatedPlayer.getTeam());
			return repository.save(player);
		}).orElse(null);
	}

	// Delete player
	public void deletePlayer(Long id) {
		repository.deleteById(id);
	}
	
	// Delete players
	public void deletePlayers(List<Long> idsList) {
		for(int i = 0; i < idsList.size(); i++) {
			this.deletePlayer(idsList.get(i));
		}
	}

	// Add shot
	public void addShot(Long id, Shot shot) {
		Player player = repository.findById(id).orElse(null);
		player.getActions().add(shot);
		repository.save(player);
	}
}
