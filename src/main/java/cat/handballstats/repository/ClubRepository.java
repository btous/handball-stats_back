package cat.handballstats.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.handballstats.model.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {

	List<Club> findAllByUserId(UUID userId);
    
}
