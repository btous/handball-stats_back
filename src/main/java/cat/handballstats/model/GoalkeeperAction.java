package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Table(name="goalkeeper_action")
@JsonTypeName("goalkeeperAction")
public class GoalkeeperAction extends Action {
    
    @Column(nullable = false)
    private GoalkeeperActionType type;
    
    public GoalkeeperAction(GoalkeeperActionType type, Instant time, GamePhase gamePhase) {
    	super(ActionType.recoveredBall, time, gamePhase);
    	this.type = type;
    }

	public GoalkeeperActionType getType() {
		return type;
	}

	public void setType(GoalkeeperActionType type) {
		this.type = type;
	}
}