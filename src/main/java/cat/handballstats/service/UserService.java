package cat.handballstats.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cat.handballstats.model.HandballstatsException;
import cat.handballstats.model.User;
import cat.handballstats.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;

	UserService(UserRepository repository) {
		this.repository = repository;
	}

	// Login user
	public User loginUser(String email, String password) throws Exception {
		User user = repository.findByEmail(email);
		if (user == null) {
			throw new HandballstatsException("userNotFound");
		} else if (!user.getPassword().equals(password)) {
			throw new HandballstatsException("wrongPassword");
		}
		return user;
	}

	// Get users
	public List<User> getUsers() {
		return repository.findAll();
	}

	// Get user
	public User getUser(UUID id) {
		return repository.findById(id).orElse(null);
	}

	// Add new user
	public User addUser(User user) throws Exception {
		List<User> users = this.getUsers();
		for (User u : users) {
			if (u.getUsername().equals(user.getUsername())) {
				throw new HandballstatsException("usernameNotAvailable");
			}
		}
		for (User u : users) {
			if (u.getEmail().equals(user.getEmail())) {
				throw new HandballstatsException("emailNotAvailable");
			}
		}
		return repository.save(user);
	}

	// Change password
	public void updatePassword(UUID id, String password) {
		User user = repository.findById(id).orElse(null);
		user.setPassword(password);
		repository.save(user);
	}

	// Delete user
	public void deleteUser(UUID id) {
		repository.deleteById(id);
	}
}
