package cat.handballstats.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cat.handballstats.model.Club;
import cat.handballstats.repository.ClubRepository;

@Service
public class ClubService {

	private final ClubRepository repository;
	
	ClubService(ClubRepository repository) {
		this.repository = repository;
	}
	
	// Get clubs
	public List<Club> getClubs(UUID userId) {
		return repository.findAllByUserId(userId);
	}
    
	// Get club
	public Club getClub(Long id) {
		return repository.findById(id).orElse(null);
	}
    
	// Add club
	public Club addClub(Club newClub) {
		return repository.save(newClub);
	}
    
	// Update club
	public Club updateClub(Long id, Club updatedClub) {
		return repository.findById(id).map(club -> {
			club.setName(updatedClub.getName());
			club.setTeamsName(updatedClub.getTeamsName());
			return repository.save(club);
		}).orElse(null);
	}
    
	// Delete club
	public void deleteClub(Long id) {
		repository.deleteById(id);
	}
	
	// Delete teams
	public void deleteClubs(List<Long> idsList) {
		for(int i = 0; i < idsList.size(); i++) {
			this.deleteClub(idsList.get(i));
		}
	}
}
