package com.example.getstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
@RequestMapping("/api/users")
public class GetStartedApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetStartedApplication.class, args);
	}

	//	@GetMapping("/hello")
	//	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
	//		return String.format("Hello %s!", name);
	//	}
	
	private List<String> users = new ArrayList<>();

	@GetMapping
	public List<String> getAllUsers() {
		return users;
	}

	@PostMapping
	public String createUser(@RequestBody String user) {
		users.add(user);
		return "User created: " + user;
	}

	@DeleteMapping("/{user}")
	public String deleteUser(@PathVariable String user) {
		if(users.contains(user)) {
			users.remove(user);
			return "User deleted: " + user;
		}
		return "User not found";
	}
}
