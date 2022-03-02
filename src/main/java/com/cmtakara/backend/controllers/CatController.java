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
import com.cmtakara.backend.models.Cat;
import com.cmtakara.backend.repositories.CatRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cats/")
public class CatController {
	
	@Autowired
	private CatRepository catRepo;
	
	// all @GetMapping for cats: allcats, byid, byvetting, (*)byage, byadoptionstatus, (*)needsfoster
// (*)(*)(*)need to add time in THEN bytime 
	@GetMapping("/allcats")
	public List<Cat> getAllCats() {
		return catRepo.findAll();
	}
	
	@GetMapping("/individualcat/{id}")
	public ResponseEntity<Cat> getCatById(@PathVariable int id) {
		Cat cat = catRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cat not found."));
		return ResponseEntity.ok(cat);
	}
	
	@GetMapping("/byvetting/{vetting}")
	public List<Cat> getByVetting(@PathVariable char vetting) {
		List<Cat> cats = catRepo.findByVetting(vetting);
		if(cats.isEmpty()) {
			System.out.println(new ResourceNotFoundException("No cats with vetting status of: " + vetting));
		}
//		return cats;
		return catRepo.findByVetting(vetting);
	}
	
	@GetMapping("/byadoptionstatus/{adoptionstatus}")
	public List<Cat> getByAdoptionstatus(@PathVariable String adoptionstatus) {
		List<Cat> cats = catRepo.findByAdoptionstatus(adoptionstatus);
		if(cats.isEmpty()) {
			System.out.println(new ResourceNotFoundException("No cats with adoption status of: " + adoptionstatus));
		}
//		return cats;
		return catRepo.findByAdoptionstatus(adoptionstatus);
	}
	
//needs foster if foster is NONE
	
//by age - adult or kitten YEARS or !YEARS
	
	
	@PostMapping("addcat")
	public Cat newCat(@RequestBody Cat cat) {
		return catRepo.save(cat);
	}


	@PutMapping("cat/{id}")
	public ResponseEntity<Cat> updateCat(@PathVariable int id, @RequestBody Cat newCatInfo) {
		// Checking that the fields are not empty or null occurs here, but checking the validity of the inputs that are not empty occurs in the front end at the form
		Cat foundCat = catRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("cat not found"));
		
		//checking for null or empty string passed in
		//		private String name;
		if ((newCatInfo.getName() != null) && !(newCatInfo.getName().isEmpty())) {
			foundCat.setName(newCatInfo.getName());
		}

		//		private String age;
		if ((newCatInfo.getAge() != null) && !(newCatInfo.getAge().isEmpty())) {
			foundCat.setAge(newCatInfo.getAge());
		}
		
		//		private char vetting;
		// Y or N
		if ((newCatInfo.getVetting() != '\0') && !(newCatInfo.getVetting() == ' ')) {
			foundCat.setVetting(newCatInfo.getVetting());
		}

		//		private String imagename;
		if ((newCatInfo.getImagename() != null) && !(newCatInfo.getImagename().isEmpty())) {
			foundCat.setImagename(newCatInfo.getImagename());
		}
		
//		//  IMAGE
		
		//		private String imageurl;
		if ((newCatInfo.getImageurl() != null) && !(newCatInfo.getImageurl().isEmpty())) {
			foundCat.setImageurl(newCatInfo.getImageurl());
		}
		
		//		private char bonded;
		// Y or N
		if ((newCatInfo.getBonded() != '\0') && !(newCatInfo.getBonded() == ' ')) {
			foundCat.setBonded(newCatInfo.getBonded());
		}
		
		//		private String foster;
		if ((newCatInfo.getFoster() != null) && !(newCatInfo.getFoster().isEmpty())) {
			foundCat.setFoster(newCatInfo.getFoster());
		}
		
		//		private String location;
		if ((newCatInfo.getLocation() != null) && !(newCatInfo.getLocation().isEmpty())) {
			foundCat.setLocation(newCatInfo.getLocation());
		}
		
		//		private char chip;
		// Y or N
		if ((newCatInfo.getChip() != '\0') && !(newCatInfo.getChip() == ' ')) {
			foundCat.setChip(newCatInfo.getChip());
		}

		//		private String spayneuter;
		// YES, NO, TOO YOUNG, UNKNOWN
		if ((newCatInfo.getSpayneuter() != null) && !(newCatInfo.getSpayneuter().isEmpty())) {
			foundCat.setSpayneuter(newCatInfo.getSpayneuter());
		}
		
		//		private String issues;
		if ((newCatInfo.getIssues() != null) && !(newCatInfo.getIssues().isEmpty())) {
			foundCat.setIssues(newCatInfo.getIssues());
		}
		
		//		private String other;
		// cats, dogs, children
		if ((newCatInfo.getOther() != null) && !(newCatInfo.getOther().isEmpty())) {
			foundCat.setOther(newCatInfo.getOther());
		}
		
//		private String adoptionstatus;
		// none, applied, approved, completed
		if ((newCatInfo.getAdoptionstatus() != null) && !(newCatInfo.getAdoptionstatus().isEmpty())) {
			foundCat.setAdoptionstatus(newCatInfo.getAdoptionstatus());
		}
		
//		private String adopter;
		if ((newCatInfo.getAdopter() != null) && !(newCatInfo.getAdopter().isEmpty())) {
			foundCat.setAdopter(newCatInfo.getAdopter());
		}
		
		Cat updatedCat = catRepo.save(foundCat);

		
		return ResponseEntity.ok(updatedCat);
		

	}
	
	// for updating by name, need to do checking in the front end to ensure that there is only one 
	// OR need to ensure that all names are unique 
	
	// This exists so that a cat can be removed from the database, but will not be easily available, as all should remain in the db, even once they are adopted 
	@DeleteMapping("/removecat/{id}")
	public ResponseEntity<String> deleteCat(@PathVariable int id) {
		catRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("cat not found"));
		
		String message = "cat has been deleted";
		catRepo.deleteById(id);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	
}
