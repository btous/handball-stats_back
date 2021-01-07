package cat.handballstats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.handballstats.model.Save;

public interface SaveRepository extends JpaRepository<Save, Long> {

	List<Save> findByMatchId(Long matchId);

	List<Save> findByMatchIdAndPlayerId(Long matchId, Long playerId);

	List<Save> findByPlayerId(Long playerId);
}