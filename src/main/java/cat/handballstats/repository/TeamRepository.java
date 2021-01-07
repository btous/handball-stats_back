package cat.handballstats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.handballstats.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	
	List<Team> findByClubId(Long club_id);

	List<Team> findByPlayersId(Long playerId);
}
