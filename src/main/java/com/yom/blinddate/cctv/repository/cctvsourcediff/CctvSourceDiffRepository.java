package com.yom.blinddate.cctv.repository.cctvsourcediff;

import com.yom.blinddate.cctv.entity.CctvSourceDiff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CctvSourceDiffRepository
        extends JpaRepository<CctvSourceDiff, Long>, CctvSourceDiffRepositoryCustom {
}
