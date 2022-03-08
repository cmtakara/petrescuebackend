package com.cmtakara.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="people")
public class Person {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String phone;
	
	@Column
	private String address;
	
	@Column
	private String bestcontact;
	
	@Column
	private String notes;
	
	@Column
	private char admin;
	
	@Column
	private char updaterights;
	
	@Column
	private String fosterstatus;
	
	@Column
	private String fosteravailability;
	
	@Column
	private String fostercurrentanimal;
	
	@Column
	private String volunteerstatus;

	@Column
	private String volunteercleaning;
	
	@Column
	private char volunteertransport;
	
	@Column
	private char volunteerevents;
	
	@Column
	private String volunteerother;
	
	@Column
	private String adopterstatus;
	
	@Column
	private String adopteranimaltype;
	
	@Column
	private String adopteranimalname;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBestcontact() {
		return bestcontact;
	}

	public void setBestcontact(String bestcontact) {
		this.bestcontact = bestcontact;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public char getAdmin() {
		return admin;
	}

	public void setAdmin(char admin) {
		this.admin = admin;
	}

	public char getUpdaterights() {
		return updaterights;
	}

	public void setUpdaterights(char updaterights) {
		this.updaterights = updaterights;
	}

	public String getFosterstatus() {
		return fosterstatus;
	}

	public void setFosterstatus(String fosterstatus) {
		this.fosterstatus = fosterstatus;
	}

	public String getFosteravailability() {
		return fosteravailability;
	}

	public void setFosteravailability(String fosteravailability) {
		this.fosteravailability = fosteravailability;
	}

	public String getFostercurrentanimal() {
		return fostercurrentanimal;
	}

	public void setFostercurrentanimal(String fostercurrentanimal) {
		this.fostercurrentanimal = fostercurrentanimal;
	}

	public String getVolunteerstatus() {
		return volunteerstatus;
	}

	public void setVolunteerstatus(String volunteerstatus) {
		this.volunteerstatus = volunteerstatus;
	}

	public String getVolunteercleaning() {
		return volunteercleaning;
	}

	public void setVolunteercleaning(String volunteercleaning) {
		this.volunteercleaning = volunteercleaning;
	}

	public char getVolunteertransport() {
		return volunteertransport;
	}

	public void setVolunteertransport(char volunteertransport) {
		this.volunteertransport = volunteertransport;
	}

	public char getVolunteerevents() {
		return volunteerevents;
	}

	public void setVolunteerevents(char volunteerevents) {
		this.volunteerevents = volunteerevents;
	}

	public String getVolunteerother() {
		return volunteerother;
	}

	public void setVolunteerother(String volunteerother) {
		this.volunteerother = volunteerother;
	}

	public String getAdopterstatus() {
		return adopterstatus;
	}

	public void setAdopterstatus(String adopterstatus) {
		this.adopterstatus = adopterstatus;
	}

	public String getAdopteranimaltype() {
		return adopteranimaltype;
	}

	public void setAdopteranimaltype(String adopteranimaltype) {
		this.adopteranimaltype = adopteranimaltype;
	}

	public String getAdopteranimalname() {
		return adopteranimalname;
	}

	public void setAdopteranimalname(String adopteranimalname) {
		this.adopteranimalname = adopteranimalname;
	}
	
		
}
