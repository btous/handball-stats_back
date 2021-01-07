package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="result")
public class Result {
    
	@Id
    @Column(name = "match_id")
    private Long id;
	@Column
	private int teamScore;
	@Column
	private int opponentScore;
	@Column
	private Instant startTime;
	@Column
	private Instant actualTime;
	@Column
	private int periodTeamTimeoutsLeft;
	@Column
	private int totalTeamTimeoutsLeft;
	@Column
	private int periodOpponentTimeoutsLeft;
	@Column
	private int totalOpponentTimeoutsLeft;
	
	//Foreign keys
	@OneToOne
    @MapsId
    @JoinColumn(name = "match_id")
	@JsonIgnore
	private Match match;
	
	public Result() {
        
	}

	public Result(int teamScore, int opponentScore,
			int periodTeamTimeoutsLeft, int totalTeamTimeoutsLeft,
			int periodOpponentTimeoutsLeft, int totalOpponentTimeoutsLeft) {
		this.teamScore = teamScore;
		this.opponentScore= opponentScore;
		this.totalTeamTimeoutsLeft = totalTeamTimeoutsLeft;
		this.periodTeamTimeoutsLeft = periodTeamTimeoutsLeft;
		this.totalOpponentTimeoutsLeft = totalOpponentTimeoutsLeft;
		this.periodOpponentTimeoutsLeft = periodOpponentTimeoutsLeft;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}

	public int getOpponentScore() {
		return opponentScore;
	}

	public void setOpponentScore(int opponentScore) {
		this.opponentScore = opponentScore;
	}

	public Instant getStartTime() {
		return startTime;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}

	public Instant getActualTime() {
		return actualTime;
	}

	public void setActualTime(Instant actualTime) {
		this.actualTime = actualTime;
	}

	public int getTotalTeamTimeoutsLeft() {
		return totalTeamTimeoutsLeft;
	}

	public void setTotalTeamTimeoutsLeft(int teamTimeoutsLeft) {
		this.totalTeamTimeoutsLeft = teamTimeoutsLeft;
	}

	public int getPeriodTeamTimeoutsLeft() {
		return periodTeamTimeoutsLeft;
	}

	public void setPeriodTeamTimeoutsLeft(int periodTeamTimeoutsLeft) {
		this.periodTeamTimeoutsLeft = periodTeamTimeoutsLeft;
	}

	public int getTotalOpponentTimeoutsLeft() {
		return totalOpponentTimeoutsLeft;
	}

	public void setTotalOpponentTimeoutsLeft(int opponentTimeoutsLeft) {
		this.totalOpponentTimeoutsLeft = opponentTimeoutsLeft;
	}

	public int getPeriodOpponentTimeoutsLeft() {
		return periodOpponentTimeoutsLeft;
	}

	public void setPeriodOpponentTimeoutsLeft(int periodOpponentTimeoutsLeft) {
		this.periodOpponentTimeoutsLeft = periodOpponentTimeoutsLeft;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
	
}
