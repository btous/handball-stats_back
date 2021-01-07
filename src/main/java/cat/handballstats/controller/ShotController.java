package cat.handballstats.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.handballstats.model.Action;
import cat.handballstats.model.Shot;
import cat.handballstats.service.ShotService;

@RestController
public class ShotController {
	
	private final ShotService service;
	
	public ShotController(ShotService service) {
		this.service = service;
	}
	
	// Get match shots
	@GetMapping("/matches/{matchId}/shots")
	public List<Shot> getMatchShots(@PathVariable Long matchId) {
		return service.getMatchShots(matchId);
	}
	
	// Get match shots by player
	@GetMapping("/matches/{matchId}/players/{playerId}/shots")
	public List<Shot> getMatchShotsByPlayer(@PathVariable Long matchId, @PathVariable Long playerId) {
		return service.getMatchShotsByPlayer(matchId, playerId);
	}
	
	// Get player shots
	@GetMapping("/players/{playerId}/shots")
	public List<Shot> getPlayerShots(@PathVariable Long playerId) {
		return service.getPlayerShots(playerId);
	}
	
	// Add shot
    @PostMapping("/shots/new_shot")
    public Action addShot(@RequestBody Shot newShot) {
    	return service.addShot(newShot);
    }
}
