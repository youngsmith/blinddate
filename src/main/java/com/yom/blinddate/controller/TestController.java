package com.yom.blinddate.controller;

import com.yom.blinddate.model.TestModel;
import com.yom.blinddate.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/")
    public List<TestModel> test() {
        return testService.test();
    }
}
