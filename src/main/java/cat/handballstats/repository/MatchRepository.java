package cat.handballstats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.handballstats.model.Match;
import cat.handballstats.model.MatchState;

public interface MatchRepository extends JpaRepository<Match, Long> {

	List<Match> findAllByTeamId(Long teamId);

	List<Match> findAllByTeamIdAndMatchState(Long teamId, MatchState matchState);
	
}
