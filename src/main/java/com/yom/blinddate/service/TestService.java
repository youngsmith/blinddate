package com.yom.blinddate.service;

import com.yom.blinddate.model.TestModel;
import com.yom.blinddate.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<TestModel> test() {
        return testRepository.selectAll();
    }
}
