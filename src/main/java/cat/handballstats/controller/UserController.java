package cat.handballstats.controller;

import java.util.List;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cat.handballstats.model.HandballstatsException;
import cat.handballstats.model.User;
import cat.handballstats.service.UserService;

@RestController
public class UserController {

	private final UserService service;
	private Gson gson = new Gson();

	UserController(UserService service) {

		this.service = service;
	}

	// Login
	@PostMapping("users/login")
	public User loginUser(@RequestBody String userData) throws Exception {
		JSONObject obj = new JSONObject(userData);
		String email = obj.getString("email");
		String password = obj.getString("password");
		try {
			return service.loginUser(email, password);
		} catch (HandballstatsException error) {
			throw new HandballstatsException(error.getMessage());
		}
	}

	// Get users
	@GetMapping("/users")
	public List<User> getUsers() {
		return service.getUsers();
	}

	// Get user
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable UUID id) {
		return service.getUser(id);
	}

	// Add new user
	@PostMapping("/users/new_user")
	public User addUser(@RequestBody User user) throws Exception {
		try {
			User u = service.addUser(user);
			return u;
		} catch (HandballstatsException error) {
			throw new HandballstatsException(error.getMessage());
		}
	}

	// Change password
	@PutMapping("/users/update_password/{id}")
	public void updatePassword(@PathVariable UUID id, @RequestBody String password) {
		service.updatePassword(id, password);
	}

	// Delete user
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable UUID id) {
		service.deleteUser(id);
		return gson.toJson("User deleted");
	}
}
