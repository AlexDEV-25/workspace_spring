package hunre.it.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hunre.it.restapi.model.User;
import jakarta.annotation.PostConstruct;

@RestController
public class UserController {
	private List<User> users = new ArrayList<User>();

	@PostConstruct
	public void initData() {
		users.add(new User(1, "Nguyen Van A", "toan", 10));
		users.add(new User(2, "Tran Thi B", "van", 10));
		users.add(new User(3, "Le Van C", "anh", 10));
	}

	@PostMapping("/user")
	public User create(@RequestBody User user) {
		users.add(user);
		return user;
	}

	@GetMapping("/users")
	public List<User> getAll() {
		return users;
	}

	@DeleteMapping("/user")
	public void delete(@RequestParam(name = "masv") int masv) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getMasv() == masv) {
				users.remove(i);
				break;
			}
		}
	}

	@PutMapping("/user")
	public void update(@RequestBody User user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getMasv() == user.getMasv()) {
				users.set(i, user);
				break;
			}
		}
	}

}
