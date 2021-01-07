package cat.handballstats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.handballstats.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findByTeamId(Long teamId);
//	List<Player> findByTeamsId(Long id);
	
	List<Player> findByMatchesId(Long matchId);

}
