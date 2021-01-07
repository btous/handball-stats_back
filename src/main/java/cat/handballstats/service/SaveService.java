package cat.handballstats.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cat.handballstats.model.Action;
import cat.handballstats.model.Save;
import cat.handballstats.repository.SaveRepository;

@Service
public class SaveService {
    
	private final SaveRepository repository;
	
	public SaveService(SaveRepository repository) {
		this.repository = repository;
	}
	
	// Get save
	public Save getSave(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	// Get match saves
	public List<Save> getMatchSaves(Long matchId) {
		return repository.findByMatchId(matchId);
	}
	
	// Get match saves by player
	public List<Save> getMatchSavesByPlayer(Long matchId, Long playerId) {
		return repository.findByMatchIdAndPlayerId(matchId, playerId);
	}
	
	// Get player saves
	public List<Save> getPlayerSaves(Long playerId) {
		return repository.findByPlayerId(playerId);
	}
	
	// Add save
	public Action addSave(Save newSave) {
		return repository.save(newSave);
	}
}
