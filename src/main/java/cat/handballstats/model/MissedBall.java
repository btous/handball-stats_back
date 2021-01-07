package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Table(name="missed_ball")
@JsonTypeName("missedBall")
public class MissedBall extends Action {
    
    @Column(nullable = false)
    private MissedBallType type;
    
    public MissedBall(MissedBallType type, Instant time, GamePhase gamePhase) {
    	super(ActionType.missedBall, time, gamePhase);
    	this.type = type;
    }

	public MissedBallType getType() {
		return type;
	}

	public void setType(MissedBallType type) {
		this.type = type;
	}
}