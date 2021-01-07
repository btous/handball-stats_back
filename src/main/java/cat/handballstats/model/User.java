package cat.handballstats.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id @GeneratedValue(generator = "UUID")
    private UUID id;
	@Column(unique = true, nullable = false)
    private String username;
	@Column(nullable = false)
    private String password;
	@Column(unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Club> clubs;
    
    public User() {
    	
    }
    
	public User(String username, String password, String email) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.clubs = new ArrayList<Club>();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}
}
