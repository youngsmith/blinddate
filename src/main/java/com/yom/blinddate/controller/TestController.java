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

    @GetMapping("/exist")
    public boolean test2() {
        return testService.isExist();
    }

    @GetMapping("/exception")
    public boolean test3() {
        int a = 0;
        int c = 10/a;
        return true;
    }

    @GetMapping("/farm")
    public String test4() {
        testService.createFarm();
        return "created farm";
    }
}
