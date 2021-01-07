package cat.handballstats.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "action")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(name="shot", value=Shot.class),
	@JsonSubTypes.Type(name="missedBall", value=MissedBall.class),
	@JsonSubTypes.Type(name="recoveredBall", value=RecoveredBall.class),
	@JsonSubTypes.Type(name="sanction", value=Sanction.class),
	@JsonSubTypes.Type(name="timeout", value=Timeout.class),
	@JsonSubTypes.Type(name="save", value=Save.class),
	@JsonSubTypes.Type(name="goalkeeperAction", value=GoalkeeperAction.class),
	@JsonSubTypes.Type(name="offensiveAction", value=OffensiveAction.class),
	@JsonSubTypes.Type(name="defensiveAction", value=DefensiveAction.class)
})
public abstract class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private ActionType actionType;
	@Column(nullable = false)
	private Instant time;
	@Column
	private GamePhase gamePhase;

	// Foreign keys
	@ManyToOne
	@JoinColumn(name = "match_id")
	@JsonBackReference(value = "match-action")
	private Match match;
	@ManyToOne
	@JoinColumn(name = "player_id")
	@JsonBackReference(value = "player-action")
	private Player player;

	public Action() {

	}

	public Action(ActionType actionType, Instant time, GamePhase gamePhase) {
		this.actionType = actionType;
		this.time = time;
		this.gamePhase = gamePhase;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public GamePhase getGamePhase() {
		return gamePhase;
	}

	public void setGamePhase(GamePhase gamePhase) {
		this.gamePhase = gamePhase;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
}
