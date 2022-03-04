package com.cmtakara.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmtakara.backend.models.Cat;
import com.cmtakara.backend.models.Dog;

@Repository
public interface DogRepository extends JpaRepository <Dog, Integer> {
	List<Dog> findByVetting(char vetting);

	List<Dog> findByAdoptionstatus(String adoptionstatus);

}
