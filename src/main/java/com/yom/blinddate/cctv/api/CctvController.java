package com.yom.blinddate.cctv.api;


import com.yom.blinddate.cctv.CctvService;
import com.yom.blinddate.cctv.dto.CctvSourceDiffSearchParams;
import com.yom.blinddate.cctv.entity.CctvSourceDiff;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cctv")
@RequiredArgsConstructor
@Slf4j
public class CctvController {
    private final CctvService cctvService;

    @GetMapping("/source/diff")
    public ResponseEntity<Page<CctvSourceDiff>> getCctvSourceDiffs(CctvSourceDiffSearchParams searchParams,
                                                                   @RequestParam(required = false, defaultValue = "0") int page,
                                                                   @RequestParam(required = false, defaultValue = "10") int size) {

        return ResponseEntity.ok(cctvService.searchCctvSourceDiff(searchParams, PageRequest.of(page, size)));
    }

}
