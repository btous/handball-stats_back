package cat.handballstats.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cat.handballstats.model.Action;
import cat.handballstats.model.Shot;
import cat.handballstats.repository.ShotRepository;

@Service
public class ShotService {
    
	private final ShotRepository repository;
	
	public ShotService(ShotRepository repository) {
		this.repository = repository;
	}
	
	// Get shot
	public Shot getShot(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	// Get match shots
	public List<Shot> getMatchShots(Long matchId) {
		return repository.findByMatchId(matchId);
	}
	
	// Get match shots by player
	public List<Shot> getMatchShotsByPlayer(Long matchId, Long playerId) {
		return repository.findByMatchIdAndPlayerId(matchId, playerId);
	}
	
	// Get player shots
	public List<Shot> getPlayerShots(Long playerId) {
		return repository.findByPlayerId(playerId);
	}
	
	// Add shot
	public Action addShot(Shot newShot) {
		return repository.save(newShot);
	}
}
