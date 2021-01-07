package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@Table(name="save")
@JsonTypeName("save")
public class Save extends Action {
    
	@Column(nullable = false)
    private Boolean successful;
    @Column
    private ShotPosition shotPosition;
    @Column
    private ShotDirection shotDirection;
    
    public Save() {
    	
    }
    
    public Save(Boolean successful, Instant time, GamePhase gamePhase) {
    	super(ActionType.shot, time, gamePhase);
    	this.successful = successful;
    }

	public Boolean getSuccessful() {
		return successful;
	}

	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}

	public ShotPosition getShotPosition() {
		return shotPosition;
	}

	public void setShotPosition(ShotPosition shotPosition) {
		this.shotPosition = shotPosition;
	}

	public ShotDirection getShotDirection() {
		return shotDirection;
	}

	public void setShotDirection(ShotDirection shotDirection) {
		this.shotDirection = shotDirection;
	}
}
