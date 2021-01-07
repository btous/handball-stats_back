package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Table(name="timeout")
@JsonTypeName("timeout")
public class Timeout extends Action {
    
    @Column(nullable = false)
    private TeamOpponent requestingTeam;
    
    public Timeout(TeamOpponent requestingTeam, Instant time, GamePhase gamePhase) {
    	super(ActionType.missedBall, time, gamePhase);
    	this.requestingTeam = requestingTeam;
    }

	public TeamOpponent getRequestingTeam() {
		return requestingTeam;
	}

	public void setRequestingTeam(TeamOpponent requestingTeam) {
		this.requestingTeam = requestingTeam;
	}
}