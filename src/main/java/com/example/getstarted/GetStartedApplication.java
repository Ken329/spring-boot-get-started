package com.example.getstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class GetStartedApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetStartedApplication.class, args);
	}

	//	@GetMapping("/hello")
	//	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
	//		return String.format("Hello %s!", name);
	//	}
	
	final private List<String> users = new ArrayList<>();

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	@GetMapping
	public List<String> getAllUsers() {
		return users;
	}

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public String createUser(@RequestBody Map<String, String> user) {
		System.out.println(user.get("name"));
		users.add(user.get("name"));
		return "User created: " + user.get("name");
	}

	@RequestMapping(path = "/user/{username}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable String username) {
		if(users.contains(username)) {
			users.remove(username);
			return "User deleted: " + username;
		}
		return "User not found";
	}
}
