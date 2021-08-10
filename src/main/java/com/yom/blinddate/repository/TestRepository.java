package com.yom.blinddate.repository;

import com.yom.blinddate.model.TestModel;

import java.util.List;

// @Mapper 어노테이션이 없어도 됨
public interface TestRepository {
    List<TestModel> selectAll();
}
