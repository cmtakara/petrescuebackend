package com.cmtakara.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmtakara.backend.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository <Person, Integer> {

	List<Person> findByVolunteerstatus(String string);

	List<Person> findByFosterstatus(String string);

	List<Person> findByAdopterstatus(String adopterstatus);

	
}
