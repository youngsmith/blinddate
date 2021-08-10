package com.yom.blinddate.repository;

import com.yom.blinddate.model.TestModel;

import java.util.List;

public interface TestRepository {
    List<TestModel> selectAll();
}
