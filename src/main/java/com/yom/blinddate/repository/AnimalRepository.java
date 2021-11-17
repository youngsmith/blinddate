package com.yom.blinddate.repository;

import com.yom.blinddate.model.entity.Animal;
import com.yom.blinddate.model.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
