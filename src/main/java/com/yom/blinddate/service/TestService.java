package com.yom.blinddate.service;

import com.yom.blinddate.model.TestModel;
import com.yom.blinddate.model.entity.Farm;
import com.yom.blinddate.repository.AnimalRepository;
import com.yom.blinddate.repository.FarmRepository;
import com.yom.blinddate.repository.TestRepository;
import com.yom.blinddate.repository.TestTwoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {
    private final TestRepository testRepository;
    private final TestTwoRepository testTwoRepository;
    private final FarmRepository farmRepository;
    private final AnimalRepository animalRepository;

    public List<TestModel> test() {
        return testRepository.selectAll();
    }
    public boolean isExist() {
        return testTwoRepository.isExist();
    }
    public void createFarm() {
        Farm farm = new Farm().setOwner("qqq")
            .setName("www")
            .setId(100L);

        Farm farm2 = farmRepository.save(farm);
        log.info("{}", farm2);
    }

    public void testJpa() {

    }
}
