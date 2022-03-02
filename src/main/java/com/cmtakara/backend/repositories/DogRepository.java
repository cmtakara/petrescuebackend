package com.cmtakara.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmtakara.backend.models.Dog;

@Repository
public interface DogRepository extends JpaRepository <Dog, Integer> {

}
