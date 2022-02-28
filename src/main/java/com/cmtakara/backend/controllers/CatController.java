package com.cmtakara.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmtakara.backend.models.Cat;
import com.cmtakara.backend.repositories.CatRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class CatController {
	
	@Autowired
	private CatRepository catRepo;
	
	@GetMapping("/allcats")
	public List<Cat> getAllCats() {
		return catRepo.findAll();
	}

}
