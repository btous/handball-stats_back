package cat.handballstats.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.handballstats.model.Action;
import cat.handballstats.model.Save;
import cat.handballstats.service.SaveService;

@RestController
public class SaveController {
	
	private final SaveService service;
	
	public SaveController(SaveService service) {
		this.service = service;
	}
	
	// Get match saves
	@GetMapping("/matches/{matchId}/saves")
	public List<Save> getMatchSaves(@PathVariable Long matchId) {
		return service.getMatchSaves(matchId);
	}
	
	// Get match saves by player
	@GetMapping("/matches/{matchId}/players/{playerId}/saves")
	public List<Save> getMatchSavesByPlayer(@PathVariable Long matchId, @PathVariable Long playerId) {
		return service.getMatchSavesByPlayer(matchId, playerId);
	}
	
	// Get player saves
	@GetMapping("/players/{playerId}/saves")
	public List<Save> getPlayerSaves(@PathVariable Long playerId) {
		return service.getPlayerSaves(playerId);
	}
	
	// Add save
    @PostMapping("/saves/new_save")
    public Action addSave(@RequestBody Save newSave) {
    	return service.addSave(newSave);
    }
}
