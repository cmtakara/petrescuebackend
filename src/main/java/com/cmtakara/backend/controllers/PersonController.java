package com.cmtakara.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmtakara.backend.exceptions.ResourceNotFoundException;
import com.cmtakara.backend.models.Person;
import com.cmtakara.backend.repositories.PeopleRepository;

@RestController
@CrossOrigin
@RequestMapping("api/v1/people/")
public class PersonController {
	
	@Autowired
	private PeopleRepository personRepo;
	
	@GetMapping("/allpeople")
	public List<Person> getAllPeople() {
		return personRepo.findAll();
	}
	
	@GetMapping("/individualperson/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable int id) {
		Person person = personRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found."));
		return ResponseEntity.ok(person);
	}	
	
	@GetMapping("/allvolunteers")
	public List<Person> getVolunteers() {
		List<Person> people = personRepo.findByVolunteerstatus("APPROVED");
		if(people.isEmpty()) {
			System.out.println(new ResourceNotFoundException("No approved volunteers"));
		}
		return personRepo.findByVolunteerstatus("APPROVED");
	}
	
	@GetMapping("/allfosters")
	public List<Person> getFosters() {
		List<Person> people = personRepo.findByFosterstatus("APPROVED");
		if(people.isEmpty()) {
			System.out.println(new ResourceNotFoundException("No approved fosters"));
		}
		return personRepo.findByFosterstatus("APPROVED");
	}
	
	@GetMapping("/adoptersbystatus/{adopterstatus}")
	public List<Person> getByAdoptionStatus(@PathVariable String adopterstatus) {
		List<Person> people = personRepo.findByAdopterstatus(adopterstatus);
		if(people.isEmpty()) {
			System.out.println(new ResourceNotFoundException("No adopters with status of " + adopterstatus));
		}
		return personRepo.findByAdopterstatus(adopterstatus);
	}

}
