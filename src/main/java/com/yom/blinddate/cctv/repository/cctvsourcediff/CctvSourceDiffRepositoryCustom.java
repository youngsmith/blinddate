package com.yom.blinddate.cctv.repository.cctvsourcediff;

import com.yom.blinddate.cctv.dto.CctvSourceDiffSearchParams;
import com.yom.blinddate.cctv.entity.CctvSourceDiff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CctvSourceDiffRepositoryCustom {
    Page<CctvSourceDiff> searchBy(CctvSourceDiffSearchParams searchParams, PageRequest pageRequest);
}
