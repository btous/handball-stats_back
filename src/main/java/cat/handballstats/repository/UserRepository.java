package cat.handballstats.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.handballstats.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);
    
}