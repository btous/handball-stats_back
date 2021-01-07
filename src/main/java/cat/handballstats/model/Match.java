package cat.handballstats.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "match")
public class Match {
    
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private LocalDate date;
	@Column(nullable = false)
	private String opponent;
	@Column
	private HomeAway homeAway;
	@Column
	private String tournament;
	@Column(nullable = false)
	private int periods;
	@Column(nullable = false)
	private int periodsDuration;
	@Column
	private int periodTimeouts;
	@Column
	private int totalTimeouts;
	@Column(nullable = false)
	private MatchState matchState = MatchState.pending;
	@OneToOne(mappedBy = "match", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Result result;
	@OneToMany(mappedBy="match", cascade = CascadeType.ALL)
	@Column
	@JsonManagedReference(value="match-action")
	private List<Action> actions = new ArrayList<Action>();
	@ManyToMany(mappedBy="matches", cascade = CascadeType.ALL)
	@Column
	private List<Player> players = new ArrayList<Player>();
	
	//Foreign keys
	@ManyToOne
	@JoinColumn(name="team_id")
	@JsonBackReference
	private Team team;
	
	public Match() {
		
	}

	public Match(LocalDate date, String opponent, HomeAway homeAway, String tournament,
			int periods, int periodsDuration, int periodTimeouts, int totalTimeouts) {
		super();
		this.date = date;
		this.opponent = opponent;
		this.homeAway = homeAway;
		this.tournament = tournament;
		this.periods = periods;
		this.periodsDuration = periodsDuration;
		this.periodTimeouts = periodTimeouts;
		this.totalTimeouts = totalTimeouts;
        
		// Create result
		Result result = new Result(0, 0, periodTimeouts, totalTimeouts,
				periodTimeouts, totalTimeouts);
		this.result = result;
		result.setMatch(this);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public HomeAway getHomeAway() {
		return homeAway;
	}

	public void setHomeAway(HomeAway homeAway) {
		this.homeAway = homeAway;
	}

	public String getTournament() {
		return tournament;
	}

	public void setTournament(String tournament) {
		this.tournament = tournament;
	}

	public int getPeriods() {
		return periods;
	}

	public void setPeriods(int periods) {
		this.periods = periods;
	}

	public int getPeriodsDuration() {
		return periodsDuration;
	}

	public void setPeriodsDuration(int periodsDuration) {
		this.periodsDuration = periodsDuration;
	}

	public int getPeriodTimeouts() {
		return periodTimeouts;
	}

	public void setPeriodTimeouts(int periodTimeouts) {
		this.periodTimeouts = periodTimeouts;
	}

	public int getTotalTimeouts() {
		return totalTimeouts;
	}

	public void setTotalTimeouts(int totalTimeouts) {
		this.totalTimeouts = totalTimeouts;
	}

	public MatchState getMatchState() {
		return matchState;
	}

	public void setMatchState(MatchState matchState) {
		this.matchState = matchState;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
