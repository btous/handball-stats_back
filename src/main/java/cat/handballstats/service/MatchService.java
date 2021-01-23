package cat.handballstats.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cat.handballstats.model.Match;
import cat.handballstats.model.MatchState;
import cat.handballstats.model.Player;
import cat.handballstats.model.Shot;
import cat.handballstats.repository.MatchRepository;

@Service
public class MatchService {

	private final MatchRepository repository;
	private final PlayerService player_service;

	public MatchService(MatchRepository repository, PlayerService player_service) {
		this.repository = repository;
		this.player_service = player_service;
	}

	// Get matches
	public List<Match> getMatches(Long teamId) {
		return repository.findAllByTeamId(teamId);
	}

	// Get pending matches
	public List<Match> getPendingMatches(Long teamId) {
		return repository.findAllByTeamIdAndMatchState(teamId, MatchState.pending);
	}

	// Get in progress matches
	public List<Match> getInProgressMatches(Long teamId) {
		return repository.findAllByTeamIdAndMatchState(teamId, MatchState.inProgress);
	}

	// Get ended matches
	public List<Match> getEndedMatches(Long teamId) {
		return repository.findAllByTeamIdAndMatchState(teamId, MatchState.ended);
	}

	// Get match
	public Match getMatch(Long id) {
		return repository.findById(id).orElse(null);
	}

	// Add match
	public Match addMatch(Match newMatch) {
		Match match = new Match(newMatch.getDate(), newMatch.getOpponent(), newMatch.getHomeAway(), newMatch.getTournament(), newMatch.getPeriods(), newMatch.getPeriodsDuration(), newMatch.getPeriodTimeouts(), newMatch.getTotalTimeouts());
		match.setTeam(newMatch.getTeam());
		return repository.save(match);
	}

	// Update match
	public Match updateMatch(Long id, Match updatedMatch) {
		return repository.findById(id).map(match -> {
			match.setMatchState(updatedMatch.getMatchState());
			match.setOpponent(updatedMatch.getOpponent());
			match.setDate(updatedMatch.getDate());
			match.setHomeAway(updatedMatch.getHomeAway());
			match.setTournament(updatedMatch.getTournament());
			match.setPeriods(updatedMatch.getPeriods());
			match.setPeriodsDuration(updatedMatch.getPeriodsDuration());
			match.setTotalTimeouts(updatedMatch.getTotalTimeouts());
			match.setPeriodTimeouts(updatedMatch.getPeriodTimeouts());
			match.setResult(updatedMatch.getResult());
			return repository.save(match);
		}).orElse(null);
	}

	// Delete match
	public void deleteMatch(Long id) {
		repository.deleteById(id);
	}

	// Delete matches
	public void deleteMatches(List<Long> idsList) {
		for (int i = 0; i < idsList.size(); i++) {
			Match match = this.getMatch(idsList.get(i));
			for(int j = 0; j < match.getPlayers().size(); j++) {
				Player player = match.getPlayers().get(j);
				match.getPlayers().remove(player);
				player.getMatches().remove(match);
			}
			this.deleteMatch(match.getId());
		}
	}

	// Add shot
	public void addShot(Long id, Shot shot) {
		Match match = repository.findById(id).orElse(null);
		match.getActions().add(shot);
		repository.save(match);
	}

	// Add existing player
	public Match addExistingPlayer(Long id, Long playerId) {
		Player player = player_service.getPlayer(playerId);
		Match match = repository.findById(id).orElse(null);
		match.getPlayers().add(player);
		player.getMatches().add(match);
		return repository.save(match);
	}

	// Set players
	public void setMatchPlayers(Long id, List<Long> playersIdList) {
		Match match = this.getMatch(id);
		List<Long> actualPlayersIdList = new ArrayList<Long>();
		for(int i = 0; i < match.getPlayers().size(); i++) {
			actualPlayersIdList.add(match.getPlayers().get(i).getId());
		}
		for(int i = 0; i < playersIdList.size(); i++) {
			if(actualPlayersIdList.contains(playersIdList.get(i))) {
				actualPlayersIdList.remove(playersIdList.get(i));
			} else {
				this.addExistingPlayer(match.getId(), playersIdList.get(i));
			}
		}
		//treure jugadors que ja no hi són (els que queden a la llista)
		for(int i = 0; i < actualPlayersIdList.size(); i++) {
			Player player = player_service.getPlayer(actualPlayersIdList.get(i));
			match.getPlayers().remove(player);
			player.getMatches().remove(match);
		}
		repository.save(match);
	}
}
