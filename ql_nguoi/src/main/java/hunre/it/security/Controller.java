package hunre.it.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	List<Person> persons = new ArrayList<Person>();

	public Controller() {
		Person p1 = new Person(1, "duc");
		Person p2 = new Person(2, "dat");
		persons.add(p1);
		persons.add(p2);
	}

	@GetMapping("/persons")
	public Iterable<Person> getPersions() {
		return this.persons;
	}

	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person entity) {
		// TODO: process POST request
		persons.add(entity);
		return entity;
	}

}
