package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Table(name="offensive_action")
@JsonTypeName("offensiveAction")
public class OffensiveAction extends Action {
    
    @Column(nullable = false)
    private OffensiveActionType type;
    
    public OffensiveAction(OffensiveActionType type, Instant time, GamePhase gamePhase) {
    	super(ActionType.recoveredBall, time, gamePhase);
    	this.type = type;
    }

	public OffensiveActionType getType() {
		return type;
	}

	public void setType(OffensiveActionType type) {
		this.type = type;
	}
}