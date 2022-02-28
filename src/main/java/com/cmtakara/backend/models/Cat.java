package com.cmtakara.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cats")
public class Cat {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String age;
	
	//not in table combine to string age
//	private int catNumAge;
//	private int catAgeUnit;
	
	@Column
	private char vetting;
	
	@Column
	private String imagename;
	
	//don't know how to add the image but it goes here
//  IMAGE
	
	@Column
	private String imageurl;
	
	@Column
	private char bonded;
	
	@Column
	private String foster;
	
	@Column
	private String location;
	
	@Column
	private char chip;
	
	@Column
	private String spayneuter;
	
	@Column
	private String issues;
	
	@Column
	private String other;
	
	@Column
	private String adoptionstatus;
	
	@Column
	private String adopter;

	
//All getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public char getVetting() {
		return vetting;
	}

	public void setVetting(char vetting) {
		this.vetting = vetting;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public char getBonded() {
		return bonded;
	}

	public void setBonded(char bonded) {
		this.bonded = bonded;
	}

	public String getFoster() {
		return foster;
	}

	public void setFoster(String foster) {
		this.foster = foster;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public char getChip() {
		return chip;
	}

	public void setChip(char chip) {
		this.chip = chip;
	}

	public String getSpayneuter() {
		return spayneuter;
	}

	public void setSpayneuter(String spayneuter) {
		this.spayneuter = spayneuter;
	}

	public String getIssues() {
		return issues;
	}

	public void setIssues(String issues) {
		this.issues = issues;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getAdoptionstatus() {
		return adoptionstatus;
	}

	public void setAdoptionstatus(String adoptionstatus) {
		this.adoptionstatus = adoptionstatus;
	}

	public String getAdopter() {
		return adopter;
	}

	public void setAdopter(String adopter) {
		this.adopter = adopter;
	}
	
	
	
	
	
	
}
