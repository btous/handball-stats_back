package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Table(name="recovered_ball")
@JsonTypeName("recoveredBall")
public class RecoveredBall extends Action {
    
    @Column(nullable = false)
    private RecoveredBallType type;
    
    public RecoveredBall(RecoveredBallType type, Instant time, GamePhase gamePhase) {
    	super(ActionType.recoveredBall, time, gamePhase);
    	this.type = type;
    }

	public RecoveredBallType getType() {
		return type;
	}

	public void setType(RecoveredBallType type) {
		this.type = type;
	}
}