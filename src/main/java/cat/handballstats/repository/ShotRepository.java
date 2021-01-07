package cat.handballstats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.handballstats.model.Shot;

public interface ShotRepository extends JpaRepository<Shot, Long> {

	List<Shot> findByMatchId(Long matchId);

	List<Shot> findByMatchIdAndPlayerId(Long matchId, Long playerId);

	List<Shot> findByPlayerId(Long playerId);
}