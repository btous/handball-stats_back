package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Table(name="defensive_action")
@JsonTypeName("defensiveAction")
public class DefensiveAction extends Action {
    
    @Column(nullable = false)
    private DefensiveActionType type;
    
    public DefensiveAction(DefensiveActionType type, Instant time, GamePhase gamePhase) {
    	super(ActionType.recoveredBall, time, gamePhase);
    	this.type = type;
    }

	public DefensiveActionType getType() {
		return type;
	}

	public void setType(DefensiveActionType type) {
		this.type = type;
	}
}