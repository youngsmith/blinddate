package com.yom.blinddate.cctv;
import com.yom.blinddate.cctv.dto.CctvSourceDiffSearchParams;
import com.yom.blinddate.cctv.entity.CctvSourceDiff;
import com.yom.blinddate.cctv.repository.cctvsourcediff.CctvSourceDiffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CctvService {
    private final CctvSourceDiffRepository cctvSourceDiffRepository;

    public Page<CctvSourceDiff> searchCctvSourceDiff(CctvSourceDiffSearchParams searchParams, PageRequest pageRequest) {
        return cctvSourceDiffRepository.searchBy(searchParams, pageRequest);
    }

}
