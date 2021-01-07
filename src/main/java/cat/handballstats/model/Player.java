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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column
	private String surname;
	@Column
	private Integer number;
	@Column
	private PlayerPosition position;
	@Column
	private LocalDate birthday;
	@Column
	private PlayerGender gender;
	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
	@Column
	@JsonManagedReference(value = "player-action")
	private List<Action> actions = new ArrayList<Action>();

	// Foreign keys
	@ManyToOne
	@JoinColumn(name="team_id")
	@JsonBackReference(value="team-player")
	private Team team;
//	@ManyToMany
//	@JoinTable(name = "player_team", joinColumns = { @JoinColumn(name = "fk_player_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "fk_team_id") })
//	@Column
//	@JsonIgnore
//	private List<Team> teams = new ArrayList<Team>();

	@ManyToMany
	@JoinTable(name = "player_match", joinColumns = { @JoinColumn(name = "fk_player_id") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_match_id") })
	@Column
	@JsonIgnore
	private List<Match> matches = new ArrayList<Match>();

	Player() {

	}

	Player(String name, String surname, Integer number, PlayerPosition position, LocalDate birthday, PlayerGender gender) {

		this.name = name;
		this.surname = surname;
		this.number = number;
		this.position = position;
		this.birthday = birthday;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public PlayerPosition getPosition() {
		return position;
	}

	public void setPosition(PlayerPosition position) {
		this.position = position;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public PlayerGender getGender() {
		return gender;
	}

	public void setGender(PlayerGender gender) {
		this.gender = gender;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
}
