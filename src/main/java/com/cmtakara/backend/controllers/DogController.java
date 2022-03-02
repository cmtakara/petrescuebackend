package com.cmtakara.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

