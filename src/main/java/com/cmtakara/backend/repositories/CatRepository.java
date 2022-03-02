package com.cmtakara.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmtakara.backend.models.Cat;

@Repository
public interface CatRepository extends JpaRepository <Cat, Integer>{
	List<Cat> findByVetting(char vetting);

	List<Cat> findByAdoptionstatus(String adoptionstatus);
}
