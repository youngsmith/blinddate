package com.yom.blinddate.service;

import com.yom.blinddate.model.TestModel;
import com.yom.blinddate.repository.TestRepository;
import com.yom.blinddate.repository.TestTwoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final TestTwoRepository testTwoRepository;

    public List<TestModel> test() {
        return testRepository.selectAll();
    }
    public boolean isExist() {
        return testTwoRepository.isExist();
    }
}
