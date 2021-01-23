package cat.handballstats.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cat.handballstats.model.Club;
import cat.handballstats.service.ClubService;

@RestController
public class ClubController {

	private final ClubService service;
	private Gson gson = new Gson();

	ClubController(ClubService service) {

		this.service = service;
	}

	// Get clubs
	@GetMapping("/users/{userId}/clubs")
	public List<Club> getClubs(@PathVariable UUID userId) {
		return service.getClubs(userId);
	}

	// Get club
	@GetMapping("/clubs/{id}")
	public Club getClub(@PathVariable Long id) {
		return service.getClub(id);
	}

	// Add club
	@PostMapping("/clubs/new_club")
	public Club addClub(@RequestBody Club newClub) {
		return service.addClub(newClub);
	}

	// Update club
	@PutMapping("/clubs/{id}")
	public Club updateClub(@PathVariable Long id, @RequestBody Club updatedClub) {
		return service.updateClub(id, updatedClub);
	}
    
	// Delete club
	@DeleteMapping("/clubs/{id}")
	public String deleteClub(@PathVariable Long id) {
		service.deleteClub(id);
		return gson.toJson("Club deleted");
	}
	
	// Delete clubs
	@DeleteMapping("/clubs")
	public String deleteClubs(@RequestBody List<Long> idsList) {
		service.deleteClubs(idsList);
		return gson.toJson("Clubs deleted");
	}
}
