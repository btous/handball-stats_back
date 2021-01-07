package cat.handballstats.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cat.handballstats.repository.ClubRepository;
import cat.handballstats.repository.UserRepository;

@Configuration
public class LoadDataBase {
    
	@Bean
	CommandLineRunner initDataBase(UserRepository user_repository, ClubRepository club_repository) {
		return args -> {
//			User user = new User("Berni", "12345", "berni@mail.com");
//			Club club = new Club("Club Handbol Sant Cugat", "Handbol Sant Cugat");
//			user = user_repository.save(user);
//			user.getClubs().add(club);
//			club.setUser(user);
//			user_repository.save(user);
		};
	}
}