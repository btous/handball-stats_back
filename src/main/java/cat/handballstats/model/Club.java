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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="club")
public class Club {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column
	private String teamsName;
	@OneToMany(mappedBy="club", cascade = CascadeType.ALL)
	@Column
	@JsonManagedReference(value="club-team")
	private List<Team> teams = new ArrayList<Team>();
	
	//Foreign keys
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Club() {
		
	};
	
	public Club(String name, String teamsName) {
        
		this.name = name;
		this.teamsName = teamsName;
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
	public String getTeamsName() {
		return teamsName;
	}
	public void setTeamsName(String teamsName) {
		this.teamsName = teamsName;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
    public void setUser(User user) {
		this.user = user;
	}

	public void addTeam(Team team) {
    	teams.add(team);
    	team.setClub(this);
    }
    
    public void removeTeam(Team team) {
    	teams.remove(team);
    	team.setClub(null);
    }
}
