package com.cmtakara.backend.controllers;

import java.util.List;

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
import com.cmtakara.backend.models.Dog;
import com.cmtakara.backend.repositories.DogRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/dogs/")
public class DogController {

	@Autowired
	private DogRepository dogRepo;
	
	@GetMapping("/alldogs")
	public List<Dog> getAllDogs() {
		return dogRepo.findAll();
	}
	
	@GetMapping("/individualdog/{id}")
	public ResponseEntity<Dog> getDogById(@PathVariable int id) {
		Dog dog = dogRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Dog not found."));
		return ResponseEntity.ok(dog);
	}	
	
	@GetMapping("/byvetting/{vetting}")
	public List<Dog> getByVetting(@PathVariable char vetting) {
		List<Dog> dogs = dogRepo.findByVetting(vetting);
		if(dogs.isEmpty()) {
			System.out.println(new ResourceNotFoundException("No dogs with vetting status of: " + vetting));
		}
		return dogRepo.findByVetting(vetting);
	}	
	
	@GetMapping("/byadoptionstatus/{adoptionstatus}")
	public List<Dog> getByAdoptionstatus(@PathVariable String adoptionstatus) {
		List<Dog> dogs = dogRepo.findByAdoptionstatus(adoptionstatus);
		if(dogs.isEmpty()) {
			System.out.println(new ResourceNotFoundException("No dogs with adoption status of: " + adoptionstatus));
		}
		return dogRepo.findByAdoptionstatus(adoptionstatus);
	}
	
//needs foster if foster is NONE
	
//by age - adult or puppy YEARS or !YEARS
	
	@PostMapping("adddog")
	public Dog newDog(@RequestBody Dog dog) {
		return dogRepo.save(dog);
	}

	@PutMapping("dog/{id}")
	public ResponseEntity<Dog> updateDog(@PathVariable int id, @RequestBody Dog newDogInfo) {
		// Checking that the fields are not empty or null occurs here, but checking the validity of the inputs that are not empty occurs in the front end at the form
		Dog foundDog = dogRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("dog not found"));
		
		//checking for null or empty string passed in
		//		private String name;
		if ((newDogInfo.getName() != null) && !(newDogInfo.getName().isEmpty())) {
			foundDog.setName(newDogInfo.getName());
		}

		//		private String age;
		if ((newDogInfo.getAge() != null) && !(newDogInfo.getAge().isEmpty())) {
			foundDog.setAge(newDogInfo.getAge());
		}
		
		//		private char vetting;
		// Y or N
		if ((newDogInfo.getVetting() != '\0') && !(newDogInfo.getVetting() == ' ')) {
			foundDog.setVetting(newDogInfo.getVetting());
		}

		//		private String imagename;
		if ((newDogInfo.getImagename() != null) && !(newDogInfo.getImagename().isEmpty())) {
			foundDog.setImagename(newDogInfo.getImagename());
		}
		
//		//  IMAGE
		
		//		private String imageurl;
		if ((newDogInfo.getImageurl() != null) && !(newDogInfo.getImageurl().isEmpty())) {
			foundDog.setImageurl(newDogInfo.getImageurl());
		}
		
		//		private char bonded;
		// Y or N
		if ((newDogInfo.getBonded() != '\0') && !(newDogInfo.getBonded() == ' ')) {
			foundDog.setBonded(newDogInfo.getBonded());
		}
		
		//		private String foster;
		if ((newDogInfo.getFoster() != null) && !(newDogInfo.getFoster().isEmpty())) {
			foundDog.setFoster(newDogInfo.getFoster());
		}
		
		//		private String location;
		if ((newDogInfo.getLocation() != null) && !(newDogInfo.getLocation().isEmpty())) {
			foundDog.setLocation(newDogInfo.getLocation());
		}
		
		//		private char chip;
		// Y or N
		if ((newDogInfo.getChip() != '\0') && !(newDogInfo.getChip() == ' ')) {
			foundDog.setChip(newDogInfo.getChip());
		}

		//		private String spayneuter;
		// YES, NO, TOO YOUNG, UNKNOWN
		if ((newDogInfo.getSpayneuter() != null) && !(newDogInfo.getSpayneuter().isEmpty())) {
			foundDog.setSpayneuter(newDogInfo.getSpayneuter());
		}
		
		//		private String issues;
		if ((newDogInfo.getIssues() != null) && !(newDogInfo.getIssues().isEmpty())) {
			foundDog.setIssues(newDogInfo.getIssues());
		}
		
		//		private String other;
		// cats, dogs, children
		if ((newDogInfo.getOther() != null) && !(newDogInfo.getOther().isEmpty())) {
			foundDog.setOther(newDogInfo.getOther());
		}
		
//		private String adoptionstatus;
		// none, applied, approved, completed
		if ((newDogInfo.getAdoptionstatus() != null) && !(newDogInfo.getAdoptionstatus().isEmpty())) {
			foundDog.setAdoptionstatus(newDogInfo.getAdoptionstatus());
		}
		
//		private String adopter;
		if ((newDogInfo.getAdopter() != null) && !(newDogInfo.getAdopter().isEmpty())) {
			foundDog.setAdopter(newDogInfo.getAdopter());
		}
		
		Dog updatedDog = dogRepo.save(foundDog);
		
		return ResponseEntity.ok(updatedDog);
	}
		
	// for updating by name, need to do checking in the front end to ensure that there is only one 
	// OR need to ensure that all names are unique 
	
	// This exists so that a dog can be removed from the database, but will not be easily available, as all should remain in the db, even once they are adopted 
	@DeleteMapping("/removedog/{id}")
	public ResponseEntity<String> deleteDog(@PathVariable int id) {
		dogRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("dog not found"));
		
		String message = "dog has been deleted";
		dogRepo.deleteById(id);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}

