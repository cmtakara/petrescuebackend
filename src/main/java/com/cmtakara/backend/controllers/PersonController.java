package com.cmtakara.backend.controllers;

import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("addperson")
	public Person newPerson(@RequestBody Person person) {
		return personRepo.save(person);
	}
	
	@PutMapping("person/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person newPersonInfo) {
		// Checking that the fields are not empty or null occurs here, but checking the validity of the inputs that are not empty occurs in the front end at the form
		Person foundPerson = personRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("person not found"));
		
		//checking for null or empty string passed in
		//		private String name;
		if ((newPersonInfo.getName() != null) && !(newPersonInfo.getName().isEmpty())) {
			foundPerson.setName(newPersonInfo.getName());
		}

		//		private String email;
		if ((newPersonInfo.getEmail() != null) && !(newPersonInfo.getEmail().isEmpty())) {
			foundPerson.setEmail(newPersonInfo.getEmail());
		}

		//		private String phone;
		if ((newPersonInfo.getPhone() != null) && !(newPersonInfo.getPhone().isEmpty())) {
			foundPerson.setPhone(newPersonInfo.getPhone());
		}
		
		//		private String address;
		if ((newPersonInfo.getAddress() != null) && !(newPersonInfo.getAddress().isEmpty())) {
			foundPerson.setAddress(newPersonInfo.getAddress());
		}
				
		//		private String bestcontact;
		if ((newPersonInfo.getBestcontact() != null) && !(newPersonInfo.getBestcontact().isEmpty())) {
			foundPerson.setBestcontact(newPersonInfo.getBestcontact());
		}
		
		//		private String notes;
		if ((newPersonInfo.getNotes() != null) && !(newPersonInfo.getNotes().isEmpty())) {
			foundPerson.setNotes(newPersonInfo.getNotes());
		}
		
		//		private char admin;
		// Y or N
		if ((newPersonInfo.getAdmin() != '\0') && !(newPersonInfo.getAdmin() == ' ')) {
			foundPerson.setAdmin(newPersonInfo.getAdmin());
		}
		
		//		private char updaterights;
		// Y or N
		if ((newPersonInfo.getUpdaterights() != '\0') && !(newPersonInfo.getUpdaterights() == ' ')) {
			foundPerson.setUpdaterights(newPersonInfo.getUpdaterights());
		}
		
		
		
//		private String fosterstatus;
//		private String fosteravailability;
//		private String fostercurrentanimal;
//		private String volunteerstatus;
//		private String volunteercleaning;
//		private char volunteertransport;
//		private char volunteerevents;
//		private String volunteerother;
//		private String adopterstatus;
//		private String adopteranimaltype;
//		private String adopteranimalname;
//
//		//		private String age;
//		if ((newDogInfo.getAge() != null) && !(newDogInfo.getAge().isEmpty())) {
//			foundDog.setAge(newDogInfo.getAge());
//		}
//		
//		//		private char vetting;
//		// Y or N
//		if ((newDogInfo.getVetting() != '\0') && !(newDogInfo.getVetting() == ' ')) {
//			foundDog.setVetting(newDogInfo.getVetting());
//		}
//
//		//		private String imagename;
//		if ((newDogInfo.getImagename() != null) && !(newDogInfo.getImagename().isEmpty())) {
//			foundDog.setImagename(newDogInfo.getImagename());
//		}
//		
////		//  IMAGE
//		
//		//		private String imageurl;
//		if ((newDogInfo.getImageurl() != null) && !(newDogInfo.getImageurl().isEmpty())) {
//			foundDog.setImageurl(newDogInfo.getImageurl());
//		}
//		
//		//		private char bonded;
//		// Y or N
//		if ((newDogInfo.getBonded() != '\0') && !(newDogInfo.getBonded() == ' ')) {
//			foundDog.setBonded(newDogInfo.getBonded());
//		}
//		
//		//		private String foster;
//		if ((newDogInfo.getFoster() != null) && !(newDogInfo.getFoster().isEmpty())) {
//			foundDog.setFoster(newDogInfo.getFoster());
//		}
//		
//		//		private String location;
//		if ((newDogInfo.getLocation() != null) && !(newDogInfo.getLocation().isEmpty())) {
//			foundDog.setLocation(newDogInfo.getLocation());
//		}
//		
//		//		private char chip;
//		// Y or N
//		if ((newDogInfo.getChip() != '\0') && !(newDogInfo.getChip() == ' ')) {
//			foundDog.setChip(newDogInfo.getChip());
//		}
//
//		//		private String spayneuter;
//		// YES, NO, TOO YOUNG, UNKNOWN
//		if ((newDogInfo.getSpayneuter() != null) && !(newDogInfo.getSpayneuter().isEmpty())) {
//			foundDog.setSpayneuter(newDogInfo.getSpayneuter());
//		}
//		
//		//		private String issues;
//		if ((newDogInfo.getIssues() != null) && !(newDogInfo.getIssues().isEmpty())) {
//			foundDog.setIssues(newDogInfo.getIssues());
//		}
//		
//		//		private String other;
//		// cats, dogs, children
//		if ((newDogInfo.getOther() != null) && !(newDogInfo.getOther().isEmpty())) {
//			foundDog.setOther(newDogInfo.getOther());
//		}
//		
////		private String adoptionstatus;
//		// none, applied, approved, completed
//		if ((newDogInfo.getAdoptionstatus() != null) && !(newDogInfo.getAdoptionstatus().isEmpty())) {
//			foundDog.setAdoptionstatus(newDogInfo.getAdoptionstatus());
//		}
//		
////		private String adopter;
//		if ((newDogInfo.getAdopter() != null) && !(newDogInfo.getAdopter().isEmpty())) {
//			foundDog.setAdopter(newDogInfo.getAdopter());
//		}
		
		Person updatedPerson = personRepo.save(foundPerson);
		
		return ResponseEntity.ok(updatedPerson);
	}
		
	// for updating by name, need to do checking in the front end to ensure that there is only one 
	// OR need to ensure that all names are unique 
	
	// This exists so that a dog can be removed from the database, but will not be easily available, as all should remain in the db, even once they are adopted 
	@DeleteMapping("/removeperson/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable int id) {
		personRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("person not found"));
		
		String message = "person has been deleted";
		personRepo.deleteById(id);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
