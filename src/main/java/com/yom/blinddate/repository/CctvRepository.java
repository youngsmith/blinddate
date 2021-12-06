package com.yom.blinddate.repository;

import com.yom.blinddate.model.entity.Animal;
import com.yom.blinddate.model.entity.Cctv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CctvRepository extends JpaRepository<Cctv, Long> {

}
