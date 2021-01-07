package cat.handballstats.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="team")
public class Team {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String category;
	@Column
	private String categoryLabel;
	@Column
	private String league;
	@Column
	private TeamGender gender;
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	@Column
	@JsonManagedReference(value = "team-player")
	private List<Player> players = new ArrayList<Player>();
//	@ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL)
//	@Column
//	private List<Player> players = new ArrayList<Player>();
	@OneToMany(mappedBy="team", cascade = CascadeType.ALL)
	@Column
	private List<Match> matches = new ArrayList<Match>();

	//Foreign keys
	@ManyToOne
	@JoinColumn(name="club_id")
	@JsonBackReference(value="club-team")
	private Club club;
	
	public Team() {
		
	}
	
	public Team(String name, String category, String categoryLabel, String league, TeamGender gender) {
		
		this.name = name;
		this.category = category;
		this.categoryLabel = categoryLabel;
		this.league = league;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryLabel() {
		return categoryLabel;
	}

	public void setCategoryLabel(String categoryLabel) {
		this.categoryLabel = categoryLabel;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public TeamGender getGender() {
		return gender;
	}

	public void setGender(TeamGender gender) {
		this.gender = gender;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

}
