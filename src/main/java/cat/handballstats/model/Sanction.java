package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Table(name="sanction")
@JsonTypeName("sanction")
public class Sanction extends Action {
    
    @Column(nullable = false)
    private SanctionType type;
    @Column(nullable = false)
    private TeamOpponent teamAffected;
    
    public Sanction(TeamOpponent teamAffected, Instant time, GamePhase gamePhase) {
    	super(ActionType.missedBall, time, gamePhase);
    	this.teamAffected = teamAffected;
    }

	public TeamOpponent getType() {
		return teamAffected;
	}

	public void setType(SanctionType type) {
		this.type = type;
	}

	public TeamOpponent getTeamAffected() {
		return teamAffected;
	}

	public void setTeamAffected(TeamOpponent teamAffected) {
		this.teamAffected = teamAffected;
	}
}